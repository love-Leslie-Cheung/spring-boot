package com.dmsoft.hyacinth.server.dao;

import com.dmsoft.hyacinth.server.entity.Role;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface RoleDao extends PagingAndSortingRepository<Role, Long>, JpaSpecificationExecutor<Role> {
    @Query(value = "select * from t_user right join rt_user_role on t_user.id = rt_user_role.user_id left join t_role on rt_user_role.role_id = t_role.id where login_name=?1", nativeQuery = true)
    List<Role> findRoleByLoginName(String login_name);
}
