package com.generator.codegen.common.dao;


import com.generator.codegen.common.model.BaseModel;

import java.util.List;

public interface BaseDao<T extends BaseModel, ID> {

    T selectByPrimaryKey(ID id);

    int deleteByPrimaryKey(ID id);

    int insert(T t);

    int insertSelective(T t);

    int updateByPrimaryKeySelective(T t);

    int updateByPrimaryKey(T t);

    List<T> findList(T t);

    List<T> findAll();
}
