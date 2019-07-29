package com.taoleg.servercore.common.base;

public class Constant {

    /**
     * 默认编码
     */
    public static final String DEFAULT_ENCODE = "UTF-8";

    /**
     * cookie中存放的AccessToken的名称
     */
    public static final String CONTEXT_COOKIE_ACCESS_TOKEN_NAME = "accessToken";
    /**
     * 用户token
     */
    public static final String CONTEXT_USER_TOKEN = "user_token";
    /**
     * 上下文 应用信息appinfo保存的key
     */
    public static final String CONTEXT_APP_INFO_KEY = "app";
    /**
     * 管理员用户
     */
    public static final String CONTEXT_MANAGER_USER_KEY = "manager_user";
    /**
     * 系统配置
     */
    public static final String CONTEXT_APP_CONFIG_KEY = "app_config";
    /**
     * api请求的 传入参、返回参数、请求开始的时间
     */

    public static final String REQUEST_JSON="REQUEST_JSON";

    public static final String RESPONSE_JSON="RESPONSE_JSON";

    public static final String REQUEST_TIME = "REQUEST_TIME";
    /**
     * 代理用户
     */
    public static final String CONTEXT_AGENT_CONSUMER_USER_KEY = "agent_consumer_user";
    /**
     * cookie中存放的AccessToken的名称
     */
    public static final String CONTEXT_COOKIE_AGENT_ACCESS_TOKEN_NAME = "agent_accessToken_";

    public static final String LOGIN_ADMIN_TOKEN_PREFIX = "LOGIN_ADMIN_";

    public static final String LOGIN_TOKEN_PREFIX = "LOGIN_";
}
