package com.dmsoft.hyacinth.web.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Shiro 配置
 */
@Configuration
public class ShiroConfiguration {

    /**
     * ShiroFilterFactoryBean 处理过滤资源文件问题
     * 注意：单独一个ShiroFilterFactoryBean配置是会报错的，因为
     * 在初始化ShiroFilterFactoryBean的时候需要注入SecurityManager
     * Filter Chain定义说明：
     * 1、一个URL可以配置多个Filter，使用逗号分隔；
     * 2、当设置多个过滤器时，全部验证通过，才视为通过；
     * 3、部分过滤器可指定参数，如perms，roles
     *
     * @return
     */

    // 将自己的验证方式加入容器
    @Bean
    public MyShiroRealm myShiroRealm() {
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        // 设置解密规则
        myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return myShiroRealm;
    }

    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
        hashedCredentialsMatcher.setHashIterations(1024);
        return hashedCredentialsMatcher;
    }

    /**
     * 开启shiro aop注解支持
     * 使用代理方法；所以需要开启代码支持
     *
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    public SimpleMappingExceptionResolver resolver() {
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        Properties properties = new Properties();
        properties.setProperty("org.apache.shiro.authz.UnauthorizedException", "/403");
        resolver.setExceptionMappings(properties);
        return resolver;
    }

    @Bean
    public SimpleCookie rememberMeCookie() {
        // 其中的参数是cookie的名称，对应前端checkbox的 name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        // 设置cookie有效时间30天，单位 秒
        simpleCookie.setMaxAge(259200);
        return simpleCookie;
    }

    /**
     * Cookie管理对象
     *
     * @return
     */
    @Bean
    public CookieRememberMeManager cookieRememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        return cookieRememberMeManager;
    }

    // 权限管理，配置主要是Realm的管理认证
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 将 Realm 注入到SecurityManager中
        securityManager.setRealm(myShiroRealm());
        // 注入RememberMeManager
        securityManager.setRememberMeManager(cookieRememberMeManager());
        return securityManager;
    }

    // Filter工厂，设置对应的过滤条件和跳转条件
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 必须配置SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 过滤器
        Map<String, String> map = new LinkedHashMap<>();
//        Map<String, String> map = new HashMap<>();

        // 注销过滤器，具体实现Shiro已经实现
        map.put("/logout", "logout");

//        map.put("/", "user");
//        map.put("/index", "user");

        // 过滤器链定义，一般将 '/**' 放在最后
        // authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问
        // static目录及其子目录可匿名访问
        map.put("/static/**", "anon");

        // 其他所有页面都需要认证
        map.put("/**", "authc");

        // 未认证时的默认跳转路径
        shiroFilterFactoryBean.setLoginUrl("/login");

        // 登录成功的跳转路径
        shiroFilterFactoryBean.setSuccessUrl("/index");

        // 错误/未授权页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/error");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

        return shiroFilterFactoryBean;
    }

}
