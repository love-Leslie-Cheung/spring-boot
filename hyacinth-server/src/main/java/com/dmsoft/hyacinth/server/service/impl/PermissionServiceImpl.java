package com.dmsoft.hyacinth.server.service.impl;

import com.dmsoft.hyacinth.server.dao.PermissionDao;
import com.dmsoft.hyacinth.server.entity.Permission;
import com.dmsoft.hyacinth.server.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionDao permissionDao;

    @Override
    public List<Permission> findPermissionByRoleId(Long roleId) {
        return permissionDao.findPermissionByRoleId(roleId);
    }
}
