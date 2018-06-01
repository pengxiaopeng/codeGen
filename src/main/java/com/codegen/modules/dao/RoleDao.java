package com.codegen.modules.dao;

import com.generator.codegen.common.dao.BaseDao;
import com.generator.codegen.common.dao.annotation.MyBatisDao;
import com.generator.codegen.modules.model.Role;

@MyBatisDao
public interface RoleDao extends BaseDao<Role, Long> {

}