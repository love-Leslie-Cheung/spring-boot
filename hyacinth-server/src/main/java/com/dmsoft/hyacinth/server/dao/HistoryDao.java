package com.dmsoft.hyacinth.server.dao;

import com.dmsoft.hyacinth.server.entity.History;
import com.dmsoft.hyacinth.server.entity.Staff;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

public interface HistoryDao extends PagingAndSortingRepository<History, Long>, JpaSpecificationExecutor<History> {

    Staff findById(Long id);

    @Transactional
    @Modifying
    @Query(value = "insert into t_history(operator_code,operation_target,operation_type,operating_time,operate_result) values (?1,?2,?3,?4,?5)", nativeQuery = true)
    int insertHistory(String operator_code, String operation_target, String operation_type, String operating_time, String operate_result);

}
