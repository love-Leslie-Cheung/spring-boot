/*
 *
 *  * Copyright (c) 2018. For DMSoft Group.
 *
 */

package com.dmsoft.hyacinth.server.service;

import com.dmsoft.hyacinth.server.dto.HistoryDto;

import java.util.List;

/**
 * operation history service
 */
public interface HistoryService {

    /**
     * get all histories
     * @return a List of all history
     */
    List<HistoryDto> findAll();

    void RecordHistory(String operator_code,String operation_target,String operation_type,String operate_result);
}
