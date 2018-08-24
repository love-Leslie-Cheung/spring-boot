package com.dmsoft.hyacinth.server.service;

import com.dmsoft.hyacinth.server.entity.Role;

import java.util.List;

public interface RoleService {

    /**
     * @param login_name
     * @return
     */
    List<Role> findRoleByLoginName(String login_name);
}
