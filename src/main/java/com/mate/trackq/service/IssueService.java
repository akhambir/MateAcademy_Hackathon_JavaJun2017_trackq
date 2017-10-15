package com.mate.trackq.service;

import com.mate.trackq.model.Issue;
import org.springframework.stereotype.Service;


public interface IssueService {
    void createIssue(Issue issue);
}
