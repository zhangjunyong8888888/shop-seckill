package com.study.controller;


import com.study.bean.po.User;
import com.study.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("user")
public class UserController {

    /**
     * 1000 线程 393qps
     *
     * @param user
     * @return
     */
    @GetMapping("info")
    @ResponseBody
    public Result<User> getUserInfo(User user) {
        return Result.success(user);
    }
}
