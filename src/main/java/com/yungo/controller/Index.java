package com.yungo.controller;

import com.mustpay.config.MustpayConfig;
import com.mustpay.util.PayInfo;
import com.yungo.dto.JsonResult;
import com.yungo.entity.User;
import com.yungo.service.CommodityService;
import com.yungo.service.UserService;
import com.yungo.util.MyUtil;
import java.net.HttpCookie;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisKeyValueTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by cx on 17-8-3.
 */
@Controller
public class Index {


    @Autowired
    private CommodityService commodityService;
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index(Model model){
        /*Map map = new HashMap<>();
        map.put("a",1);
        map.put("b",2);
        */
        List list = commodityService.findAll();
        model.addAttribute("data",list);
        model.addAttribute("b",2);
        return "index";
    }



    @RequestMapping("/shopcar")
    public String shopcar(){
        return "shopcar";
    }


    @RequestMapping("/setAccounts")
    public String setAccounts(HttpServletRequest request,Model model) {
        Map<String,String[]> map = request.getParameterMap();
        for(Entry<String,String[]> entry:map.entrySet()){
           int id = Integer.parseInt(entry.getKey());
           int count  = Integer.parseInt(entry.getValue()[0]);
            System.out.println(id+"  " +count);
        }
        /*从sessionId里寻找用户名，以防cookie的用户是篡改过的*/
        HttpSession session =request.getSession();
     /*  User user =  userService.findBySessionId(session.getId());*/
       /*然后用户名密码认证shiro*/
       /*接着就是生成订单号，计算商品总价*/
        //out_trade_no 商户订单号，商户网站订单系统中唯一订单号，必填
        //subject 商品名称，必填
        //String total_fee付款金额，必填（单位：分）
        //用户id  phone代替
   String  payId =  PayInfo.pay("123456","苹果手机","1","13661572966");
  model.addAttribute("payId",payId);
        System.out.println(payId);
  model.addAttribute("appsId", MustpayConfig.APPS_ID);
      return "/mustpay/selPayType";
    }


    /*注册*/
    @RequestMapping("/reg")
    public String reg(){
        return "reg";
    }


    /*登录*/
    @RequestMapping("/login")
    public String login(){
        return "login";
    }



    @RequestMapping("/toLogin")
    public String toLogin(@Param("phone") String phone, @Param("password") String password, Model model){
        org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken =
                new UsernamePasswordToken(phone, password);
        try {
            subject.login(usernamePasswordToken);
        }catch (AuthenticationException e){
            model.addAttribute("data","帐号或密码错误");
            return "index";
        }

        return "index";
    }
}

