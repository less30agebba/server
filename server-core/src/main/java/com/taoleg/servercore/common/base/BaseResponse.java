package com.taoleg.servercore.common.base;

import com.taoleg.servercore.common.exception.BaseException;

import java.io.Serializable;
import java.util.Arrays;

public class BaseResponse implements Serializable {

    protected static final long serialVersionUID = 1L;
    protected int code;
    protected String msg;
    protected String subCode;
    protected String subMsg;

    public BaseResponse() {
    }

    public BaseResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseResponse(String msg) {
        this.msg = msg;
    }

    public BaseResponse(int code, String msg, String subCode, String subMsg) {
        this.code = code;
        this.msg = msg;
        this.subCode = subCode;
        this.subMsg = subMsg;
    }
    public BaseResponse(BaseException exception) {
        this.code = exception.getCode();
        this.msg = exception.getMsg();
        this.subCode = exception.getSubCode();
        this.subMsg = exception.getSubMsg();
    }


    /**
     * 判断是否成功
     *
     * @return boolean
     */
    public boolean success() {
        return code == 0;
    }

    /**
     * 判断是否通用异常
     *
     * @return boolean
     */
    public boolean generalException() {
        return code != 0 && code != 40000;
    }

    /**
     * 判断是否业务异常
     *
     * @return
     */
    public boolean businessException() {
        return code == 40000;
    }

    /**
     * 详细判断是否业务异常
     *
     * @param subCodes
     * @return
     */
    public boolean businessException(String... subCodes) {
        return code == 40000 && Arrays.asList(subCodes).contains(subCode);
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

    public String getSubCode() {
        return subCode;
    }

    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }

    public String getSubMsg() {
        return subMsg;
    }

    public void setSubMsg(String subMsg) {
        this.subMsg = subMsg;
    }
}
