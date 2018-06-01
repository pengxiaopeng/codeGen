package com.codegen.modules.dao;


import com.codegen.modules.model.UserRole;
import com.codegen.common.dao.BaseDao;
import com.codegen.common.dao.annotation.MyBatisDao;
import com.codegen.modules.model.UserRole;

@MyBatisDao
public interface UserRoleDao extends BaseDao<UserRole, String> {

}