package com.generator.codegen.modules.service.impl;

import com.generator.codegen.common.service.BaseService;
import com.generator.codegen.modules.dao.RoleAuthorityDao;
import com.generator.codegen.modules.model.RoleAuthority;
import com.generator.codegen.modules.service.RoleAuthorityService;
import org.springframework.stereotype.Service;

@Service
public class RoleAuthorityServiceImpl extends BaseService<RoleAuthorityDao, RoleAuthority, Long> implements RoleAuthorityService {
}
