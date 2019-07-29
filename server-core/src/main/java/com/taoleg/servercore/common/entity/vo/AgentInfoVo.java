package com.taoleg.servercore.common.entity.vo;

import com.taoleg.servercore.common.entity.AgentAccountEntity;
import com.taoleg.servercore.common.entity.AgentUserEntity;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.sql.Timestamp;

/**
 * @author chenqing
 * @date 2017/5/9
 */
@Data
public class AgentInfoVo {

    private int id;
    private String username;
    private int appid;
    private Integer pid;
    private String path;
    private Integer role;
    private String nickname;
    private String headImg;
    private String password;
    private String phone;
    private String email;
    private Integer sex;
    private String recommender;

    private Integer powers;
    private Integer settle;
    private Integer bindCount;

    private Integer childCount;
    private Integer maxChildCount;

    private Integer status;
    private Timestamp createTime;

    //备注
    private String remark;

    private double totalAmount;
    private double balance;
    private double frozenAmount;
    private double availableCashAmount;
    private int roomCardNum;
    private double monthCumulativeAmount;
    private double todayIncome;
    private double monthIncome;


    public static AgentInfoVo build(AgentUserEntity agentUserEntity, AgentAccountEntity agentAccountEntity){
        AgentInfoVo agentInfoVo = new AgentInfoVo();

        if (agentUserEntity != null) {
            BeanUtils.copyProperties(agentUserEntity,agentInfoVo);
        }
        if (agentAccountEntity != null) {
            agentInfoVo.setTotalAmount(agentAccountEntity.getTotalAmount());
            agentInfoVo.setBalance(agentAccountEntity.getBalance());
            agentInfoVo.setFrozenAmount(agentAccountEntity.getFrozenAmount());
            agentInfoVo.setAvailableCashAmount(agentAccountEntity.getAvailableCashAmount());
            agentInfoVo.setRoomCardNum(agentAccountEntity.getRoomCardNum());
            agentInfoVo.setMonthCumulativeAmount(agentAccountEntity.getMonthCumulativeAmount());
            agentInfoVo.setTodayIncome(agentAccountEntity.getTodayIncome());
            agentInfoVo.setMonthIncome(agentAccountEntity.getMonthIncome());
        }
        return agentInfoVo;
    }

}
