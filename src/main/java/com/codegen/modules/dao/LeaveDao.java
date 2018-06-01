package com.codegen.modules.dao;

import com.codegen.modules.model.Leave;
import com.codegen.common.dao.BaseDao;
import com.codegen.common.dao.annotation.MyBatisDao;
import com.codegen.modules.model.Leave;

@MyBatisDao
public interface LeaveDao extends BaseDao<Leave, Long> {

}