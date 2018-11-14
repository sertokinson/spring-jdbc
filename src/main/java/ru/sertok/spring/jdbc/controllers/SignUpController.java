package ru.sertok.spring.jdbc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.sertok.spring.jdbc.dao.api.UserDao;
import ru.sertok.spring.jdbc.model.User;
import ru.sertok.spring.jdbc.utils.Utils;

import java.sql.Date;

@Controller
@RequestMapping(path = "/signUp")
public class SignUpController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView get() {
        return new ModelAndView("signUp");
    }

    @RequestMapping(method = RequestMethod.POST)
    public String post(User user) {
        userDao.save(user);
        return "redirect:/users";
    }
}
