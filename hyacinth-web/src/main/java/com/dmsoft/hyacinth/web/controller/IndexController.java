package com.dmsoft.hyacinth.web.controller;

import com.dmsoft.hyacinth.web.utils.GetRoleNameUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * This is a Index Page Controler
 */
@Controller
public class IndexController {
    /**
     * @return
     */
    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    @ModelAttribute(name = "role")
    public String role() {
        return GetRoleNameUtil.getCurrentUserRoleName();
    }

    @RequestMapping(value = "/403")
    public String unauthorizedRole() {
        System.out.println("----------------------没有权限----------------------");
        return "403";
    }

}
