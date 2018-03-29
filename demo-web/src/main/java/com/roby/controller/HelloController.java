package com.roby.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Tao Pingping on 2018/3/20.
 */


@RestController
public class HelloController {

    @RequestMapping("hello")
    public String sayHello() {
        return "Hello Roby";
    }
    @RequestMapping("hello2")
    public String sayHello2() {
        return "Hello Roby 2";
    }
    @RequestMapping("hello3")
    public String sayHello3() {
        return "Hello Roby 3";
    }

}
