package com.dmsoft.hyacinth.server.service.impl;

import com.dmsoft.hyacinth.server.dao.SalaryDao;
import com.dmsoft.hyacinth.server.dto.SalaryDto;
import com.dmsoft.hyacinth.server.entity.Salary;
import com.dmsoft.hyacinth.server.service.SalaryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    private SalaryDao salaryDao;

    @Override
    public SalaryDto findById(Long id) {
        return null;
    }

    @Override
    public SalaryDto findByCode(String code) {
        Salary salary = salaryDao.findByCode(code);
        SalaryDto dto = new SalaryDto();
        BeanUtils.copyProperties(salary, dto);
        return dto;
    }

    @Override
    public boolean findCount() {
        List<Salary> list = salaryDao.findCount();
        if (list.size() == 0)
            return false;
        else return true;
    }

    @Override
    public void deleteall() {
        salaryDao.deleteAll();
    }

    @Override
    public int insert(String va1, String va2, String va3, String va4, String va5, String va6, String va7, String va8, String va9, String va10
            , String va11, String va12, String va13, String va14, String va15, String va16, String va17, String va18, String va19
            , String va20, String va21, String va22, String va23, String va24, String va25, String va26, String va27, String va28
            , String va29, String va30) {
        return salaryDao.insert(va1, va2, va3, va4, va5, va6, va7, va8, va9, va10, va11, va12, va13, va14, va15, va16, va17, va18, va19
                , va20, va21, va22, va23, va24, va25, va26, va27, va28, va29, va30);

    }
}
