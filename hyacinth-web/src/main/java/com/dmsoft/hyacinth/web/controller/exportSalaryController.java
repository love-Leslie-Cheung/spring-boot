package com.dmsoft.hyacinth.web.controller;

import com.dmsoft.hyacinth.server.dto.SalaryDto;
import com.dmsoft.hyacinth.server.dto.StaffDto;
import com.dmsoft.hyacinth.server.entity.User;
import com.dmsoft.hyacinth.server.service.SalaryService;
import com.dmsoft.hyacinth.server.service.StaffService;
import com.dmsoft.hyacinth.server.utils.CompressUtils;
import com.dmsoft.hyacinth.server.utils.ExportImage;
import com.dmsoft.hyacinth.server.utils.RecordHistory;
import com.dmsoft.hyacinth.web.utils.GetRoleNameUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Controller
public class exportSalaryController {
    String isExport = null;
    String Path = System.getProperty("user.home") + "\\Documents\\";

    @Autowired
    private StaffService staffService;

    @Autowired
    private SalaryService salaryService;

    @ModelAttribute("staffs")
    public List<StaffDto> findAll() {
        List<StaffDto> list = staffService.findAll();
        return list;
    }

    @ModelAttribute(name = "role")
    public String role() {
        return GetRoleNameUtil.getCurrentUserRoleName();
    }

    @RequestMapping(value = "/export")
    public String export() {
        return "export";
    }

    @ResponseBody
    @RequestMapping(value = "/export", method = RequestMethod.POST)
    public boolean export(@RequestParam(name = "codes") String codestr) {
        if (!salaryService.findCount())
            return false;
        Path = System.getProperty("user.home") + "\\Downloads\\";
        String[] vehicle = codestr.split(":");
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (String code : vehicle) {
            try {
                cachedThreadPool.execute(() -> {
                    SalaryDto sa  = salaryService.findByCode(code);
                    StaffDto st = staffService.findByCode(code);
                    getInfo(code, user, sa, st);
                });
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        RecordHistory.RecordHistory(user.getLogin_name(), String.valueOf(vehicle.length), RecordHistory.DOWNLOAD_SALARY, "成功");
        return true;
    }

    public void getInfo(String code, User user, SalaryDto sa, StaffDto st) {
        exportImage(sa);
        CompressUtils compressUtils = new CompressUtils();
        compressUtils.zip(isExport, Path + code + "-" + sa.getName() + ".zip", true, st.getPhone().substring(st.getPhone().length() - 6));
    }


    private Boolean exportImage(SalaryDto sa) {
        List<List<List<String>>> allValue = new ArrayList<>();
        // List<String> content1 = Arrays.asList(new String[]{sa.getCode(), sa.getName()});
        List<String> content1 = Arrays.asList(sa.getCode(), sa.getName());
        List<String> content2 = Arrays.asList(sa.getBasic_wage_should_be_issued(), sa.getWeekend_fixed_overtime_wage_should_be_issued(), sa.getPost_allowance_should_be_issued(), sa.getPerformance_allowance_should_be_issued(), sa.getTotal_contract_wages(), sa.getSeniority_allowance(), sa.getMeal_allowance(), sa.getOther_allowance(), sa.getOther_pre_tax_buckle(), sa.getTotal_payroll_should_be_issued());
        List<String> content3 = Arrays.asList(sa.getReal_basic_salary(), sa.getFixed_overtime_pay_for_the_weekend(), sa.getReal_post_allowance(), sa.getReal_performance_allowance(), sa.getSick_pay(), sa.getTotal_pre_tax_wages());
        List<String> content4 = Arrays.asList(sa.getSocial_security(), sa.getTotal_housing_provident_fund(), sa.getIncome_tax_on_personal_incom(), sa.getDormitory_expense(), sa.getUtilities_expense(), sa.getMutual_fund(), sa.getTelephone_fare(), sa.getNetwork_fee(), sa.getOther_supplementary_deductions_after_tax(), sa.getReal_payroll(), sa.getReal_bonus());
        List<String> content5 = Collections.singletonList(sa.getTotal());

        List<List<String>> contentArray1 = new ArrayList<>();
        contentArray1.add(content1);
        List<List<String>> contentArray2 = new ArrayList<>();
        contentArray2.add(content2);
        List<List<String>> contentArray3 = new ArrayList<>();
        contentArray3.add(content3);
        List<List<String>> contentArray4 = new ArrayList<>();
        contentArray4.add(content4);
        List<List<String>> contentArray5 = new ArrayList<>();
        contentArray5.add(content5);

        allValue.add(contentArray1);
        allValue.add(contentArray2);
        allValue.add(contentArray3);
        allValue.add(contentArray4);
        allValue.add(contentArray5);

        List<String[]> headTitles = new ArrayList<>();
        String[] h1 = new String[]{"工号", "姓名"};
        String[] h2 = new String[]{"应发基本工资", "应发周末固定加班工资", "应发职位津贴", "应发绩效津贴", "合同工资总额", "年资补贴", "餐费补贴", "其它补贴", "税前其它扣补款", "应发工资总额"};
        String[] h3 = new String[]{"实发基本工资", "实发周末固定加班工资", "实发职位津贴", "实发绩效津贴", "病假工资", "税前工资总额"};
        String[] h4 = new String[]{"社保合计(个人)", "住房公积金合计(个人)", "个人收入所得税", "住宿费", "水电费", "互助基金", "套餐话费", "网络费", "税后其它补扣款合计", "实发工资", "实发奖金"};
        String[] h5 = new String[]{"合计"};

        headTitles.add(h1);
        headTitles.add(h2);
        headTitles.add(h3);
        headTitles.add(h4);
        headTitles.add(h5);

        List<String> titles = new ArrayList<>();
        titles.add("员工信息");
        titles.add("工资表");
        titles.add("");
        titles.add("");
        titles.add("");
        try {
            isExport = ExportImage.graphicsHtmlGeneration(allValue, titles, headTitles, sa.getCode());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert isExport != null;
            return !isExport.equals("");
        }
    }
}
