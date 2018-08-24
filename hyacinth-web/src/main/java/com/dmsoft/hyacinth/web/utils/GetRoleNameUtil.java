package com.dmsoft.hyacinth.web.utils;

import com.dmsoft.hyacinth.server.entity.User;
import org.apache.shiro.SecurityUtils;

public class GetRoleNameUtil {
    public static String getCurrentUserRoleName() {
        return ((User) SecurityUtils.getSubject().getPrincipal()).getRoles().iterator().next().getRole();
    }
}
