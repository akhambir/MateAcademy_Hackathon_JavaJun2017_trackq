package com.mate.trackq.dao;

import com.mate.trackq.model.Project;
import com.mate.trackq.model.User;
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

}
