package com.lai.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lailai on 2017/9/21.
 */
@Controller
public class HelloController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
