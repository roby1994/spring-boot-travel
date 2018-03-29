package com.roby.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by Tao Pingping on 2018/3/21.
 */

@Controller
@RequestMapping("/freemarker")
public class FreemarkerController {

    @RequestMapping("/hello")
    public String hello(Map<String,Object> map) {
        map.put("msg", "Hello Freemarker");
        map.put("name", "Roby");
        return "aaa";
    }
}
