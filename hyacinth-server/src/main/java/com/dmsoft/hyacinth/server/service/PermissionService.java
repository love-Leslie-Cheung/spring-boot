package com.dmsoft.hyacinth.server.service;

import com.dmsoft.hyacinth.server.entity.Permission;

import java.util.List;

public interface PermissionService {
    /**
     * 根据角色ID查询对应的权限信息
     * @param roleId 角色ID
     * @return
     */
    List<Permission> findPermissionByRoleId(Long roleId);
}
