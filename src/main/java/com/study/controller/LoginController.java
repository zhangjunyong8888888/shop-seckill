package com.study.controller;


import com.study.bean.param.LoginParam;
import com.study.result.Result;
import com.study.service.UserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/login")
@Log
public class LoginController {

    @Autowired
    private UserService userService;


    /**
     * 跳转登录页面
     * @return
     */
    @GetMapping({"/",""})
    public String toLogin(){
        return "login";
    }

    @PostMapping({"/",""})
    @ResponseBody
    public Result doLogin(HttpServletResponse response,
                          @Validated LoginParam loginParam){
        return Result.success(userService.login(response,loginParam));
    }



}
