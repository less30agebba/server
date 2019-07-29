package com.taoleg.servercore.common.base;

public enum ResponseCode {

    /**
     * 成功
     */
    SECCESS(0, "成功"),
    /**
     * 失败
     */
    FAIL(40000, "业务处理失败"),
    /**
     * 系统异常
     */
    SYSTEM_EXCEPTION(-1, "服务不可用"),

    /**
     * 已知的内部异常,例如第三方商户账号失效，无法充值到账等等
     */
    INNER_EXCEPTION(-2, "内部异常"),

    /**
     * 请求太频繁，请稍后再试
     */
    ASK_TOO_MUCH(398, "请求太频繁，请稍后再试"),

    /**
     * 请求头中，Content-Type设置异常
     */
    HTTP_MEDIA_TYPE(399, "请求信息格式异常"),

    /**
     * 非法参数异常，参数缺失
     */
    ILLEGAL_REQUEST_FAIL(400, "非法参数"),

    /**
     * 未授权登录
     */
    UNAUTHORIZED_LOGIN(1000, "授权权限不足"),

    /**
     * 权限不足
     */
    INSUFFICIENT_PERMISSIONS(40006, "权限不足"),

    /**
     * 使用code获取token 失败，请检验app和sercet，或者code无效。
     */
    ACCESS_TOKEN_BY_CODE_FAIL(40101, "使用code获取token 失败，请检验app和sercet，或者code无效。"),

    /**
     * 获取用户信息失败
     */
    AUTH_USER_INFO_FAIL(40102, "获取用户信息失败"),

    /**
     * accesstoken 超时，需重新授权
     */
    ACCESS_TOKEN_TIMEOUT(40103, "accesstoken 超时，需重新授权"),
    /**
     * accesstoken 不存在，需重新授权
     */
    ACCESS_TOKEN_LOSE(40104, "accesstoken 不存在，需重新授权"),
    /**
     * 刷新checkCode失败
     */
    ACCESS_REFRESH_CODE(40105, "刷新checkCode失败"),
    /**
     * 未注册第三方登陆
     */
    THIRD_AUTH_UNREGISTER(40106, "未注册第三方登陆");

    private int code;
    private String msg;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
