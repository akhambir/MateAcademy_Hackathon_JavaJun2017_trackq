package com.mate.trackq.dao;

import com.mate.trackq.model.Project;
import com.mate.trackq.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProjectDaoImpl implements ProjectDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Project project) {
        sessionFactory.getCurrentSession().save(project);
    }

    @Override
    public Project getById(Long projectId) {
        return sessionFactory.getCurrentSession().get(Project.class, projectId);
    }

    @Override
    public Project getByName(String projectName) {
        return (Project) sessionFactory.getCurrentSession()
                .createQuery("from Project where name=:projectName")
                .setParameter("projectName", projectName)
                .uniqueResult();
    }

    @Override
    public List<Project> getUserProjects(Long userId) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Users where id:userId")
                .setParameter("userId", userId)
                .list();
    }

    @Override
    public List<User> getProjectUserList() {
        return null;
    }

}
