package com.codegen.modules.dao;

import com.codegen.modules.model.DataType;
import com.codegen.common.dao.BaseDao;
import com.codegen.common.dao.annotation.MyBatisDao;
import com.codegen.modules.model.DataType;

@MyBatisDao
public interface DataTypeDao extends BaseDao<DataType, Long> {

}