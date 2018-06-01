package com.codegen.modules.dao;

import com.codegen.modules.model.RoleAuthority;
import com.codegen.common.dao.BaseDao;
import com.codegen.common.dao.annotation.MyBatisDao;
import com.codegen.modules.model.RoleAuthority;

@MyBatisDao
public interface RoleAuthorityDao extends BaseDao<RoleAuthority, Long> {

}