package com.mate.trackq.controllers;

import com.mate.trackq.model.Project;
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
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ProjectService projectService;

    @Autowired
    private MailService mailService;

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

    @RequestMapping(value = "/signup", method = GET)
    public ModelAndView signUpPage(@RequestParam(value = "projectId", required = false, defaultValue = "null")
                                           String projectId) {
        ModelAndView mv = new ModelAndView("signup", "user", new User());
        if (!projectId.equals("null")) {
            mv.addObject("projectId", projectId);
        }
        return mv;
    }

    @RequestMapping(value = "/signup", method = POST)
    public String signUp(HttpServletRequest request, @ModelAttribute User user,
                         @RequestParam(required = false) String projectId) {
        if (projectId != null) {
            Project project = projectService.getById(Long.parseLong(projectId));
            user.addProject(project);
        }
        User savedUser = userService.addNewUser(user);
        userService.sendConfirmationEmail(savedUser, DomainUtils.getUrl(request));
        return "redirect:/login";
    }

    @RequestMapping(method = GET, value = "/forgot-password")
    public String forgotPasswordPage() {
        return "remindPassword";
    }

    @RequestMapping(method = POST, value = "/forgot-password")
    public ModelAndView forgotPassword(@RequestParam String email, HttpServletRequest request) {
        User user = userService.findByEmail(email);
        if (user != null) {
            mailService.sendNewPasswordEmail(user, DomainUtils.getUrl(request));
        }
        ModelAndView mv = new ModelAndView("remindPassword");
        mv.addObject("message", "Change Password confirmation sent on your email.");
        return mv;
    }

    @RequestMapping(method = GET, value = "/change-password/{secret}")
    public ModelAndView changePasswordPage(@PathVariable String secret, HttpServletResponse response)
            throws IOException {
        User user = userService.retrieveUserFromSecret(secret);
        if (user != null) {
            return new ModelAndView("setNewPassword", "secret", secret);
        } else {
            response.sendError(404);
            return null;
        }
    }

    //TODO Need test
    @RequestMapping(method = POST, value = "/change-password/{secret}")
    public ModelAndView changePassword(@PathVariable String secret, @RequestParam String password,
                                       HttpServletResponse response) throws IOException {
        User user = userService.retrieveUserFromSecret(secret);
        if (user != null) {
            userService.changePassword(user, password);
            return new ModelAndView("login", "message", "Your password has been change.");
        } else {
            response.sendError(404);
            return null;
        }
    }
}
