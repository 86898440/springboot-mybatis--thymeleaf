package com.yungo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by cx on 17-8-3.
 */
@Controller
public class Index {
    @RequestMapping("/")
    public String index(){
        System.out.println(1);
        return "index";
    }
}
