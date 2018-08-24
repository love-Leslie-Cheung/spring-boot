package com.dmsoft.hyacinth.web.controller;

import com.dmsoft.hyacinth.server.entity.User;
import com.dmsoft.hyacinth.server.service.UserService;
import com.dmsoft.hyacinth.server.utils.EncryptPassword;
import com.dmsoft.hyacinth.server.utils.RecordHistory;
import com.dmsoft.hyacinth.web.utils.GetRoleNameUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/views")
public class UpdatePasswordController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/updatePassword")     //请求地址映射注解，value指定请求的实际地址
    public String updatePassword() {
        return "views/updatePassword";
    }


    @RequestMapping(value = "/Password", method = RequestMethod.POST)
    public String greetingSubmit(@RequestParam(name = "oldPassword") String oldPassword, @RequestParam(name = "newPassword") String newPassword, Model model) {
        // TODO: 新密码与旧密码一样时的处理
        User user = (User) SecurityUtils.getSubject().getPrincipal(); // 获取当前已登录用户实体
        if (user.getPassword().equals(EncryptPassword.encryptPassword(oldPassword, user.getLogin_name()))) { // 判断当前密码输入是否正确
            if (user.getPassword().equals(EncryptPassword.encryptPassword(newPassword, user.getLogin_name()))) {
                model.addAttribute("msg", "新密码和旧密码不能一致！");
                RecordHistory.RecordHistory(user.getLogin_name(), user.getLogin_name(), RecordHistory.UPDATE_PASSWORD, "失败");
                return "views/updatePassword";
            }
            userService.updatePassword(user.getLogin_name(), newPassword);
            SecurityUtils.getSubject().logout();
            model.addAttribute("msg", "密码修改成功，请重新登录!");

            RecordHistory.RecordHistory(user.getLogin_name(), user.getLogin_name(), RecordHistory.UPDATE_PASSWORD, "成功");

            return "login";
        } else {
            model.addAttribute("msg", "当前密码输入不正确，请重新输入!");
            RecordHistory.RecordHistory(user.getLogin_name(), user.getLogin_name(), RecordHistory.UPDATE_PASSWORD, "失败");
            return "views/updatePassword";
        }
    }

    @ModelAttribute(name = "role")
    public String role() {
        return GetRoleNameUtil.getCurrentUserRoleName();
    }

}
