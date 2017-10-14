package com.mate.trackq.dao;

import com.mate.trackq.model.Project;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectDao {

    void create(Project project);

}
