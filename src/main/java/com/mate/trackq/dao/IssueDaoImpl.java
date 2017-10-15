package com.mate.trackq.dao;

import com.mate.trackq.dao.IssueDao;
import com.mate.trackq.model.Issue;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IssueDaoImpl implements IssueDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createIssue(Issue issue) {
        sessionFactory.getCurrentSession().save(issue);
    }
}
