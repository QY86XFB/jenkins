package com.xfb.sm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * className:LoginController
 * describe:
 * author:邢芳彬
 * createTime:2018-11-12 09:11
 */
@Controller
public class LoginController {

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/login")
    public void login(@RequestParam Map map, HttpServletRequest request, HttpServletResponse response) {

        if ("admin".equals(map.get("username")) && "admin".equals(map.get("pass"))) {
            try {
                HttpSession session = request.getSession();
                session.setAttribute("username", map.get("username"));
                session.setAttribute("pass", map.get("pass"));
                response.sendRedirect("emp/toList");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                response.sendRedirect("toLogin");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
