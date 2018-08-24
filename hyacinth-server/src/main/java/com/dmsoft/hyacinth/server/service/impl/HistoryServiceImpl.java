package com.dmsoft.hyacinth.server.service.impl;

import com.dmsoft.hyacinth.server.dao.HistoryDao;
import com.dmsoft.hyacinth.server.dto.HistoryDto;
import com.dmsoft.hyacinth.server.entity.History;
import com.dmsoft.hyacinth.server.entity.User;
import com.dmsoft.hyacinth.server.service.HistoryService;
import com.google.common.collect.Lists;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {

    // TODO: 分页
    @Autowired
    private HistoryDao historyDao;

    @Override
    public List<HistoryDto> findAll() {
        Iterable<History> entityList = historyDao.findAll();
        List<HistoryDto> list = Lists.newArrayList();

        entityList.forEach(entity -> {
            HistoryDto dto = new HistoryDto();
            BeanUtils.copyProperties(entity, dto);
            list.add(dto);
        });
        return list;
    }

    @Override
    public void RecordHistory(String operator_code, String operation_target, String operation_type, String operate_result) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String operating_time = sdf.format(new Date());
        System.out.println(operating_time);
        historyDao.insertHistory(operator_code,operation_target,operation_type,operating_time,operate_result);
    }


}
