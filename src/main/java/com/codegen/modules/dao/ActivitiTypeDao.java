package com.codegen.modules.dao;


import com.codegen.modules.model.ActivitiType;
import com.codegen.common.dao.BaseDao;
import com.codegen.common.dao.annotation.MyBatisDao;
import com.codegen.modules.model.ActivitiType;

@MyBatisDao
public interface ActivitiTypeDao extends BaseDao<ActivitiType, Long> {
}