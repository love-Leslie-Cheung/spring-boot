package com.dmsoft.hyacinth.server.dao;

import com.dmsoft.hyacinth.server.entity.Permission;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PermissionDao extends PagingAndSortingRepository<Permission, Long>, JpaSpecificationExecutor<Permission> {
    @Query(value = "select * from (t_permission, t_role) right join rt_role_permission on t_permission.id = rt_role_permission.permission_id and rt_role_permission.role_id = t_role.id where t_role.id=?1", nativeQuery = true)
    List<Permission> findPermissionByRoleId(Long id);
}
