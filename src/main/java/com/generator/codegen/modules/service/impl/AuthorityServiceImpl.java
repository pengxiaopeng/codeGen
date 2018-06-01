package com.generator.codegen.modules.service.impl;

import com.generator.codegen.common.service.BaseService;
import com.generator.codegen.modules.dao.AuthorityDao;
import com.generator.codegen.modules.model.Authority;
import com.generator.codegen.modules.service.AuthorityService;
import org.springframework.stereotype.Service;

@Service
public class AuthorityServiceImpl extends BaseService<AuthorityDao, Authority, Long> implements AuthorityService {
}
