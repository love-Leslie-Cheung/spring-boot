package com.dmsoft.hyacinth.server.dao;

import com.dmsoft.hyacinth.server.entity.Salary;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SalaryDao extends PagingAndSortingRepository<Salary, String>, JpaSpecificationExecutor<Salary> {

    Salary findByCode(String code);

    @Query(value = "from Salary")
    List<Salary> findCount();

    @Override
    void deleteAll();

    @Modifying
    @Transactional
    @Query(value = "insert into t_salary (code,name,basic_wage_should_be_issued,weekend_fixed_overtime_wage_should_be_issued,post_allowance_should_be_issued,performance_allowance_should_be_issued,total_contract_wages,seniority_allowance,meal_allowance,other_allowance,other_pre_tax_buckle,total_payroll_should_be_issued,real_basic_salary,fixed_overtime_pay_for_the_weekend,real_post_allowance,real_performance_allowance,sick_pay,total_pre_tax_wages,social_security,total_housing_provident_fund,income_tax_on_personal_incom,dormitory_expense,utilities_expense,mutual_fund,telephone_fare,network_fee,other_supplementary_deductions_after_tax,real_payroll,real_bonus,total) values (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12,?13,?14,?15,?16,?17,?18,?19,?20,?21,?22,?23,?24,?25,?26,?27,?28,?29,?30)", nativeQuery = true)
    int insert(String va1, String va2, String va3, String va4, String va5, String va6, String va7, String va8, String va9, String va10
            , String va11, String va12, String va13, String va14, String va15, String va16, String va17, String va18, String va19
            , String va20, String va21, String va22, String va23, String va24, String va25, String va26, String va27, String va28
            , String va29, String va30);


}
