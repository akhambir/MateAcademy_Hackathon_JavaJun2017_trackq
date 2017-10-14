package com.mate.trackq.controllers;

import com.mate.trackq.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
//    private final UserService userService;

    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    @RequestMapping("/login")
    public ModelAndView LogInPage() {
        return new ModelAndView("login", "user", null);
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView LogInAction(@ModelAttribute("user") User user) {
//        user=userService.findUser(user.getUserName(), TomcatFactory.md5Custom(user.getPassword(),logger));
        return new ModelAndView("home", "user", user);
    }
}
