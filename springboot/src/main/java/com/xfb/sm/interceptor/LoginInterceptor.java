package com.xfb.sm.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * className:LoginInterceptor
 * describe:
 * author:邢芳彬
 * createTime:2018-11-10 16:38
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //进入业务之前的方法
        System.out.println("进入业务之前经过了过滤器。。。。");
        /*HttpSession session = request.getSession();
        if ("admin".equals(session.getAttribute("username")) && "admin".equals(session.getAttribute("pass"))) {
            return true;
        } else {
            response.sendRedirect("/sb/toLogin");
            return false;
        }*/
        //为ture继续运行

        return  true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("视图渲染之前的方法。。。。");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("无论如何都执行的方法。。。");
    }
}
