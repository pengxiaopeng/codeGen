package com.codegen.modules.dao;


import com.codegen.modules.model.AdminRole;
import com.codegen.common.dao.BaseDao;
import com.codegen.common.dao.annotation.MyBatisDao;
import com.codegen.modules.model.Admin;
import com.codegen.modules.model.AdminRole;

@MyBatisDao
public interface AdminRoleDao extends BaseDao<AdminRole, Long> {

}