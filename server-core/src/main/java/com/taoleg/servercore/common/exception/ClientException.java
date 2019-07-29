package com.taoleg.servercore.common.exception;

import com.taoleg.servercore.common.base.ResponseCode;

/**
 * 后台无法处理的异常 && 需要通知客户端的异常
 */
public class ClientException extends RuntimeException {

    private int code;

    public ClientException() {
        this(ResponseCode.FAIL.getCode(), ResponseCode.FAIL.getMsg());
    }

    public ClientException(String msg) {
        this(ResponseCode.FAIL.getCode(), msg);
    }

    public ClientException(int code, String msg) {
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


    public static void main(String[] args) {
        try {
            throw new ClientException(40000, "测试失败");
        } catch (ClientException e) {
            e.printStackTrace();
            System.out.println(e.getDetail());
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
