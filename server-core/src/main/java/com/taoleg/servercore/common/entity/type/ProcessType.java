package com.taoleg.servercore.common.entity.type;

/**
 * 处理流程
 */
public enum ProcessType {

    MANUAL(0,"手动"),AUTO(1,"自动");

    private Integer value;

    private String name;

    ProcessType(Integer value, String name){
        this.value = value;
        this.name = name;
    }

    public Integer getValue(){
        return this.value;
    }

    public static ProcessType getTypeByValue(Integer value) {

        if(null == value){
            return null;
        }

        switch (value){
            case 0 : return MANUAL;
            case 1 : return AUTO;
        }
        return null;

    }
}
