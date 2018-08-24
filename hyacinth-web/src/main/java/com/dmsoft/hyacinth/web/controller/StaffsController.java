package com.dmsoft.hyacinth.web.controller;

import com.dmsoft.hyacinth.server.dto.StaffDto;
import com.dmsoft.hyacinth.server.service.StaffService;
import com.dmsoft.hyacinth.web.utils.GetRoleNameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *
 */
@Controller
public class StaffsController {

    @Autowired
    StaffService staffService;

    @RequestMapping(value = "/staffs")
    public String staffs() {
        return "/views/staff/staffs";
    }

    @ModelAttribute(name = "role")
    public String role() {
        return GetRoleNameUtil.getCurrentUserRoleName();
    }

    @RequestMapping(value = "/getStaffs")
    @ResponseBody
    public List<StaffDto> findAll() {
        List<StaffDto> list = staffService.findAll();
        return list;
    }

}
