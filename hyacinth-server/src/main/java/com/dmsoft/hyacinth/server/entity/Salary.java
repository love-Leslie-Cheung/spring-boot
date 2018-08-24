/*
 *
 *  * Copyright (c) 2018. For DMSoft Group.
 *
 */

package com.dmsoft.hyacinth.server.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_salary")
public class Salary {

    @Id
    private Long id;
    private String code;
    private String name;
    private String basic_wage_should_be_issued;
    private String weekend_fixed_overtime_wage_should_be_issued;
    private String post_allowance_should_be_issued;
    private String performance_allowance_should_be_issued;
    private String total_contract_wages;
    private String seniority_allowance;
    private String meal_allowance;
    private String other_allowance;
    private String other_pre_tax_buckle;
    private String total_payroll_should_be_issued;
    private String real_basic_salary;
    private String fixed_overtime_pay_for_the_weekend;
    private String real_post_allowance;
    private String real_performance_allowance;
    private String sick_pay;
    private String total_pre_tax_wages;
    private String social_security;
    private String total_housing_provident_fund;
    private String income_tax_on_personal_incom;
    private String dormitory_expense;
    private String utilities_expense;
    private String mutual_fund;
    private String telephone_fare;
    private String network_fee;
    private String other_supplementary_deductions_after_tax;
    private String real_payroll;
    private String real_bonus;
    private String total;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBasic_wage_should_be_issued() {
        return basic_wage_should_be_issued;
    }

    public void setBasic_wage_should_be_issued(String basic_wage_should_be_issued) {
        this.basic_wage_should_be_issued = basic_wage_should_be_issued;
    }

    public String getWeekend_fixed_overtime_wage_should_be_issued() {
        return weekend_fixed_overtime_wage_should_be_issued;
    }

    public void setWeekend_fixed_overtime_wage_should_be_issued(String weekend_fixed_overtime_wage_should_be_issued) {
        this.weekend_fixed_overtime_wage_should_be_issued = weekend_fixed_overtime_wage_should_be_issued;
    }

    public String getPost_allowance_should_be_issued() {
        return post_allowance_should_be_issued;
    }

    public void setPost_allowance_should_be_issued(String post_allowance_should_be_issued) {
        this.post_allowance_should_be_issued = post_allowance_should_be_issued;
    }

    public String getPerformance_allowance_should_be_issued() {
        return performance_allowance_should_be_issued;
    }

    public void setPerformance_allowance_should_be_issued(String performance_allowance_should_be_issued) {
        this.performance_allowance_should_be_issued = performance_allowance_should_be_issued;
    }

    public String getTotal_contract_wages() {
        return total_contract_wages;
    }

    public void setTotal_contract_wages(String total_contract_wages) {
        this.total_contract_wages = total_contract_wages;
    }

    public String getSeniority_allowance() {
        return seniority_allowance;
    }

    public void setSeniority_allowance(String seniority_allowance) {
        this.seniority_allowance = seniority_allowance;
    }

    public String getMeal_allowance() {
        return meal_allowance;
    }

    public void setMeal_allowance(String meal_allowance) {
        this.meal_allowance = meal_allowance;
    }

    public String getOther_allowance() {
        return other_allowance;
    }

    public void setOther_allowance(String other_allowance) {
        this.other_allowance = other_allowance;
    }

    public String getOther_pre_tax_buckle() {
        return other_pre_tax_buckle;
    }

    public void setOther_pre_tax_buckle(String other_pre_tax_buckle) {
        this.other_pre_tax_buckle = other_pre_tax_buckle;
    }

    public String getTotal_payroll_should_be_issued() {
        return total_payroll_should_be_issued;
    }

    public void setTotal_payroll_should_be_issued(String total_payroll_should_be_issued) {
        this.total_payroll_should_be_issued = total_payroll_should_be_issued;
    }

    public String getReal_basic_salary() {
        return real_basic_salary;
    }

    public void setReal_basic_salary(String real_basic_salary) {
        this.real_basic_salary = real_basic_salary;
    }

    public String getFixed_overtime_pay_for_the_weekend() {
        return fixed_overtime_pay_for_the_weekend;
    }

    public void setFixed_overtime_pay_for_the_weekend(String fixed_overtime_pay_for_the_weekend) {
        this.fixed_overtime_pay_for_the_weekend = fixed_overtime_pay_for_the_weekend;
    }

    public String getReal_post_allowance() {
        return real_post_allowance;
    }

    public void setReal_post_allowance(String real_post_allowance) {
        this.real_post_allowance = real_post_allowance;
    }

    public String getReal_performance_allowance() {
        return real_performance_allowance;
    }

    public void setReal_performance_allowance(String real_performance_allowance) {
        this.real_performance_allowance = real_performance_allowance;
    }

    public String getSick_pay() {
        return sick_pay;
    }

    public void setSick_pay(String sick_pay) {
        this.sick_pay = sick_pay;
    }

    public String getTotal_pre_tax_wages() {
        return total_pre_tax_wages;
    }

    public void setTotal_pre_tax_wages(String total_pre_tax_wages) {
        this.total_pre_tax_wages = total_pre_tax_wages;
    }

    public String getSocial_security() {
        return social_security;
    }

    public void setSocial_security(String social_security) {
        this.social_security = social_security;
    }

    public String getTotal_housing_provident_fund() {
        return total_housing_provident_fund;
    }

    public void setTotal_housing_provident_fund(String total_housing_provident_fund) {
        this.total_housing_provident_fund = total_housing_provident_fund;
    }

    public String getIncome_tax_on_personal_incom() {
        return income_tax_on_personal_incom;
    }

    public void setIncome_tax_on_personal_incom(String income_tax_on_personal_incom) {
        this.income_tax_on_personal_incom = income_tax_on_personal_incom;
    }

    public String getDormitory_expense() {
        return dormitory_expense;
    }

    public void setDormitory_expense(String dormitory_expense) {
        this.dormitory_expense = dormitory_expense;
    }

    public String getUtilities_expense() {
        return utilities_expense;
    }

    public void setUtilities_expense(String utilities_expense) {
        this.utilities_expense = utilities_expense;
    }

    public String getMutual_fund() {
        return mutual_fund;
    }

    public void setMutual_fund(String mutual_fund) {
        this.mutual_fund = mutual_fund;
    }

    public String getTelephone_fare() {
        return telephone_fare;
    }

    public void setTelephone_fare(String telephone_fare) {
        this.telephone_fare = telephone_fare;
    }

    public String getNetwork_fee() {
        return network_fee;
    }

    public void setNetwork_fee(String network_fee) {
        this.network_fee = network_fee;
    }

    public String getOther_supplementary_deductions_after_tax() {
        return other_supplementary_deductions_after_tax;
    }

    public void setOther_supplementary_deductions_after_tax(String other_supplementary_deductions_after_tax) {
        this.other_supplementary_deductions_after_tax = other_supplementary_deductions_after_tax;
    }

    public String getReal_payroll() {
        return real_payroll;
    }

    public void setReal_payroll(String real_payroll) {
        this.real_payroll = real_payroll;
    }

    public String getReal_bonus() {
        return real_bonus;
    }

    public void setReal_bonus(String real_bonus) {
        this.real_bonus = real_bonus;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
