package com.dmsoft.hyacinth.server.utils;

import com.dmsoft.hyacinth.server.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RecordHistory {
    public static String UPDATE_PASSWORD = "修改密码";
    public static String IMPORT_STAFF_BASE_INFO = "导入员工信息";
    public static String IMPORT_STAFF_MONEY_INFO = "导入薪资信息";
    public static String ADD_USER = "添加用户";
    public static String UPDATE_USER_PASSWORD = "修改用户密码";
    public static String UPDATE_USER_PERMISSION = "修改用户权限";
    public static String DELETE_USER = "删除用户";
    public static String UPDATE_SYSTEM_SETTING = "修改系统设置";
    public static String DOWNLOAD_SALARY = "生成工资条";
    public static String SEND_EMAIL = "发送邮件";

    @Autowired
    private HistoryService historyService;
    private static HistoryService Service;

    @PostConstruct
    public void init() {
        Service = historyService;
    }

    public static boolean RecordHistory(String code, String operator, String operation_type, String operate_result) {
        Service.RecordHistory(code, operator, operation_type, operate_result);
        return true;
    }
}
