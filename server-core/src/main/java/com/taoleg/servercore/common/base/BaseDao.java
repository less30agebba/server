package com.taoleg.servercore.common.base;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {

    void save(T entity);

    void update(T entity);

    void delete(T entity);

    void delete(Serializable id);

    void deleteAll();

    T findById(Serializable id);

    List<T> findAll();


}
