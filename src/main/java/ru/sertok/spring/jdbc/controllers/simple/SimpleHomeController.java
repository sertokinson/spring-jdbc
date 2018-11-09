package ru.sertok.spring.jdbc.controllers.simple;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleHomeController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        switch (httpServletRequest.getMethod()) {
            case "GET":
                ModelAndView modelAndView = new ModelAndView();
                modelAndView.setViewName("home");
                return modelAndView;
            case "POST":
                String signIn = httpServletRequest.getParameter("signIn");
                String registration = httpServletRequest.getParameter("registration");
                if ("signIn".equals(signIn))
                    httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login");
                if ("registration".equals(registration))
                    httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/signUp");
            default:
                return null;
        }
    }
}
