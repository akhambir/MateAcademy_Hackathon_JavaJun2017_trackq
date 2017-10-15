package com.mate.trackq.controllers;

import com.mate.trackq.model.Issue;
import com.mate.trackq.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IssueController {

    @Autowired
    private IssueService issueService;

    @RequestMapping(value = "/create-issue", method = RequestMethod.GET)
    public ModelAndView createIssueGet() {
        return new ModelAndView("createissue", "issue", new Issue());
    }

    @RequestMapping(value = "/create-issue", method = RequestMethod.POST)
    public ModelAndView createIssuePost(@ModelAttribute Issue issue) {
        ModelAndView mv = new ModelAndView("index");
        issueService.createIssue(issue);
        return mv;
    }
}
