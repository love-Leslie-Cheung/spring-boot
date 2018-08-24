package com.dmsoft.hyacinth.web.config;

import com.dmsoft.hyacinth.server.dao.PermissionDao;
import com.dmsoft.hyacinth.server.dao.RoleDao;
import com.dmsoft.hyacinth.server.entity.User;
import com.dmsoft.hyacinth.server.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 */
public class MyShiroRealm extends AuthorizingRealm {

    //    @Resource
    @Autowired
    private UserService userService;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PermissionDao permissionDao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        User user = (User) principalCollection.getPrimaryPrincipal();
        roleDao.findRoleByLoginName(user.getLogin_name()).forEach(
                role -> {
                    info.addRole(role.getRole());
                    permissionDao.findPermissionByRoleId(role.getId()).forEach(
                            permission -> info.addStringPermission(permission.getPermission())
                    );
                }
        );
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 获取用户输入的账号(工号)
        String login_name = (String) authenticationToken.getPrincipal();
        // 通过 login_name 从数据库中查找 User 对象， 如果找到...，没找到...
        User user = userService.findUserByLoginName(login_name);
        if (user == null) {
            // 当没有登录用户名所对应的SimpleAuthenticationInfo对象时，就会在LoginController中抛出UnknownAccountException异常
            return null;
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
                user,
                user.getPassword(),
                ByteSource.Util.bytes(user.getSalt()),
                getName()
        );
        return info;
    }
}
