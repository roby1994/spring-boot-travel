package com.roby.controller;

import com.roby.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by Tao Pingping on 2018/3/21.
 */

@Controller
@RequestMapping("fastjson")
public class FastjsonController {

    @RequestMapping("user")
    @ResponseBody
    public User user() {
        User user = new User();
        user.setId(1);
        user.setUsername("taopp");
        user.setPassword("taopp_2012");
        user.setBirthday(new Date());
        // 模拟异常
        //   int i = 1/0;
        return user;
    }
}
