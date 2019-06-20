package com.study.service;


import com.study.bean.param.LoginParam;
import com.study.bean.po.User;

import javax.servlet.http.HttpServletResponse;


public interface UserService {

    User getById(Long userId);

    User getByToken(HttpServletResponse response,
                    String token);

    Integer insert(User user);

    /**
     * 用户登录
     * @param loginParam
     * @return
     */
    boolean login(HttpServletResponse response, LoginParam loginParam);
}
