package com.mate.trackq.model;


import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "issues", schema = "trackq")
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Project project;
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = User.class, cascade = CascadeType.MERGE)
    @JoinTable(
            schema = "trackq",
            name = "issue_to_assignee",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "issue_id")
    )
    private Set<User> assignee;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = User.class, cascade = CascadeType.MERGE)
    @JoinTable(
            schema = "trackq",
            name = "issue_to_reporter",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "issue_id")
    )
    private Set<User> reporter;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Set<User> getAssignee() {
        return assignee;
    }

    public void setAssignee(Set<User> tssignee) {
        this.assignee = assignee;
    }

    public Set<User> getReporter() {
        return reporter;
    }

    public void setReporter(Set<User> reporter) {
        this.reporter = reporter;
    }
}