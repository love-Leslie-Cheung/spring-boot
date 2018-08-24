package com.dmsoft.hyacinth.web.controller;

import com.dmsoft.hyacinth.server.dao.UserDao;
import com.dmsoft.hyacinth.server.entity.User;
import com.dmsoft.hyacinth.server.service.UserService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * This is a Index Page Controler
 */
@Controller
@RequestMapping(value = "/views/user")
public class UserController {

    @Autowired
    UserDao userDao;

    @Autowired
    UserService userService;

    /**
     * 查询用户
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/userManagement", method = RequestMethod.GET)
//    @RequiresPermissions("user:query")
    @RequiresRoles("admin")
    public String userList(Model model) {
        List<User> userList = (List<User>) userDao.findAll();
        model.addAttribute("users", userList);
        return "views/user/userManagement";
    }

    /**
     * 添加用户
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @RequiresRoles("admin")
    public String addUser() {
        return "views/user/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @RequiresRoles("admin")
    public String addUserProcess(@RequestParam("login_name") String login_name, @RequestParam("password") String password, @RequestParam("roleId") Long roleId, Model model) {
        model.addAttribute("msg", userService.addUser(login_name, password, roleId));
        return "views/user/add";
    }

    /**
     * 修改用户信息
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @RequiresRoles("admin")
    @ResponseBody
    public String updateUser(@RequestParam("login_name") String login_name, @RequestParam("newPassword") String newPassword, @RequestParam("roleId") Long roleId) {
        return userService.updateUser(login_name, newPassword, roleId);
    }

    /**
     * @param code
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @RequiresRoles("admin")
    @ResponseBody
    public String deleteUser(@RequestParam("login_name") String login_name) {
        return userService.deleteUser(login_name);
    }

}
