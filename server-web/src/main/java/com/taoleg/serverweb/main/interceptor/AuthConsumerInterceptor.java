package com.taoleg.serverweb.main.interceptor;

import com.taoleg.servercore.common.base.BaseResponse;
import com.taoleg.servercore.common.base.Constant;
import com.taoleg.servercore.common.base.ResponseCode;
import com.taoleg.servercore.common.entity.AgentUserEntity;
import com.taoleg.servercore.common.utils.CookieUtils;
import com.taoleg.servercore.common.utils.ResponseUtils;
import com.taoleg.servercore.main.helper.ContextHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Auth代理端拦截器
 */
public class AuthConsumerInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String accessToken = CookieUtils.getCookieValue(request, Constant.CONTEXT_COOKIE_AGENT_ACCESS_TOKEN_NAME);
        if (StringUtils.isEmpty(accessToken)) {
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setCode(ResponseCode.UNAUTHORIZED_LOGIN.getCode());
            baseResponse.setMsg(ResponseCode.UNAUTHORIZED_LOGIN.getMsg());
            ResponseUtils.writeJson(response, baseResponse);
            return false;
        }
        String token = RedisConstant.LOGIN_TOKEN_PREFIX + accessToken;
        ContextHelper.set(ConstantAgent.CONTEXT_USER_TOKEN, token);
        RedisClient redis = SpringUtils.getBean(RedisClient.class);
        AgentUserEntity user = redis.get(token, AgentUserEntity.class);
        if (user == null) {//给前端返回[未登录]的状态码
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setCode(ResponseCode.UNAUTHORIZED_LOGIN.getCode());
            baseResponse.setMsg(ResponseCode.UNAUTHORIZED_LOGIN.getMsg());
            ResponseUtils.writeJson(response, baseResponse);
            return false;
        }
        ContextHelper.set(Constant.CONTEXT_AGENT_CONSUMER_USER_KEY, user);

        return true;
    }

}
