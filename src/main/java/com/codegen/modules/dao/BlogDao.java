package com.codegen.modules.dao;

import com.codegen.common.dao.BaseDao;
import com.codegen.common.dao.annotation.MyBatisDao;
import com.codegen.modules.model.Blog;


@MyBatisDao
public interface BlogDao extends BaseDao<Blog, Long>{

}