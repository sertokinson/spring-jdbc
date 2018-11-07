package ru.sertok.spring.jdbc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import ru.sertok.spring.jdbc.dao.api.UserDao;
import ru.sertok.spring.jdbc.model.User;
import ru.sertok.spring.jdbc.utils.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

public class SignUpController implements Controller {

    @Autowired
    private UserDao userDao;

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        switch (httpServletRequest.getMethod()) {
            case "GET":
                ModelAndView modelAndView = new ModelAndView();
                modelAndView.setViewName("signUp");
                return modelAndView;
            case "POST":
                String name = Utils.decode(httpServletRequest.getParameter("name"));
                String password = httpServletRequest.getParameter("password");
                Date birthDate = Date.valueOf(httpServletRequest.getParameter("birthDate"));
                userDao.save(User.builder().name(name).password(Utils.hash(password)).birthDate(birthDate).build()
                );
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/users");
            default:
                return null;
        }
    }
}
