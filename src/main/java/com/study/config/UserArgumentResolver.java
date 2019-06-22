package com.study.config;


import com.study.bean.po.User;
import com.study.redis.UserKey;
import com.study.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UserArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private UserService userService;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        Class<?> clazz = methodParameter.getNestedParameterType();
        return clazz == User.class;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest request =nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        HttpServletResponse response =nativeWebRequest.getNativeResponse(HttpServletResponse.class);

        String paramToken = request.getParameter(UserKey.TOKEN_NAME);
        String cookieToken = getCookieValue(request, UserKey.TOKEN_NAME);
        String token = StringUtils.isNotBlank(paramToken) ? paramToken : cookieToken;
        if(StringUtils.isBlank(token)){
            return null;
        }
        return userService.getByToken(response,token);
    }

    private String getCookieValue(HttpServletRequest request, String tokenName) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(tokenName)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}
