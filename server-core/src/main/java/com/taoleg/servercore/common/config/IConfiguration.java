package com.taoleg.servercore.common.config;

/**
 * 配置积累
 * @author chenqing
 * @date 2017/8/22
 */
public interface IConfiguration<T> {

    /**
     * 通过key，获取value
     * @param key
     * @param <T>
     * @return
     */
    <T> T get(String key);

    /**
     * 手动设置
     * @param key
     * @param value
     */
    void set(String key, T value);

    /**
     * 获取key的片段，可配置key的监听回调
     * @param key
     * @return
     */
    ConfigSection getSection(String key);

    /**
     * 添加数据源
     * @param source
     */
    void addSource(IConfigurationSource source);

    /**
     * 添加缓存器
     * @param configurationCache
     */
    void setCache(ConfigurationCache configurationCache);

}
