package com.codegen.modules.service.impl;

import com.codegen.common.service.BaseService;
import com.codegen.modules.dao.AdminRoleDao;
import com.codegen.modules.model.AdminRole;
import com.codegen.modules.service.AdminRoleService;
import org.springframework.stereotype.Service;

@Service
public class AdminRoleServiceImpl extends BaseService<AdminRoleDao, AdminRole, Long> implements AdminRoleService {
}
