package com.generator.codegen.modules.dao;


import com.generator.codegen.common.dao.BaseDao;
import com.generator.codegen.common.dao.annotation.MyBatisDao;
import com.generator.codegen.modules.model.Admin;
import com.generator.codegen.modules.model.AdminRole;

@MyBatisDao
public interface AdminRoleDao extends BaseDao<AdminRole, Long> {

}