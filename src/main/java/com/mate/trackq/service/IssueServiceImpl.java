package com.mate.trackq.service;

import com.mate.trackq.dao.IssueDao;
import com.mate.trackq.model.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    private IssueDao issueDao;

    @Override
    public void createIssue(Issue issue) {
        issueDao.createIssue(issue);
    }
}
