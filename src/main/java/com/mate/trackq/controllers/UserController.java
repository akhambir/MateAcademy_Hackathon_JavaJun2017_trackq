package com.mate.trackq.controllers;

import com.mate.trackq.exception.EmailExistsException;
import com.mate.trackq.exception.UsernameExistsException;
import com.mate.trackq.model.Project;
import com.mate.trackq.model.User;
import com.mate.trackq.service.ProjectService;
import com.mate.trackq.service.UserService;
import com.mate.trackq.util.DomainUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView profilePage(Principal principal){
        User user = userService.findByUsername(principal.getName());
        ModelAndView mv = new ModelAndView("profile", "user", user);
        return mv;
    }

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
    public ModelAndView signUpPage(@RequestParam(value = "projectId", required = false, defaultValue = "null")
                                           String projectId) {
        ModelAndView mv = new ModelAndView("signup", "user", new User());
        if (!projectId.equals("null")) {
            mv.addObject("projectId", projectId);
        }
        return mv;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signUp(HttpServletRequest request,
                         @ModelAttribute User user,
                         @RequestParam(value = "projectId", required = false, defaultValue = "null")
                                 String projectId) {
        if (!projectId.equals("null")) {
            Project project = projectService.getById(Long.parseLong(projectId));
            user.addProject(project);
        }
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

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView forgotPassword(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        userService.sendChangePasswordURL(user);
        return new ModelAndView("login", "message",
                "Change Password confirmation sent on your email.");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/change-password/{secret}")
    public ModelAndView changePasswordPage(@PathVariable String secret, Principal principal, HttpServletResponse response)
            throws IOException {
        User user = userService.findByUsername(principal.getName());
        if (user != null && userService.checkChangePasswordSecret(user, secret)) {
            return new ModelAndView("setNewPassword", "user", user);
        } else {
            response.sendError(404);
            return null;
        }
    }
}
