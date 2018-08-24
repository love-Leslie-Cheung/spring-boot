/*
 *
 *  * Copyright (c) 2018. For DMSoft Group.
 *
 */

package com.dmsoft.hyacinth.server.service.impl;

import com.dmsoft.hyacinth.server.dao.StaffDao;
import com.dmsoft.hyacinth.server.dto.StaffDto;
import com.dmsoft.hyacinth.server.entity.Staff;
import com.dmsoft.hyacinth.server.service.StaffService;
import com.dmsoft.hyacinth.server.utils.Constants;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Peter Li on 2017/12/15.
 */
@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffDao staffDao;

    @Override
    public List<StaffDto> findAll() {
        Iterable<Staff> entityList = staffDao.findAll();
        List<StaffDto> list = Lists.newArrayList();

        entityList.forEach(entity -> {
            StaffDto dto = new StaffDto();
            BeanUtils.copyProperties(entity, dto);
            list.add(dto);
        });

        return list;
    }

    @Override
    public void deleteall() {
        staffDao.deleteAll();
    }

    @Override
    public int insertStaff(Long id, String code, String name, String idCard, String phone, String email, String department, String position, String hiredate) {
        return staffDao.insertStaff(id, code, name, idCard, phone, email, department, position, hiredate);
    }

    @Override
    public List<Staff> getPage(Long pageIndex) {
        return staffDao.getPage((pageIndex - 1) * Constants.PAGE_NUMBER + 1, pageIndex * Constants.PAGE_NUMBER);
    }


    @Override
    public StaffDto findById(Long id) {
        Staff entity = staffDao.findById(id);

        StaffDto dto = new StaffDto();
        BeanUtils.copyProperties(entity, dto);

        return dto;
    }

    @Override
    public StaffDto findByCode(String code) {
        Staff staff = staffDao.findByCode(code);
        StaffDto dto = new StaffDto();
        BeanUtils.copyProperties(staff, dto);
        return dto;
    }

}
