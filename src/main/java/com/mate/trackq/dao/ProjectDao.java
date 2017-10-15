package com.mate.trackq.dao;

import com.mate.trackq.model.Project;
import com.mate.trackq.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectDao {

    void create(Project project);

    Project getById(Long projectId);

    Project getByName(String projectName);

    List<Project> getUserProjects(Long userId);

    List<User> getProjectUserList();
}
