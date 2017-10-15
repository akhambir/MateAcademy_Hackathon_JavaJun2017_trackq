package com.mate.trackq.controllers;

import com.mate.trackq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MailController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/confirm-registration/{hashedEmail}", method = RequestMethod.GET)
    public ModelAndView confirmEmailGet(@PathVariable("hashedEmail") String hashedEmail, @RequestParam("id") Long id) {
        ModelAndView mv = new ModelAndView();
        userService.confirmEmail(hashedEmail, id);
        mv.setViewName("home");
        return mv;
    }
}
