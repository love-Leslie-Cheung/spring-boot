/*
 *
 *  * Copyright (c) 2018. For DMSoft Group.
 *
 */

package com.dmsoft.hyacinth.server.dao;

import com.dmsoft.hyacinth.server.entity.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by Peter on 2016/7/11.
 */

public interface UserDao extends PagingAndSortingRepository<User, Long>, JpaSpecificationExecutor<User> {

    /**
     * @param id
     * @return
     */
    User findById(Long id);

    /**
     * @param login_name
     * @return User
     */
    @Query(value = "select * from t_user where login_name = ?1", nativeQuery = true)
    User findByLoginName(String login_name);

    @Modifying
    @Transactional
    @Query(value = "update t_user set password = ?2 where login_name = ?1", nativeQuery = true)
    void update(String login_name, String newPwd);

    @Modifying
    @Transactional
    @Query(value = "insert into t_user(login_name, salt, password) values (?1, ?2, ?3)", nativeQuery = true)
    void addUser(String login_name, String salt, String password);

    @Modifying
    @Transactional
    @Query(value = "delete from t_user where login_name = ?1", nativeQuery = true)
    void deleteUser(String login_name);

    @Modifying
    @Transactional
    @Query("update User user set user.role_id = ?1 where user.login_name = ?2")
    void setUserRoleId(Long roleId, String login_name);

}
