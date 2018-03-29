package com.roby.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.support.spring.annotation.FastJsonFilter;

import java.util.Date;

/**
 * Created by Tao Pingping on 2018/3/21.
 */
public class User {

    private Integer id;

    private String username;

    private String password;

    @JSONField(format="yyyy-MM-ddd")
    private Date birthday;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
