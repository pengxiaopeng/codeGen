package com.codegen.modules.dao;

import com.codegen.modules.model.Admin;
import com.codegen.common.dao.BaseDao;
import com.codegen.common.dao.annotation.MyBatisDao;
import com.codegen.modules.model.Admin;

@MyBatisDao
public interface AdminDao extends BaseDao<Admin, Long> {

}