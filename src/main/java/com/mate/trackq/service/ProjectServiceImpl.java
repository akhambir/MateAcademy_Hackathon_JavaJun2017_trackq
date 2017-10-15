package com.mate.trackq.service;

import com.mate.trackq.dao.ProjectDao;
import com.mate.trackq.model.Project;
import com.mate.trackq.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Override
    public void create(Project project) {
        projectDao.create(project);
    }

    @Override
    public Project getById(Long projectId) {
        return projectDao.getById(projectId);
    }

    @Override
    public Project getByName(String projectName) {
        return projectDao.getByName(projectName);
    }

    @Override
    public List<Project> getUserProjects(Long userId) {
        return projectDao.getUserProjects(userId);
    }

    @Override
    public List<User> getProjectUserList() {
        return projectDao.getProjectUserList();
    }
}
