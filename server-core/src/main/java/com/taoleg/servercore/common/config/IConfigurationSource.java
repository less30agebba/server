package com.taoleg.servercore.common.config;


/**
 * 配置数据源接口
 * @author chenqing
 * @date 2017/8/22
 */
public interface IConfigurationSource{

    /**
     * 加载配置缓存器，并加载和监听数据
     * @param configurationCache
     */
    void load(ConfigurationCache configurationCache);
}
