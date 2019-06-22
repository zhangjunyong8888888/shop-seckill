package com.study.service;


import com.study.bean.param.LoginParam;
import com.study.bean.po.User;

import javax.servlet.http.HttpServletResponse;


public interface UserService {

    /**
     * 根据userId获取用户信息
     *
     * @param userId
     * @return
     */
    User getById(Long userId);

    /**
     * 根据token获取用户信息，若用户存在，刷新用户的token时间
     *
     * @param response
     * @param token
     * @return
     */
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
