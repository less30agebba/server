package com.taoleg.serverweb.main.common;

import com.taoleg.servercore.common.base.BaseResponse;
import com.taoleg.servercore.common.base.ResponseCode;
import com.taoleg.servercore.common.exception.BaseException;
import com.taoleg.servercore.common.exception.ClientException;
import com.taoleg.servercore.common.exception.InnerException;
import com.taoleg.serverweb.common.api.auth.LogRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 异常控制器增强
 * @author chenqing
 * @date 2017/6/22
 */
@ControllerAdvice
@ResponseBody
public class ExceptionAdvice {

    private static Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);
    private static Logger monitorLogger = LoggerFactory.getLogger("monitor");

    /**
     * 系统内部异常(eg.空指针异常、强转异常等等)
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public BaseResponse exception(Exception e) throws Exception {
        monitorLogger.info(this.printStackTraceToString(e));
        e.printStackTrace();
        BaseResponse response = new BaseResponse();
        response.setCode(ResponseCode.SYSTEM_EXCEPTION.getCode());
        response.setMsg(ResponseCode.SYSTEM_EXCEPTION.getMsg());
        return response;
    }

    /**
     * 系统内部无法处理,需要通知客户端详细信息的异常,例如.签名失败的异常
     * @param e
     * @return
     */
    @ExceptionHandler(ClientException.class)
    public BaseResponse clientException(ClientException e) throws Exception {
        monitorLogger.info(this.printStackTraceToString(e));
        BaseResponse response = new BaseResponse();
        response.setCode(e.getCode());
        response.setMsg(e.getMessage());
        return response;
    }

    /**
     * 系统内部无法处理,需要通知客户端详细信息的异常,例如:业务异常
     * @param e
     * @return
     */
    @ExceptionHandler(BaseException.class)
    public BaseResponse baseException(BaseException e) throws Exception {
        monitorLogger.info(this.printStackTraceToString(e));
        BaseResponse response = new BaseResponse();
        response.setCode(e.getCode());
        response.setMsg(e.getMessage());
        response.setSubCode(e.getSubCode());
        response.setSubMsg(e.getSubMsg());
        return response;
    }

    /**
     * 系统内部无法处理,不需要通知客户端的异常。需要将异常信息记录到日志
     * (eg.账户过期、外部API异常)
     * @param e
     * @return
     */
    @ExceptionHandler(InnerException.class)
    public BaseResponse innerException(InnerException e) throws Exception {
        monitorLogger.info(this.printStackTraceToString(e));
        logger.error("内部异常: "+e.getDetail());
        e.printStackTrace();
        BaseResponse response = new BaseResponse();
        response.setCode(ResponseCode.SYSTEM_EXCEPTION.getCode());
        response.setMsg(ResponseCode.SYSTEM_EXCEPTION.getMsg());
        return response;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public BaseResponse notRequestBodyException(HttpMessageNotReadableException ex) throws Exception {
        monitorLogger.info(this.printStackTraceToString(ex));
        BaseResponse response = new BaseResponse();
        response.setCode(ResponseCode.ILLEGAL_REQUEST_FAIL.getCode());
        response.setMsg("参数为空，请通过requestBody传参");
        return response;
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public BaseResponse notRequestApplicationJsonException(HttpMessageNotReadableException ex) throws Exception {
        monitorLogger.info(this.printStackTraceToString(ex));
        BaseResponse response = new BaseResponse();
        response.setCode(ResponseCode.HTTP_MEDIA_TYPE.getCode());
        response.setMsg("请设置请求头Content-Type为application/json;charset=UTF-8");
        return response;
    }

    public static String printStackTraceToString(Exception e) throws Exception {
        LogRequest log = new LogRequest();
        log.setResponseIP();
        log.setRequestTime(System.currentTimeMillis());
        log.setResponseTime(System.currentTimeMillis());
        log.setDuration(log.getResponseTime() - log.getRequestTime());
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        e.printStackTrace(pw);
        log.setException(sw.getBuffer().toString());
        return log.toString();
    }
}
