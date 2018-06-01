package com.codegen.modules.service.impl;

import com.codegen.common.service.BaseService;
import com.codegen.modules.dao.RoleDao;
import com.codegen.modules.model.Role;
import com.codegen.modules.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends BaseService<RoleDao, Role, Long> implements RoleService {
}
