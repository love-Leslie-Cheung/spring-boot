/*
 *
 *  * Copyright (c) 2018. For DMSoft Group.
 *
 */

package com.dmsoft.hyacinth.server.service.impl;

import com.dmsoft.hyacinth.server.dao.StaffDao;
import com.dmsoft.hyacinth.server.dao.UserDao;
import com.dmsoft.hyacinth.server.dao.UserRoleDao;
import com.dmsoft.hyacinth.server.dto.UserDto;
import com.dmsoft.hyacinth.server.entity.User;
import com.dmsoft.hyacinth.server.service.UserService;
import com.dmsoft.hyacinth.server.utils.Constants;
import com.dmsoft.hyacinth.server.utils.EncryptPassword;
import com.dmsoft.hyacinth.server.utils.RecordHistory;
import com.google.common.collect.Lists;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    UserService userService;

    @Autowired
    StaffDao staffDao;

    @Autowired
    UserRoleDao userRoleDao;

    @Override
    public UserDto findUserById(Long id) {
        return null;
    }

    /**
     * @param login_name Login Name
     * @return
     */
    @Override
    public User findUserByLoginName(String login_name) {
        return userDao.findByLoginName(login_name);
    }

    @Override
    public List<UserDto> findAll() {
        Iterable<User> entityList = userDao.findAll();
        List<UserDto> list = Lists.newArrayList();

        entityList.forEach(entity -> {
            UserDto dto = new UserDto();
            BeanUtils.copyProperties(entity, dto);
            list.add(dto);
        });
        return list;
    }

    @Override
    public UserDto validateUser(String login_name, String password) {
        return null;
    }

    @Override
    public void updatePassword(String login_name, String newPwd) {
        userDao.update(login_name, EncryptPassword.encryptPassword(newPwd, login_name));
    }

    @Override
    public String addUser(String login_name, String password, Long roleId) {
        // 首先判断此用户是否已经存在
        User user = userDao.findByLoginName(login_name);
        if (user != null) { // 如果已存在
            RecordHistory.RecordHistory(((User) SecurityUtils.getSubject().getPrincipal()).getLogin_name(), login_name, RecordHistory.ADD_USER, Constants.USER_ALREADY_EXITS);
            return Constants.USER_ALREADY_EXITS;
        }
        try {
            // 添加用户
            userDao.addUser(login_name, login_name, EncryptPassword.encryptPassword(password, login_name));
            // 获取新添加用户的实体
            user = userDao.findByLoginName(login_name);
            assert user != null;
            // 设定用户角色
            userRoleDao.setUserToRole(user.getId(), roleId);
            // 同步更新用户表相应的角色ID
            userDao.setUserRoleId(roleId, login_name);

            // 记录添加用户历史
            RecordHistory.RecordHistory(((User) SecurityUtils.getSubject().getPrincipal()).getLogin_name(), login_name, RecordHistory.ADD_USER, Constants.ADD_USER_SUCCESS);
            return Constants.ADD_USER_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            RecordHistory.RecordHistory(((User) SecurityUtils.getSubject().getPrincipal()).getLogin_name(), login_name, RecordHistory.ADD_USER, "添加失败-未知错误");
            return Constants.ADD_USER_FAILED;
        }
    }

    @Override
    public String deleteUser(String login_name) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if (user.getLogin_name().equals(login_name)) {
            RecordHistory.RecordHistory(user.getLogin_name(), login_name, RecordHistory.DELETE_USER, Constants.CANNOT_DELETE_SELF);
            return Constants.CANNOT_DELETE_SELF;
        }
        try {
            user = userDao.findByLoginName(login_name);
            // 删除用户-角色表中的此用户记录
            userRoleDao.deleteUserRole(user.getId());
            // 删除用户
            userDao.deleteUser(login_name);
            RecordHistory.RecordHistory(user.getLogin_name(), login_name, RecordHistory.DELETE_USER, Constants.DELETE_USER_SUCCESS);
            return Constants.DELETE_USER_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            RecordHistory.RecordHistory(((User) SecurityUtils.getSubject().getPrincipal()).getLogin_name(), login_name, RecordHistory.DELETE_USER, Constants.DELETE_USER_FAILED);
            return Constants.DELETE_USER_FAILED;
        }
    }

    @Override
    public String updateUser(String login_name, String newPassword, Long roleId) {
        // 获取当前用户
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if (login_name.equals(user.getLogin_name())) { // 如果是要对自己操作
            if (!roleId.equals(userRoleDao.getUserRoleIdByUserId(user.getId()))) { // 如果要修改自己的角色
                RecordHistory.RecordHistory(user.getLogin_name(), login_name, RecordHistory.UPDATE_USER_PERMISSION, Constants.CANNOT_UPDATE_SELF_ROLE);
                return Constants.CANNOT_UPDATE_SELF_ROLE;
            }
            if (!user.getPassword().equals(newPassword) && !user.getPassword().equals(EncryptPassword.encryptPassword(newPassword, login_name))) {
                userService.updatePassword(login_name, newPassword);
                RecordHistory.RecordHistory(user.getLogin_name(), login_name, RecordHistory.UPDATE_PASSWORD, "成功");
                return Constants.UPDATE_USER_SUCCESS;
            }
        }
        // 获取目标用户
        user = userService.findUserByLoginName(login_name);
        if (!user.getPassword().equals(newPassword) && !user.getPassword().equals(EncryptPassword.encryptPassword(newPassword, login_name))) {
            userService.updatePassword(login_name, newPassword);
            RecordHistory.RecordHistory(user.getLogin_name(), login_name, RecordHistory.UPDATE_PASSWORD, "成功");
        }
        if (!roleId.equals(userRoleDao.getUserRoleIdByUserId((userDao.findByLoginName(login_name)).getId()))) {
            userRoleDao.updateUserRole((userDao.findByLoginName(login_name)).getId(), roleId);
            userDao.setUserRoleId(roleId, login_name);
            RecordHistory.RecordHistory(user.getLogin_name(), login_name, RecordHistory.UPDATE_USER_PERMISSION, "成功");
        }
        return Constants.UPDATE_USER_SUCCESS;
    }

}
