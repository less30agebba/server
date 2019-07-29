package com.taoleg.servercore.common.exception;

/**
 * 异常基类
 *
 * @author chq
 * @date 2018/1/9
 */
public abstract class BaseException extends RuntimeException {
    private Integer code;

    private String msg;

    private String subCode;

    private String subMsg;

    protected BaseException(Integer code, String msg, String subCode, String subMsg) {
        this.code = code;
        this.msg = msg;
        this.subCode = subCode;
        this.subMsg = subMsg;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getSubCode() {
        return this.subCode;
    }

    public String getSubMsg() {
        return this.subMsg;
    }

    public String getDetail() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("code: ").append(this.code)
                .append(" msg: ").append(this.msg).append(" subCode: ")
                .append(this.subCode).append(" subMsg: ").append(this.subMsg);
        return stringBuilder.toString();
    }
}
