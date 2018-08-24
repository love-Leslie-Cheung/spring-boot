/*
 *
 *  * Copyright (c) 2018. For DMSoft Group.
 *
 */

package com.dmsoft.hyacinth.server.service;

import com.dmsoft.hyacinth.server.dto.StaffDto;
import com.dmsoft.hyacinth.server.entity.Staff;

import java.util.List;

public interface StaffService {

    StaffDto findById(Long id);

    StaffDto findByCode(String code);

    List<StaffDto> findAll();

    void deleteall();

    int insertStaff(Long id, String code, String name, String idCard, String phone, String email, String department, String position, String hiredate);

    List<Staff> getPage(Long pageIndex);
}
