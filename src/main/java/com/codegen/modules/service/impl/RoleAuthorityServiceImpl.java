package com.codegen.modules.service.impl;

import com.codegen.common.service.BaseService;
import com.codegen.modules.dao.RoleAuthorityDao;
import com.codegen.modules.model.RoleAuthority;
import com.codegen.modules.service.RoleAuthorityService;
import org.springframework.stereotype.Service;

@Service
public class RoleAuthorityServiceImpl extends BaseService<RoleAuthorityDao, RoleAuthority, Long> implements RoleAuthorityService {
}
