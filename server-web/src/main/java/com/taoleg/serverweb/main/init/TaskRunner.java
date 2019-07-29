package com.taoleg.serverweb.main.init;

import com.pengpenghuyu.supportplat.agentplatform.core.common.task.TaskQueue;
import com.pengpenghuyu.supportplat.agentplatform.core.common.task.TaskQueueManager;
import com.pengpenghuyu.supportplat.agentplatform.core.common.task.TaskThread;
import com.pengpenghuyu.supportplat.agentplatform.core.main.common.SpringUtils;
import com.pengpenghuyu.supportplat.agentplatform.service.service.RechargeService;
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

        //初始化队列管理器
        TaskQueueManager.initQueneMap(RECHARGE_RECORD);

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.execute(new TaskThread(RECHARGE_RECORD) {
            private TaskQueue taskQueue = TaskQueueManager.get(this.taskName);

            @Override
            protected void runTask() {
                try {
                    String task = taskQueue.popTask();
                    if (task == null) {
                        Thread.sleep(100);
                    } else {
                        logger.info("执行任务数据：" + task);
                        boolean exp = SpringUtils.getBean(RechargeService.class).rechargeTask(task);
                        if (!exp) {
                            taskQueue.pushTask(task);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}