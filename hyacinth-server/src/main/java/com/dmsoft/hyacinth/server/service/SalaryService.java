package com.dmsoft.hyacinth.server.service;

import com.dmsoft.hyacinth.server.dto.SalaryDto;

import java.util.List;

public interface SalaryService {

    SalaryDto findById(Long id);

    SalaryDto findByCode(String code);

    boolean findCount();

    void deleteall();

    public int insert(String va1, String va2, String va3, String va4, String va5, String va6, String va7, String va8, String va9, String va10
            , String va11, String va12, String va13, String va14, String va15, String va16, String va17, String va18, String va19
            , String va20, String va21, String va22, String va23, String va24, String va25, String va26, String va27, String va28
            , String va29, String va30);
}
