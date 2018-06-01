package com.codegen.modules.dao;

import com.codegen.modules.model.Email;
import com.codegen.common.dao.BaseDao;
import com.codegen.common.dao.annotation.MyBatisDao;
import com.codegen.modules.model.Email;

@MyBatisDao
public interface EmailDao extends BaseDao<Email, Long> {

}