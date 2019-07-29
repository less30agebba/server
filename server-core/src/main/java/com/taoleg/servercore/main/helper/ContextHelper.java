package com.taoleg.servercore.main.helper;

import com.alibaba.fastjson.JSON;
import com.taoleg.servercore.common.base.Constant;
import com.taoleg.servercore.common.base.Context;
import com.taoleg.servercore.common.entity.AdminUserEntity;
import com.taoleg.servercore.common.entity.AgentUserEntity;

/**
 * 上下文操作类
 *
 * @author chenqing
 * @date 2017/4/5
 */
public class ContextHelper extends Context {

    /**
     * 获取管理员账号信息
     *
     * @return
     */
    public static AdminUserEntity getManagerUser() {
        return context.get().getObject(Constant.CONTEXT_MANAGER_USER_KEY, AdminUserEntity.class);
    }

    /**
     * 获取代理账号信息
     *
     * @return
     */
    public static AgentUserEntity getConsumerUser() {
        return context.get().getObject(Constant.CONTEXT_AGENT_CONSUMER_USER_KEY, AgentUserEntity.class);
    }

    /**
     * 获取账号token
     *
     * @return
     */
    public static String getToken() {
        return context.get().getString(Constant.CONTEXT_USER_TOKEN);
    }


}
