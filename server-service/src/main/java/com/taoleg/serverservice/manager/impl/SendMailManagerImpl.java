package com.taoleg.serverservice.manager.impl;

import com.taoleg.serverservice.manager.SendMailManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendMailManagerImpl implements SendMailManager {

    @Override
    public void send(String appKey, String name, Double amount, String head, String body, String recipient) {

    }
}
