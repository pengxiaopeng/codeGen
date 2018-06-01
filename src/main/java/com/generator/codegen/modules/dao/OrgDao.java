package com.generator.codegen.modules.dao;

import com.generator.codegen.common.dao.BaseDao;
import com.generator.codegen.common.dao.annotation.MyBatisDao;
import com.generator.codegen.modules.model.Org;

@MyBatisDao
public interface OrgDao extends BaseDao<Org, Long> {

}