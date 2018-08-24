package com.dmsoft.hyacinth.web.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * This is a Index Page Controler
 */
@Controller
@RequestMapping(value = "/views")
public class SystemSettingController {
    /**
     * @return
     */
    @RequestMapping(value = "/systemSetting")
    @RequiresRoles("admin")
    public String index() {
        return "views/systemSetting";
    }

}
