package com.codegen.modules.dao;

import com.codegen.modules.model.Code;
import com.codegen.common.dao.BaseDao;
import com.codegen.common.dao.annotation.MyBatisDao;
import com.codegen.modules.model.Code;

@MyBatisDao
public interface CodeDao extends BaseDao<Code, Long> {

}