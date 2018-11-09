package ru.sertok.spring.jdbc.controllers.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import ru.sertok.spring.jdbc.dao.api.UserDao;
import ru.sertok.spring.jdbc.utils.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SimpleLoginController implements Controller {
    @Autowired
    private UserDao userDao;

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        switch (httpServletRequest.getMethod()) {
            case "GET":
                ModelAndView modelAndView = new ModelAndView();
                modelAndView.setViewName("signIn");
                return modelAndView;
            case "POST":
                String name = Utils.decode(httpServletRequest.getParameter("name"));
                String password = httpServletRequest.getParameter("password");
                if (userDao.isExist(name, password)) {
                    HttpSession session = httpServletRequest.getSession();
                    session.setAttribute("user", name);
                    httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/users");
                } else
                    httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login");
            default:
                return null;
        }
    }
}
