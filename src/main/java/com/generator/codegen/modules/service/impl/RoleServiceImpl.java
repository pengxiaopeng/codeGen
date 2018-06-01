package com.generator.codegen.modules.service.impl;

import com.generator.codegen.common.service.BaseService;
import com.generator.codegen.modules.dao.RoleDao;
import com.generator.codegen.modules.model.Role;
import com.generator.codegen.modules.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends BaseService<RoleDao, Role, Long> implements RoleService {
}
