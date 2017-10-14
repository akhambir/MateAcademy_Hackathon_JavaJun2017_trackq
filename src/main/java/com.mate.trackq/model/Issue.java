package com.mate.trackq.model;


import javax.persistence.*;
import java.util.List;

@Embeddable
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    Project project;
    @ManyToOne(fetch = FetchType.LAZY)
    private List<Status> statusList;

    private User tssignee;
    private User reporter;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Status> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<Status> statusList) {
        this.statusList = statusList;
    }

    public User getTssignee() {
        return tssignee;
    }

    public void setTssignee(User tssignee) {
        this.tssignee = tssignee;
    }

    public User getReporter() {
        return reporter;
    }

    public void setReporter(User reporter) {
        this.reporter = reporter;
    }
}
