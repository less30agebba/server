package com.taoleg.servercore.common.config;

/**
 * @author chenqing
 * @date 2017/8/23
 */
public interface ConfigurationCache {

    /**
     * 设置kv
     * @param key
     * @param value
     */
    void set(String key, byte[] value);

    /**
     * 通过key获取value
     * @param key
     * @return
     */
    byte[] get(String key);

    /**
     * 获取key的片段，可配置监听
     * @param key
     * @return
     */
    ConfigSection getSection(String key);

    /**
     * 清空缓存
     */
    void clear();
}
