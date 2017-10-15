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

    @Override
    public void create(Project project) {
        projectDao.create(project);
    }

    @Override
    public Project getById(Integer projectId) {
        return projectDao.getById(projectId);
    }
}
