package ru.sertok.spring.jdbc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.sertok.spring.jdbc.dao.api.UserDao;


@Controller
@RequestMapping(path = "/signIn")
public class SignInController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView get() {
        return new ModelAndView("signIn");
    }

    @RequestMapping(method = RequestMethod.POST)
    public String post(@RequestParam("name") String name, @RequestParam("password") String password) {
        if (userDao.isExist(name, password))
            return "redirect:/users";
        return "redirect:/login";
    }
}
