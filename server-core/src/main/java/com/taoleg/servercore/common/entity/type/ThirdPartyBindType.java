package com.taoleg.servercore.common.entity.type;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 第三方绑定类型(暂时以枚举类型存在代码中，先不将配置存库)
 */
public enum ThirdPartyBindType {

    WEIXIN(1,"微信",true),ZHIFUBAO(2,"支付宝",true),QQ(3,"QQ",false);

    private Integer value;

    private String name;

    private boolean withdrawalAware;

    ThirdPartyBindType(Integer value, String name, boolean withdrawalAware){
        this.value = value;
        this.name = name;
        this.withdrawalAware = withdrawalAware;
    }

    static public ThirdPartyBindType getTypeByValue(Integer value){
        if(null == value){
            return null;
        }

        switch (value){
            case 1 : return WEIXIN;
            case 2 : return ZHIFUBAO;
            case 3 : return QQ;
        }
        return null;
    }

    /**
     * 获取可提现的第三方绑定类型列表
     * @return
     */
    static public List<ThirdPartyBindType> getWithdrawalAwareTypes(){
        return Arrays.asList(ThirdPartyBindType.values()).stream().filter(thirdPartyBindType ->
                thirdPartyBindType.withdrawalAware).collect(Collectors.toList());
    }


    public Integer getValue(){
        return this.value;
    }

    public String getName(){
        return this.name;
    }

    public boolean getWithdrawalAware(){
        return this.withdrawalAware;
    }

}
