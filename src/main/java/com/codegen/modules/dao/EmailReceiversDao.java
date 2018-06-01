package com.codegen.modules.dao;

import com.codegen.modules.model.EmailReceivers;
import com.codegen.common.dao.BaseDao;
import com.codegen.common.dao.annotation.MyBatisDao;
import com.codegen.modules.model.EmailReceivers;

@MyBatisDao
public interface EmailReceiversDao extends BaseDao<EmailReceivers, Long> {

}