package com.codegen.modules.dao;

import com.codegen.modules.model.Admin;
import com.generator.codegen.common.dao.BaseDao;
import com.generator.codegen.common.dao.annotation.MyBatisDao;
import com.generator.codegen.modules.model.Admin;

@MyBatisDao
public interface AdminDao extends BaseDao<Admin, Long> {

}