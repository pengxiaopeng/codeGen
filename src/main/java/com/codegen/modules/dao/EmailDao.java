package com.codegen.modules.dao;

import com.codegen.modules.model.Email;
import com.generator.codegen.common.dao.BaseDao;
import com.generator.codegen.common.dao.annotation.MyBatisDao;
import com.generator.codegen.modules.model.Email;

@MyBatisDao
public interface EmailDao extends BaseDao<Email, Long> {

}