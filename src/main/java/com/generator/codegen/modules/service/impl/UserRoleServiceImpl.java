package com.generator.codegen.modules.service.impl;

import com.generator.codegen.common.service.BaseService;
import com.generator.codegen.modules.dao.UserRoleDao;
import com.generator.codegen.modules.model.UserRole;
import com.generator.codegen.modules.service.UserRoleService;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl extends BaseService<UserRoleDao, UserRole, String> implements UserRoleService {
}
