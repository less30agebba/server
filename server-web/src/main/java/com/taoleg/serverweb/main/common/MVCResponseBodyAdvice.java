package com.taoleg.serverweb.main.common;

import com.alibaba.fastjson.JSONObject;
import com.taoleg.servercore.common.base.BaseResponse;
import com.taoleg.servercore.common.base.Constant;
import com.taoleg.servercore.main.helper.ContextHelper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * Created by mumu on 2017/10/23.
 */
@ControllerAdvice
public class MVCResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (body == null) {
            return null;
        }
        if (body instanceof BaseResponse) {
            ContextHelper.set(Constant.RESPONSE_JSON, JSONObject.toJSONString(body));
        } else {
            ContextHelper.set(Constant.RESPONSE_JSON, body.toString());
        }
        return body;
    }

}