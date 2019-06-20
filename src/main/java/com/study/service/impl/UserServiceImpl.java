package com.study.service.impl;


import com.study.bean.param.LoginParam;
import com.study.bean.po.User;
import com.study.dao.UserDao;
import com.study.exception.GlobalException;
import com.study.redis.RedisService;
import com.study.redis.UserKey;
import com.study.service.UserService;
import com.study.utils.MD5Util;
import com.study.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import static com.study.result.CodeMsg.MOBILE_NOT_EXIST;
import static com.study.result.CodeMsg.PASSWORD_ERROR;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RedisService redisService;


    @Override
    public User getById(Long userId) {
        return userDao.getById(userId);
    }

    @Override
    public User getByToken(HttpServletResponse response,
                           String token) {
        User user=redisService.get(UserKey.token, token, User.class);
        if(user != null){
            addUserCookie(response,user,token);
        }
        return user;
    }

    @Override
    public Integer insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public boolean login(HttpServletResponse response,
                         LoginParam loginParam) {
        User user = userDao.getByMobile(loginParam.getMobile());
        if(user == null){
            throw new GlobalException(MOBILE_NOT_EXIST);
        }
        if(!MD5Util.validatedPassword(loginParam.getPassword(),user.getPassword(),user.getSalt())){
            throw new GlobalException(PASSWORD_ERROR);
        }
        String token = UUIDUtil.uuid();
        addUserCookie(response, user, token);
        return true;
    }

    private void addUserCookie(HttpServletResponse response, User user, String token) {
        redisService.set(UserKey.token, token, user);
        Cookie cookie = new Cookie(UserKey.TOKEN_NAME,token);
        cookie.setMaxAge(UserKey.TOKEN_EXPIRE);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
