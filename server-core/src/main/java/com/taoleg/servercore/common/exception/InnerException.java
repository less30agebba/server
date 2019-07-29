package com.taoleg.servercore.common.exception;

import com.taoleg.servercore.common.base.ResponseCode;

/**
 * 后台无法处理的异常 && 不需要通知客户端的内部异常，非系统异常(空指针异常等)
 */
public class InnerException extends RuntimeException {

    private int code;

    public InnerException() {
        this(ResponseCode.INNER_EXCEPTION.getCode(), ResponseCode.INNER_EXCEPTION.getMsg());
    }

    public InnerException(String msg) {
        this(ResponseCode.INNER_EXCEPTION.getCode(), msg);
    }

    public InnerException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    public String getDetail() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("状态码: ").append(this.code)
                .append("  ")
                .append("异常信息: ")
                .append(super.getMessage());
        return stringBuilder.toString();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
