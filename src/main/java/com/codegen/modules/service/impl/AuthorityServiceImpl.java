package com.codegen.modules.service.impl;

import com.codegen.common.service.BaseService;
import com.codegen.modules.service.AuthorityService;
import com.codegen.common.service.BaseService;
import com.codegen.modules.dao.AuthorityDao;
import com.codegen.modules.model.Authority;
import com.codegen.modules.service.AuthorityService;
import org.springframework.stereotype.Service;

@Service
public class AuthorityServiceImpl extends BaseService<AuthorityDao, Authority, Long> implements AuthorityService {
}
