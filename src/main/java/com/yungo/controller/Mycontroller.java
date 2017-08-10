package com.yungo.controller;

import com.yungo.dto.JsonResult;
import com.yungo.entity.Commodity;
import com.yungo.entity.ShopCar;
import com.yungo.entity.User;
import com.yungo.service.CommodityService;
import com.yungo.service.UserService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.security.auth.Subject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cx on 17-8-2.
 */
/*让这个类都返回json*/
@RestController
public class Mycontroller {

    @Autowired
    private CommodityService commodityService;

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public String test(){
     throw new RuntimeException();
        //return "seccuces";
    }


/*    @RequestMapping("/find")
    public Map ByUsername(){
        User user = userService.findByUsername("admin");
        Map map = new HashMap();
        map.put("user",user);
        return map;
    }*/


    @RequestMapping("/list")
    public JsonResult findAll(){
     List list = commodityService.findAll();
        return  new JsonResult(true,list);
    }

    @RequestMapping("/showShopCar")
    public JsonResult shopcart(HttpServletRequest request){
        Cookie[] cookies= request.getCookies();
        HashMap<String, ShopCar> map= new HashMap ();
        if(null!=cookies){
            for(Cookie c:cookies){
                String str = c.getName();
                if("shop".equals(str)) {
                    String[] strs =  c.getValue().split("_");
                    System.out.println(strs);

                    for(int i=0;i<strs.length;i++) {
                        if (i == 0) {
                            continue;
                        }

                            int count =0;
                        if(null!=map.get(strs[i])){
                            count = map.get(strs[i]).getCount();
                        }
                            map.put(strs[i], new ShopCar(Integer.parseInt(strs[i]), ++count));
                        }


                }

            }
        }
        List list = new ArrayList();
        for(Entry<String, ShopCar> entry: map.entrySet()){
           ShopCar shopCar = entry.getValue();
           int id = shopCar.getId();
           Commodity commodity = commodityService.findById(id);
           shopCar.setCommodity(commodity);
           list.add(shopCar);
        }
        return new JsonResult(true,list);
    }

    @RequestMapping("/toReg")
    public JsonResult toReg(User user, @Param("code") String code){
        System.out.println(user);
        System.out.println(code);
        userService.createUser(user);
        return new JsonResult(true,"注册成功");
    }


}
