package com.yungo.controller;

import com.yungo.entity.User;
import com.yungo.service.UserService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cx on 17-8-2.
 */
/*让这个类都返回json*/
@RestController
public class Mycontroller {

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public String test(){
     throw new RuntimeException();
        //return "seccuces";
    }


    @RequestMapping("find")
    public Map ByUsername(){
        User user = userService.findByUsername("admin");
        Map map = new HashMap();
        map.put("user",user);
        return map;
    }
}
