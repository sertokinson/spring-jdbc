package ru.sertok.spring.jdbc.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.sertok.spring.jdbc.dao.api.UserDao;

import java.util.Collections;

@Controller
public class UsersController {
    @Autowired
    private UserDao userDao;

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public ModelAndView getUsers() {
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("users", userDao.findAll());
        return modelAndView;
    }

    @RequestMapping(path = "/users/{id}", method = RequestMethod.GET)
    public ModelAndView getUser(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("users");
        userDao.find(id).ifPresent(user -> modelAndView.addObject("users", Collections.singletonList(user)));
        return modelAndView;
    }
}
