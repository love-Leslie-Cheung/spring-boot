package com.dmsoft.hyacinth.server.utils;

/**
 * 所有需要用到的常量
 */
public class Constants {

    private Constants() {
    }

    /**
     * 用户已存在
     */
    public static String USER_ALREADY_EXITS = "用户名已存在！";

    /**
     * 添加用户成功
     */
    public static String ADD_USER_SUCCESS = "添加用户成功！";

    /**
     * 添加用户失败
     */
    public static String ADD_USER_FAILED = "添加用户失败！-未知错误";

    /**
     * 删除用户成功
     */
    public static String DELETE_USER_SUCCESS = "删除用户成功！";

    /**
     * 删除用户失败
     */
    public static String DELETE_USER_FAILED = "删除用户失败！";

    /**
     * 不能删除自己
     */
    public static String CANNOT_DELETE_SELF = "删除用户失败！-不能删除自己！";

    /**
     * 不能修改自己的角色
     */
    public static String CANNOT_UPDATE_SELF_ROLE = "修改用户信息失败！-不能修改自己的角色！";

    /**
     * 修改用户信息成功
     */
    public static String UPDATE_USER_SUCCESS = "修改成功！";

    /**
     * 一页最多显示的条数
     */
    public static Long PAGE_NUMBER = Long.valueOf(10);

}
