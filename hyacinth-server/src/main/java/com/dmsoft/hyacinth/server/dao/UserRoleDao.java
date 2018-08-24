package com.dmsoft.hyacinth.server.dao;

import com.dmsoft.hyacinth.server.entity.UserRole;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UserRoleDao extends PagingAndSortingRepository<UserRole, Long>, JpaSpecificationExecutor<UserRole> {

    @Modifying
    @Transactional
    @Query(value = "insert into rt_user_role(user_id, role_id) values (?1, ?2)", nativeQuery = true)
    void setUserToRole(Long user_id, Long role_id);

    @Query(value = "select role_id from rt_user_role where user_id = ?1", nativeQuery = true)
    Long getUserRoleIdByUserId(Long user_id);

    @Modifying
    @Transactional
    @Query(value = "update rt_user_role set role_id = ?2 where user_id = ?1", nativeQuery = true)
    void updateUserRole(Long user_id, Long role_id);

    @Modifying
    @Transactional
    @Query(value = "delete from rt_user_role where user_id = ?1", nativeQuery = true)
    void deleteUserRole(Long user_id);

}
