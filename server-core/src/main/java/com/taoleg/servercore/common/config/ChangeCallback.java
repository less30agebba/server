package com.taoleg.servercore.common.config;

/**
 * kv变动回调接口
 * @author chenqing
 * @date 2017/8/23
 */
public interface ChangeCallback {

    /**
     * 回调方法
     */
    void execute();
}
