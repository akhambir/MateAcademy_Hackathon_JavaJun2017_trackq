package com.mate.trackq.controllers;

import com.mate.trackq.model.Issue;
import com.mate.trackq.model.Project;
import com.mate.trackq.model.User;
import com.mate.trackq.service.IssueService;
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
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private IssueService issueService;
    @Autowired
    private MailService mailService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/create-project", method = RequestMethod.GET)
    public ModelAndView createProjectGet() {
        return new ModelAndView("createproject", "project", new Project());
    }

    @RequestMapping(value = "/create-project", method = RequestMethod.POST)
    public ModelAndView createProjectPost(@ModelAttribute Project project) {
        ModelAndView mv = new ModelAndView();
        projectService.create(project);
        mv.setViewName("redirect:/index");
        return mv;
    }

    @RequestMapping(value = "/create-issue", method = RequestMethod.GET)
    public ModelAndView createIssueGet() {
        return new ModelAndView("createissue", "issue", new Issue());
    }

    @RequestMapping(value = "/addIssue", method = RequestMethod.POST)
    public ModelAndView createIssuePost(@ModelAttribute Issue issue) {
        ModelAndView mv = new ModelAndView("index");
        issueService.createIssue(issue);
        return mv;
    }

    @RequestMapping(value = "/invite-coworker", method = RequestMethod.POST)
    public ModelAndView inviteCoworker(@RequestParam("projectId") Integer projectId,
                                       @RequestParam("userEmail") String userEmail,
                                       HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        mailService.sendInviteInProject(userEmail, projectId, DomainUtils.getUrl(request));
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping(value = "/invite-coworker", method = RequestMethod.GET)
    public ModelAndView inviteCoworker() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("invitecoworker");
        return mv;
    }

    @RequestMapping(value = "/{projectName}", method = RequestMethod.GET)
    public ModelAndView viewProject(@PathVariable("projectName") String projectName,
                                    @RequestParam("userEmail") String userEmail) {
        ModelAndView mv = new ModelAndView();
        User user = userService.findByEmail(userEmail);
        Project project = projectService.getByName(projectName);
        if (user == null) {
            mv.setViewName("redirect:/signup?projectId=" + project.getId());
        } else {
            mv.setViewName("project");
        }
        return mv;
    }
}
