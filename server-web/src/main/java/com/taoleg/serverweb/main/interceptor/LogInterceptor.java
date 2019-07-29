package com.taoleg.serverweb.main.interceptor;

import com.alibaba.fastjson.JSON;
import com.taoleg.servercore.common.apilog.LogMeta;
import com.taoleg.servercore.common.base.Constant;
import com.taoleg.servercore.common.signatrue.Signature;
import com.taoleg.servercore.main.helper.ContextHelper;
import com.taoleg.serverweb.main.common.BodyReaderHttpServletRequestWrapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StreamUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;

/**
 * Created by mumu on 2017/10/23.
 */
public class LogInterceptor extends HandlerInterceptorAdapter {

    private static Logger logger= LoggerFactory.getLogger(LogInterceptor.class);
    private static Logger monitorLogger = LoggerFactory.getLogger("monitor");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String body = StreamUtils.copyToString(request.getInputStream(), Charset.forName("UTF-8"));
        ContextHelper.set(Constant.REQUEST_JSON, body);
        ContextHelper.set(Constant.REQUEST_TIME, System.currentTimeMillis());

        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);

        String path = request.getRequestURI();
        logger.debug("LogInterceptor.afterCompletion:path=" + path);

        if (StringUtils.isEmpty(path) || path.contains(".") ) {
            super.afterCompletion(request, response, handler, ex);
            return;
        }

        if (path.startsWith("/")){
            path = path.substring(1);
        }

        BodyReaderHttpServletRequestWrapper requestWrapper = (BodyReaderHttpServletRequestWrapper) request;
        String signatureStr = request.getHeader("signature");
        Signature signature;
        if (com.alibaba.druid.util.StringUtils.isEmpty(signatureStr)) {
            signature = JSON.parseObject(new String(requestWrapper.getRequestBody()), Signature.class);
        } else {
            signature = new Signature().parse(signatureStr);
        }
        LogMeta log = new LogMeta();
        log.setRequest(ContextHelper.getString(LogConstant.REQUEST_JSON));
        log.setResponse(ContextHelper.getString(LogConstant.RESPONSE_JSON));
        log.setRequestIP(IpUtils.getIpAddress(request));
        log.setResponseIP();
        log.setObj(path);
        log.setServiceId(signature.getServiceId());
        log.setRequestTime(ContextHelper.getLong(LogConstant.REQUEST_TIME));
        log.setResponseTime(System.currentTimeMillis());
        log.setDuration((ContextHelper.getLong(LogConstant.REQUEST_TIME) - System.currentTimeMillis()));

        //将请求和返回数据放在日志中
        monitorLogger.info(log.toString());

        ContextHelper.release();

        super.afterCompletion(request, response, handler, ex);
    }

}
