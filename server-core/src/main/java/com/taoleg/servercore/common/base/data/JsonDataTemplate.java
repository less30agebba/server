package com.taoleg.servercore.common.base.data;

import com.alibaba.fastjson.JSON;


public class JsonDataTemplate<T> implements DataTransfer<T> {


    @Override
    public String format() {
        return JSON.toJSONString(this);
    }

    @Override
    public T parse(String source, String... excludes) {
        //TODO 增加排除在外的KEY
        return (T) JSON.parseObject(source, this.getClass());
    }
}
