package com.taoleg.servercore.common.config;


/**
 * 配置数据片段，主要管理配置信息的变化回调管理
 * @author chenqing
 * @date 2017/8/22
 */
public interface ConfigSection {

    /**
     * 注册回调
     * @param callback
     */
    void registerChangeCallback(ChangeCallback callback);

    /**
     * 执行回调
     */
    void executeChangeCallback();

    /**
     * 关闭回调
     */
    void dispose();

    /**
     * 激活回调
     */
    void active();
}
