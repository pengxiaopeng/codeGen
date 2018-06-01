package com.codegen.common.base;

import java.util.List;

public interface IBaseService<T, ID> {


    /**
     * @param id
     * @return
     */
    T selectByPrimaryKey(ID id);

    /**
     * @param id
     * @return
     */
    int deleteByPrimaryKey(ID id);

    /**
     * @param t
     * @return
     */
    int insert(T t);

    /**
     * @param t
     * @return
     */
    T save(T t);

    /**
     * @param t
     * @return
     */
    int insertSelective(T t);

    /**
     * @param t
     * @return
     */
    int updateByPrimaryKeySelective(T t);

    /**
     * @param t
     * @return
     */
    int updateByPrimaryKey(T t);

    /**
     * @param pageIndex
     * @param pageSize
     * @param t
     * @return
     */
    Page<T> findPage(int pageIndex, int pageSize, T t);

    /**
     * @param t
     * @return
     */
    List<T> findList(T t);

    /**
     * @return
     */
    List<T> findAll();

    /**
     * @param t
     * @return
     */
    T get(T t);

}
