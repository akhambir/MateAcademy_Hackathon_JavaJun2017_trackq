package com.mate.trackq.dao;

import com.mate.trackq.model.Role;

import java.util.List;

public interface RoleDao {

    List getAll();

    Role getByRoleName(String roleName);
}
