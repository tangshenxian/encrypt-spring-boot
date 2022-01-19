package com.shenxian.starter.demo.controller;

import com.shenxian.starter.annotation.Decrypt;
import com.shenxian.starter.annotation.Encrypt;
import com.shenxian.starter.demo.pojo.User;
import com.shenxian.starter.utils.RespBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: shenxian
 * @date: 2022/1/19 10:39
 */
@RestController
public class HelloController {

    private static User user = new User("测试用户", 18, "仅供测试使用！");

    /**
     * 不加密
     * @return
     */
    @GetMapping("/getUser")
    public RespBean getUser() {
        return RespBean.success().data(user);
    }

    /**
     * 加密
     * @return
     */
    @GetMapping("/getEncryptUser")
    @Encrypt
    public RespBean getEncryptUser() {
        return RespBean.success().data(user);
    }

    /**
     * 解密
     * @param user
     * @return
     */
    @PostMapping("/addUser")
    public RespBean addUser(@RequestBody @Decrypt User user) {
        System.out.println("user:" + user);
        return RespBean.success().data(user);
    }

}
