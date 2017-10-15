package com.mate.trackq.dao;

import com.mate.trackq.model.Project;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
    public Project getById(Integer projectId) {
        return (Project) sessionFactory.getCurrentSession()
                .createQuery("from Project where id=:projectId")
                .setParameter("projectId", projectId)
                .uniqueResult();
    }

    @Override
    public Project getByName(String projectName) {
        return (Project) sessionFactory.getCurrentSession()
                .createQuery("from Project where name=:projectName")
                .setParameter("projectName", projectName)
                .uniqueResult();
    }

}
