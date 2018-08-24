/*
 *
 *  * Copyright (c) 2018. For DMSoft Group.
 *
 */

package com.dmsoft.hyacinth.web.controller;

import com.dmsoft.hyacinth.server.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 */
@Controller
public class LoginController {

//    @Autowired
//    private RestTemplate restTemplate;

    // 直接访问和注销的时候是 GET 请求
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) { // if logined
            model.addAttribute("role", ((User) subject.getPrincipal()).getRoles().iterator().next().getRole());
            return "index";
        }
        return "login";
    }

    // post登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String processLogin(@RequestParam(value = "login_name") String login_name, @RequestParam("password") String password, Model model) {
        Subject subject = SecurityUtils.getSubject();
        String msg;
        try {
            subject.login(new UsernamePasswordToken(login_name, password));
            User user = (User) subject.getPrincipal();
            model.addAttribute("role", user.getRoles().iterator().next().getRole());
            return "index";
        } catch (UnknownAccountException uae) {
            msg = "账号" + login_name + "不存在!";
        } catch (IncorrectCredentialsException ice) {
            msg = "密码错误！";
        } catch (Exception e) {
            msg = "未知错误！";
        }
        model.addAttribute("msg", msg);
        return "login";
    }

    //错误页面展示
    @RequestMapping(value = "/error", method = RequestMethod.POST)
    public String error() {
        return "error!";
    }

    //注解的使用
    @RequiresRoles("admin")
    @RequiresPermissions("create")
    @RequestMapping(value = "/create")
    public String create() {
        return "Create success!";
    }


}
