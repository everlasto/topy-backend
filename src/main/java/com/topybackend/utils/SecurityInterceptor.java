package com.topybackend.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by prashanth.a on 18/03/15.
 */
public class SecurityInterceptor implements HandlerInterceptor {

    private static final ConfigService configService  = new ConfigService();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //TODO verify by passing AUTH_TOKEN IN THE HEADER.. This is stupid check.
        return !(configService.getBoolConfig("client.auth")) || (request.getQueryString().contains("xkey") && request.getQueryString().contains("xkey="+configService.getStringConfig("client.exchangekey", "")));
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

}
