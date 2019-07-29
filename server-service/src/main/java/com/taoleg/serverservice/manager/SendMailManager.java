package com.taoleg.serverservice.manager;

/**
 * Created by linfeng on 2018/1/12.
 */
public interface SendMailManager {
    void send(String appKey, String name, Double amount, String head, String body, String recipient);
}
