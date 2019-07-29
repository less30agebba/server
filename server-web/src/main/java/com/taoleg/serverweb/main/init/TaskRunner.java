package com.taoleg.serverweb.main.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author chenqing
 * @date 2017/4/5
 //*/
@Component
@Order(1)
public class TaskRunner implements CommandLineRunner {

    /**
     * 充值记录Recharge record
     */
    public static final String RECHARGE_RECORD = "RECHARGE_RECORD";

    private final static Logger logger = LoggerFactory.getLogger(TaskRunner.class);

    @Override
    public void run(String... args) throws Exception {
        logger.info(">>>>>>>>>>>>>>>服务启动执行，执行充值收益实时计算任务操作<<<<<<<<<<<<<");
    }
}