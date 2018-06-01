package com.codegen.modules.service.impl;

import com.codegen.common.service.BaseService;
import com.codegen.modules.service.UserRoleService;
import com.generator.codegen.common.service.BaseService;
import com.generator.codegen.modules.dao.UserRoleDao;
import com.generator.codegen.modules.model.UserRole;
import com.generator.codegen.modules.service.UserRoleService;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl extends BaseService<UserRoleDao, UserRole, String> implements UserRoleService {
}
