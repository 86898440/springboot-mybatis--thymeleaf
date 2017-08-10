package com.yungo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by cx on 17-8-10.
 */

@Controller
@RequestMapping("/mustpay")
public class MustPayControler {
    @RequestMapping("/")
    public String mustpay(){
        return "/mustpay/index";
    }

    @RequestMapping("/selPayType")
    public String selPayType(){
        return "/mustpay/selPayType";
    }
}
