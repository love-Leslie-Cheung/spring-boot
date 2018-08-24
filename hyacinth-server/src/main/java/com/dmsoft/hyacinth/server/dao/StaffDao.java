/*
 *
 *  * Copyright (c) 2018. For DMSoft Group.
 *
 */

package com.dmsoft.hyacinth.server.dao;

import com.dmsoft.hyacinth.server.entity.Staff;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Peter on 2016/7/11.
 */
public interface StaffDao extends PagingAndSortingRepository<Staff, String>, JpaSpecificationExecutor<Staff> {

    Staff findById(Long id);

    Staff findByCode(String code);

    Staff findByIdCard(String idCard);

    void deleteAll();

    @Transactional
    @Modifying
    @Query(value = "insert into t_staff(id,code,name,idCard,phone,email,department,position,hiredate) value(?1,?2,?3,?4,?5,?6,?7,?8,?9)", nativeQuery = true)
    int insertStaff(Long id, String code, String name, String idCard, String phone, String email, String department, String position, String hiredate);

    @Query(value = "select * from t_staff where id >= ?1 and id <= ?2", nativeQuery = true)
    List<Staff> getPage(Long startIndex, Long endIndex);

}
