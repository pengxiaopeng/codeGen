package com.generator.codegen.modules.dao;

import com.generator.codegen.common.dao.BaseDao;
import com.generator.codegen.common.dao.annotation.MyBatisDao;
import com.generator.codegen.modules.model.EmailReceivers;

@MyBatisDao
public interface EmailReceiversDao extends BaseDao<EmailReceivers, Long> {

}