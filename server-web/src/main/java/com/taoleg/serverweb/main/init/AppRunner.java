package com.taoleg.serverweb.main.init;

import com.taoleg.servercore.common.config.IConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author chenqing
 * @date 2017/4/5
 */
@Component
@Order(1)
public class AppRunner implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(AppRunner.class);

    @Autowired
    private IConfiguration<String> configuration;

    @Override
    public void run(String... args) throws Exception {
        logger.info(">>>>>>>>>>>>>>>服务启动执行，执行加载应用信息操作<<<<<<<<<<<<<");
    }

}