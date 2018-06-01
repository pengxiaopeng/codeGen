package com.codegen.modules.dao;


import com.codegen.modules.model.Category;
import com.codegen.common.dao.BaseDao;
import com.codegen.common.dao.annotation.MyBatisDao;
import com.codegen.modules.model.Category;


@MyBatisDao
public interface CategoryDao extends BaseDao<Category, String> {
}