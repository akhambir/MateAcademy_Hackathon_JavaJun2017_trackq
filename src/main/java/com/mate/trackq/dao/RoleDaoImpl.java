package com.mate.trackq.dao;

import com.mate.trackq.model.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Repository
@Transactional
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Role> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(Role.class).list();
    }

    @Override
    public Role getByRoleName(String roleName) {
        return (Role) sessionFactory.getCurrentSession()
                .createQuery("from Role where rolename=:rolename")
                .setParameter("rolename", roleName)
                .uniqueResult();
    }
}
