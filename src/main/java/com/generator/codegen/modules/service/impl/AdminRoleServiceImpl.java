package com.generator.codegen.modules.service.impl;

import com.generator.codegen.common.service.BaseService;
import com.generator.codegen.modules.dao.AdminRoleDao;
import com.generator.codegen.modules.model.AdminRole;
import com.generator.codegen.modules.service.AdminRoleService;
import org.springframework.stereotype.Service;

@Service
public class AdminRoleServiceImpl extends BaseService<AdminRoleDao, AdminRole, Long> implements AdminRoleService {
}
