package com.mate.trackq.controllers;

import com.mate.trackq.model.Project;
import com.mate.trackq.model.User;
import com.mate.trackq.service.MailService;
import com.mate.trackq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
//    private final UserService userService;

    @Autowired
    private MailService mailService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView LogInPage() {
        return new ModelAndView("login", "user", new User());
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration() {
        return new ModelAndView("signup", "user", new User());
    }
//todo
    @RequestMapping(value = "/registrationByLink", method = RequestMethod.GET)
    public ModelAndView registration(@RequestParam("project") String projectName) {
        ModelAndView mv = new ModelAndView("signup", "user", new User());
        mv.addObject("projectName", projectName);
        return mv;
    }


    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registration(HttpServletRequest request, @ModelAttribute User user) {
        ModelAndView mv = new ModelAndView();
        userService.create(user);
        mailService.sendConfirmRegistrationEmail(user, request.getServerName());
        return mv;
    }
//todo
    @RequestMapping(value = "/registrationByLink", method = RequestMethod.POST)
    public ModelAndView registration(HttpServletRequest request, @ModelAttribute User user, @RequestParam("project") String projectName) {
        ModelAndView mv = new ModelAndView();
        userService.create(user);
        mailService.sendConfirmRegistrationEmail(user, request.getServerName());
        return mv;
    }

}
