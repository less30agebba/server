package com.taoleg.servercore.common.base.data;


public interface DataTransfer<T> {

    String format();

    T parse(String source, String... excludes);

}
