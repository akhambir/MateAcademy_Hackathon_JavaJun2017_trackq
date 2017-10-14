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



}
