package com.taoleg.servercore.common.base.page;

import lombok.Data;

@Data
public class Pager {

    /**
     * 当前页
     */
    private Integer current = 1;

    /**
     * 当页尺寸
     */
    private Integer size = 10;

    /**
     * 排序字段
     */
    private String orderBy;

    /**
     * 顺序  desc asc
     */
    private String direction = "desc";

    public Pager() {
    }

    public Pager(Integer current, Integer size) {
        this.current = current;
        this.size = size;
    }

    public Pager(Integer current, Integer size, String orderBy, String direction) {
        this.current = current;
        this.size = size;
        this.orderBy = orderBy;
        this.direction = direction;
    }
}
