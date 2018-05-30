package com.generator.codegen.common;

import java.util.List;

/**
 * @author Pengxiaopeng
 * @DESCRIPTION todo
 * @create 2018-05-29 15:18
 **/
public interface BaseDao<T> {
    T selectByPrimaryKey(Integer id);

    int deleteByPrimaryKey(Integer id);

    int insertSelective(T t);

    int updateByPrimaryKeySelective(T t);

    List<T> getList(T t);

    // 获取数量
    int getCountSelective(T t);

}
