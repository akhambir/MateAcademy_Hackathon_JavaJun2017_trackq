package com.mate.trackq.controllers;

import com.mate.trackq.model.Issue;
import com.mate.trackq.model.Project;
import com.mate.trackq.model.User;
import com.mate.trackq.service.IssueService;
import com.mate.trackq.service.ProjectService;
import com.mate.trackq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
public class IssueController {

    @Autowired
    private IssueService issueService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/create-issue", method = RequestMethod.GET)
    public ModelAndView createIssueGet(Principal principal) {
        String username = principal.getName();
        User user = userService.findByUserName(username);

        List<Project> userProjects = projectService.getUserProjects(user.getId());
        List<User> projectUserList =  projectService.getProjectUserList();

        ModelAndView mv = new ModelAndView();
        mv.addObject("userProjects", userProjects);
        return new ModelAndView("createissue", "issue", new Issue());
    }

    @RequestMapping(value = "/create-issue", method = RequestMethod.POST)
    public ModelAndView createIssuePost(@ModelAttribute Issue issue) {
        ModelAndView mv = new ModelAndView("index");
        issueService.createIssue(issue);
        return mv;
    }
}
