package com.dmsoft.hyacinth.server.service.impl;

import com.dmsoft.hyacinth.server.dao.RoleDao;
import com.dmsoft.hyacinth.server.entity.Role;
import com.dmsoft.hyacinth.server.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    @Override
    public List<Role> findRoleByLoginName(String login_name) {
        return roleDao.findRoleByLoginName(login_name);
    }
}
