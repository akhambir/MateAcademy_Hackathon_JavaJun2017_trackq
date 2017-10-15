package com.mate.trackq.controllers;

import com.mate.trackq.exception.EmailExistsException;
import com.mate.trackq.exception.UsernameExistsException;
import com.mate.trackq.model.User;
import com.mate.trackq.service.MailService;
import com.mate.trackq.service.ProjectService;
import com.mate.trackq.service.UserService;
import com.mate.trackq.util.DomainUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage(@RequestParam(value = "error", required = false) String error,
                                  @RequestParam(value = "logout", required = false) String logout) {
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
    public ModelAndView signUpPage() {
        return new ModelAndView("signup", "user", new User());
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signUp(HttpServletRequest request, @RequestBody User user) {
        User savedUser = userService.addNewUser(user);

        userService.sendConfirmationEmail(savedUser, DomainUtils.getUrl(request));
        return "redirect:/login";
    }

    //TODO Check username on frontend
    @ExceptionHandler(UsernameExistsException.class)
    public ModelAndView usernameExistsHandler() {
        return new ModelAndView("signup", "error", "Username already exists.");
    }

    //TODO Check email on frontend
    @ExceptionHandler(EmailExistsException.class)
    public ModelAndView emailExistsHandler() {
        return new ModelAndView("signup", "error", "Email already exists.");
    }
}
