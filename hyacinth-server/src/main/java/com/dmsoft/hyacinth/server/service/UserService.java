/*
 *
 *  * Copyright (c) 2018. For DMSoft Group.
 *
 */

package com.dmsoft.hyacinth.server.service;

import com.dmsoft.hyacinth.server.dto.UserDto;
import com.dmsoft.hyacinth.server.entity.User;

import java.util.List;

/**
 * Created by Peter on 2016/7/11.
 */
public interface UserService {

    /**
     * Find user information by id.
     *
     * @param id id
     * @return UserDto
     */
    UserDto findUserById(Long id);

    /**
     * @param login_name
     * @return
     */
    User findUserByLoginName(String login_name);

    /**
     * Find all users.
     *
     * @return List UserDto
     */
    List<UserDto> findAll();

    /**
     * @param login_name
     * @param password
     * @return
     */
    UserDto validateUser(String login_name, String password);

    /**
     * @param login_name
     * @param newPwd
     */
    void updatePassword(String login_name, String newPwd);

    /**
     * @param login_name
     * @param password
     * @param roleId
     * @return
     */
    String addUser(String login_name, String password, Long roleId);

    /**
     * @param login_name
     * @return
     */
    String deleteUser(String login_name);

    /**
     * @param login_name
     * @param newPassword
     * @param roleId
     * @return
     */
    String updateUser(String login_name, String newPassword, Long roleId);
}
