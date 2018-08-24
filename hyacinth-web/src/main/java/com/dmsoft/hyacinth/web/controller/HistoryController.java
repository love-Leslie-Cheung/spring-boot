package com.dmsoft.hyacinth.web.controller;

import com.dmsoft.hyacinth.server.dto.HistoryDto;
import com.dmsoft.hyacinth.server.service.HistoryService;
import com.dmsoft.hyacinth.web.utils.GetRoleNameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * This is a Index Page Controler
 */
@Controller
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    /**
     * @return
     */

    @RequestMapping(value = "/history")
    public String index() {
        return "history";
    }

    @ModelAttribute("histories")
    public List<HistoryDto> getHistories() {
        return historyService.findAll();
    }

    @ModelAttribute(name = "role")
    public String role() {
        return GetRoleNameUtil.getCurrentUserRoleName();
    }

}
