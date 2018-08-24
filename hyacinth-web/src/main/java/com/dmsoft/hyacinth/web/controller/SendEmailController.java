package com.dmsoft.hyacinth.web.controller;


import com.dmsoft.hyacinth.server.dto.SalaryDto;
import com.dmsoft.hyacinth.server.dto.StaffDto;
import com.dmsoft.hyacinth.server.entity.User;
import com.dmsoft.hyacinth.server.service.SalaryService;
import com.dmsoft.hyacinth.server.service.SendEmailService;
import com.dmsoft.hyacinth.server.service.StaffService;
import com.dmsoft.hyacinth.server.service.impl.SendEmailServiceImpl;
import com.dmsoft.hyacinth.server.utils.RecordHistory;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Controller
public class SendEmailController {

    @Autowired
    private SendEmailService sendEmailService;
    @Autowired
    private StaffService staffService;
    @Autowired
    private SalaryService salaryService;

    @ResponseBody
    @RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
    public String sendAllSalary(@RequestParam(name = "codes") String codestr) {
        if (!salaryService.findCount())
            return "false";
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        exportSalaryController ees = new exportSalaryController();
        String[] vehicle = codestr.split(":");
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        try {
            for (String code : vehicle) {
                cachedThreadPool.execute(() -> {
                    SalaryDto sa = salaryService.findByCode(code);
                    StaffDto st = staffService.findByCode(code);
                    ees.getInfo(code, user, sa, st);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    sendEmailService.initChartData(code);
                    File file = new File(System.getProperty("user.home") + "\\Documents\\" + code + "-" + sa.getName() + ".zip");
                    if (file.exists())
                        file.delete();
                });
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
        RecordHistory.RecordHistory(user.getLogin_name(), String.valueOf(vehicle.length), RecordHistory.SEND_EMAIL, "成功");
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/updateEmail")
    public String updateEmail(@RequestParam(name = "inputEmailHost") String inputEmailHost, @RequestParam(name = "inputEmailHostPort") String inputEmailHostPort, @RequestParam(name = "inputEmail") String inputEmail, @RequestParam(name = "inputPassword") String inputPassword) {
        if (sendEmailService.updateEmail(inputEmailHost, inputEmailHostPort, inputEmail, inputPassword)){
            if (sendEmailService.test())
                return "success";
            else return "error";
        }
        else return "error";
    }
}