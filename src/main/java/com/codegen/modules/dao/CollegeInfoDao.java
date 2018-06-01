package com.codegen.modules.dao;

import com.codegen.common.dao.BaseDao;
import com.codegen.common.dao.annotation.MyBatisDao;
import com.codegen.modules.model.CollegeInfo;

@MyBatisDao
public interface CollegeInfoDao extends BaseDao<CollegeInfo, Long> {

}