package ru.sertok.spring.jdbc.controllers.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import ru.sertok.spring.jdbc.dao.api.UserDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleUsersController implements Controller {

    @Autowired
    private UserDao userDao;

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        if (httpServletRequest.getMethod().equals("GET")){
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("users");
            modelAndView.addObject("users",userDao.findAll());
            return modelAndView;
        }
            return null;
    }
}
