package com.taoleg.servercore.common.base.data;

import lombok.Data;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public abstract class FormDataTemplate<T> implements DataTransfer<T> {


    @Data
    public static class MetaData {
        private String fieldName;
        private String fieldValue;

        public MetaData(String fieldName, String fieldValue) {
            this.fieldName = fieldName;
            this.fieldValue = fieldValue;
        }
    }


    @Override
    public String format() {
        List<String> fieldNames = Stream.of(this).map(Object::getClass)
                .map(Class::getDeclaredFields).map(fields -> Stream.of(fields).map(Field::getName).collect(
                        Collectors.toList()))
                .flatMap(List::stream).collect(Collectors.toList());

        String[] sortFieldNames = fieldNames.toArray(new String[]{});
        Arrays.sort(sortFieldNames, String::compareTo);

        StringBuilder sign = new StringBuilder();
        Stream.of(sortFieldNames).forEach(fieldName -> {

            PropertyDescriptor propertyDescriptor = null;
            Object filedVal = null;

            try {
                propertyDescriptor = new PropertyDescriptor(fieldName, this.getClass());
                filedVal = propertyDescriptor.getReadMethod().invoke(this);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //获取字段fieldName的结果值
            if (null == filedVal) {
                return;
            }

            if (filedVal instanceof String) {
                filedVal = URLEncoder.encode((String) filedVal);
            }

            sign.append(fieldName)
                    .append("=").append(filedVal).append("&");
        });
        return sign.substring(0, sign.length() - 1);
    }

    @Override
    public T parse(String source, String... excludes) {
        String[] splitArr = source.split("&");
        if (0 == splitArr.length) {
            return (T) this;
        }

        Stream.of(splitArr).filter(s -> !Arrays.asList(excludes).contains(s.split("=")[0]))
                .map(s -> new FormDataTemplate.MetaData(s.split("=")[0], s.split("=")[1]))
                .forEach(metaData -> {
                    PropertyDescriptor propertyDescriptor = null;
                    try {
                        propertyDescriptor = new PropertyDescriptor(metaData.getFieldName(), this.getClass());
                        if (propertyDescriptor.getPropertyType().equals(Integer.class)) {
                            propertyDescriptor.getWriteMethod().invoke(this, Integer.valueOf(metaData.getFieldValue()));
                        }
                        if (propertyDescriptor.getPropertyType().equals(Double.class)) {
                            propertyDescriptor.getWriteMethod().invoke(this, Double.valueOf(metaData.getFieldValue()));
                        }
                        if (propertyDescriptor.getPropertyType().equals(Float.class)) {
                            propertyDescriptor.getWriteMethod().invoke(this, Float.valueOf(metaData.getFieldValue()));
                        }
                        if (propertyDescriptor.getPropertyType().equals(Date.class)) {
                            propertyDescriptor.getWriteMethod().invoke(this, DateUtils.getDate(metaData.getFieldValue(), DateUtils.STANDARD_DATE_PATTERN));
                        }
                        if (propertyDescriptor.getPropertyType().equals(LocalDate.class)) {
                            propertyDescriptor.getWriteMethod().invoke(this, DateUtils.getLocalDate(metaData.getFieldValue(), DateUtils.STANDARD_DATE_PATTERN));
                        }
                        if (propertyDescriptor.getPropertyType().equals(String.class)) {
                            propertyDescriptor.getWriteMethod().invoke(this, URLDecoder.decode(metaData.getFieldValue()));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

        return (T) this;
    }

}
