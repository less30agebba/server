package com.taoleg.servercore.common.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author chenqing
 * @date 2017/4/27
 */
@Data
@Entity
@Table(name = "agent_account")
public class AgentAccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private int appid;
    @Column(name = "total_amount")
    private double totalAmount;
    private double balance;
    @Column(name = "frozen_amount")
    private double frozenAmount;
    @Column(name = "available_cash_amount")
    private double availableCashAmount;
    @Column(name = "room_card_num")
    private int roomCardNum;
    @Column(name = "month_cumulative_amount")
    private double monthCumulativeAmount;
    @Column(name = "today_income")
    private double todayIncome;
    @Column(name = "month_income")
    private double monthIncome;



}
