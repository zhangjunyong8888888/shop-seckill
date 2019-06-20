package com.study.controller;


import com.study.bean.po.User;
import com.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String toList(User user, Model model){
        model.addAttribute("user",user);
        return "goods_list";
    }

}
