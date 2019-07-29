package com.taoleg.servercore.common.base.page;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Page<T> {

    /**
     * 显示页数
     */
    private int pageIndex = 1;

    /**
     * 总记录数
     */
    private int totalSize = 0;

    /**
     * 每页显示记录数
     */
    private int pageSize = 10;

    /**
     * 记录
     */
    private List<T> pageDatas = new ArrayList<T>();


}
