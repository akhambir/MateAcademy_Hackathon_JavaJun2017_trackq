package com.mate.trackq.controllers;

import com.mate.trackq.model.User;
import com.mate.trackq.service.MailService;
import com.mate.trackq.service.ProjectService;
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
    @Autowired
    private ProjectService projectService;

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
    public ModelAndView registration(@RequestParam(value = "projectId", required = false) String projectId) {
        ModelAndView mv = new ModelAndView("signup", "user", new User());
        if (projectId != null) {
            mv.addObject("projectId", projectId);
        }
        return mv;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView registration(HttpServletRequest request, @ModelAttribute User user, @RequestParam(value = "projectId", required = false) String projectId) {
        ModelAndView mv = new ModelAndView();
        if (projectId != null) {
            Project project = projectService.getById(Integer.parseInt(projectId));
            user.addProject(project);
        }
        userService.create(user);
        mailService.sendConfirmRegistrationEmail(user, request.getServerName());
        return mv;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/init")
    public String test() {
        User user = new User();
        user.setUsername("user");
        user.setEmail("test@test.com");
        user.setPassword("test");
        userService.create(user);
        return "";
    }
}
