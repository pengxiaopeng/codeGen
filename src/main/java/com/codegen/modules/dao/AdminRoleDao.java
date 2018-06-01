package com.codegen.modules.dao;


import com.codegen.modules.model.AdminRole;
import com.generator.codegen.common.dao.BaseDao;
import com.generator.codegen.common.dao.annotation.MyBatisDao;
import com.generator.codegen.modules.model.Admin;
import com.generator.codegen.modules.model.AdminRole;

@MyBatisDao
public interface AdminRoleDao extends BaseDao<AdminRole, Long> {

}