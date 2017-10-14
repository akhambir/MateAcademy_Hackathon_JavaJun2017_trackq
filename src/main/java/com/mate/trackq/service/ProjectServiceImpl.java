package com.mate.trackq.service;

import com.mate.trackq.dao.ProjectDao;
import com.mate.trackq.model.Project;
import com.mate.trackq.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private MailService mailService;
    @Autowired
    private UserService userService;
//todo
    @Override
    public void inviteMember(String email, Project project) {
        User user = userService.findByEmail(email);
/*        if (user != null) {
            user.addProject(project);
        }
        mailService.sendInvitation(email, project);*/
    }

    @Override
    public void create(Project project) {
        projectDao.create(project);
    }
}
