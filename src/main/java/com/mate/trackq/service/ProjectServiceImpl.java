package com.mate.trackq.service;

import com.mate.trackq.dao.ProjectDao;
import com.mate.trackq.model.Project;
import org.springframework.beans.factory.annotation.Autowired;

public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private MailService mailService;

    @Override
    public void inviteMember(String email, Project project) {
        mailService.sendInvitation(email, project);
    }

    @Override
    public void create(Project project) {
        projectDao.create(project);
    }
}
