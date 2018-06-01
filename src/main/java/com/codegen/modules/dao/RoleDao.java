package com.codegen.modules.dao;

import com.codegen.common.dao.BaseDao;
import com.codegen.common.dao.annotation.MyBatisDao;
import com.codegen.modules.model.Role;

@MyBatisDao
public interface RoleDao extends BaseDao<Role, Long> {

}