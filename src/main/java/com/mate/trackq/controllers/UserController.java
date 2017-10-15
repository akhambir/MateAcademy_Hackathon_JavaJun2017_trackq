package com.mate.trackq.controllers;

import com.mate.trackq.model.Project;
import com.mate.trackq.model.Role;
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

    @Autowired
    private MailService mailService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage(@RequestParam(value = "error",required = false) String error,
                                  @RequestParam(value = "logout",	required = false) String logout) {
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username or password.");
        }

        if (logout != null) {
            model.addObject("message", "Logged out successfully.");
        }

        model.setViewName("login");
        return model;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView registration() {
        return new ModelAndView("signup", "user", new User());
    }

    @RequestMapping(value = "/signupByLink", method = RequestMethod.GET)
    public ModelAndView registration(@RequestParam("projectName") String projectName,
                                     @RequestParam("projectCreatorHash") String projectCreatorHash ) {
        ModelAndView mv = new ModelAndView("signup", "user", new User());
        mv.addObject("projectName", projectName);
        mv.addObject("projectCreatorHash", projectCreatorHash);
        return mv;
    }


    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView registration(HttpServletRequest request, @ModelAttribute User user) {
        ModelAndView mv = new ModelAndView();
        mailService.sendConfirmRegistrationEmail(userService.create(user), request.getServerName());
        return mv;
    }
//todo
    @RequestMapping(value = "/signupByLink", method = RequestMethod.POST)
    public ModelAndView registration(HttpServletRequest request, @ModelAttribute User user, @RequestParam("project") String projectName) {
        ModelAndView mv = new ModelAndView();
        userService.create(user);
        mailService.sendConfirmRegistrationEmail(user, request.getServerName());
        return mv;
    }
}
