package com.codegen.modules.dao;


import com.codegen.modules.model.Category;
import com.generator.codegen.common.dao.BaseDao;
import com.generator.codegen.common.dao.annotation.MyBatisDao;
import com.generator.codegen.modules.model.Category;


@MyBatisDao
public interface CategoryDao extends BaseDao<Category, String> {
}