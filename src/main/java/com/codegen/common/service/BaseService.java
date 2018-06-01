package com.codegen.common.service;

import com.codegen.common.base.Page;
import com.codegen.common.dao.BaseDao;
import com.codegen.common.model.BaseModel;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class BaseService<MAPPER extends BaseDao<T, ID>, T extends BaseModel, ID> {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected MAPPER mapper;

    /**
     * @param id
     * @return
     */
    public T selectByPrimaryKey(ID id) {
        return mapper.selectByPrimaryKey(id);
    }

    /**
     * @param id
     * @return
     */
    @Transactional
    public int deleteByPrimaryKey(ID id) {
        return this.mapper.deleteByPrimaryKey(id);
    }

    /**
     * @param t
     * @return
     */
    @Transactional
    public int insert(T t) {
        return this.mapper.insert(t);
    }


    /**
     * @param t
     * @return
     */
    @Transactional
    public T save(T t) {
        int i = this.mapper.insert(t);
        if (i > 0) {
            return t;
        } else {
            return null;
        }
    }

    /**
     * @param t
     * @return
     */
    @Transactional
    public int insertSelective(T t) {
        return this.mapper.insertSelective(t);
    }

    /**
     * @param t
     * @return
     */
    @Transactional
    public int updateByPrimaryKeySelective(T t) {
        return this.mapper.updateByPrimaryKeySelective(t);
    }

    /**
     * @param t
     * @return
     */
    @Transactional
    public int updateByPrimaryKey(T t) {
        return this.mapper.updateByPrimaryKey(t);
    }

    /**
     * @param pageIndex
     * @param pageSize
     * @param t
     * @return
     */
    public Page<T> findPage(int pageIndex, int pageSize, T t) {
        com.github.pagehelper.Page page = (com.github.pagehelper.Page) PageHelper.startPage(pageIndex, pageSize);
        List<T> list = mapper.findList(t);
        Page<T> newPage = new Page<T>(page);
        return newPage;
    }

    /**
     * @param t
     * @return
     */
    public List<T> findList(T t) {
        return this.mapper.findList(t);
    }

    /**
     * @return
     */
    public List<T> findAll() {
        return this.mapper.findAll();
    }

    /**
     * @param t
     * @return
     */
    public T get(T t) {
        List<T> list = this.findList(t);

        if (list != null && !list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

}
