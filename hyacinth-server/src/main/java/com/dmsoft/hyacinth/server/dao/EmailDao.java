package com.dmsoft.hyacinth.server.dao;

import com.dmsoft.hyacinth.server.entity.Email;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

public interface EmailDao extends PagingAndSortingRepository<Email, Long>, JpaSpecificationExecutor<Email> {
    Email findById(Long id);

    void deleteAll();

    @Modifying
    @Transactional
    @Query(value = "insert into t_email_config(id,host,port,send_email,password) values (?1, ?2, ?3,?4,?5)", nativeQuery = true)
    int insert(Long id, String host, String port, String send_email, String password);

}
