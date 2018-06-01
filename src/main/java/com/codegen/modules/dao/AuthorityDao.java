package com.codegen.modules.dao;

import com.codegen.common.dao.BaseDao;
import com.codegen.common.dao.annotation.MyBatisDao;
import com.codegen.modules.model.Authority;

@MyBatisDao
public interface AuthorityDao extends BaseDao<Authority, Long> {

}