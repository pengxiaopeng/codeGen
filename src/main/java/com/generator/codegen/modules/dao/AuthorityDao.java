package com.generator.codegen.modules.dao;

import com.generator.codegen.common.dao.BaseDao;
import com.generator.codegen.common.dao.annotation.MyBatisDao;
import com.generator.codegen.modules.model.Authority;

@MyBatisDao
public interface AuthorityDao extends BaseDao<Authority, Long> {

}