package com.codegen.modules.dao;

import com.codegen.modules.model.Leave;
import com.generator.codegen.common.dao.BaseDao;
import com.generator.codegen.common.dao.annotation.MyBatisDao;
import com.generator.codegen.modules.model.Leave;

@MyBatisDao
public interface LeaveDao extends BaseDao<Leave, Long> {

}