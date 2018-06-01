package com.generator.codegen.modules.service.impl;

import com.generator.codegen.common.service.BaseService;
import com.generator.codegen.modules.dao.AdminDao;
import com.generator.codegen.modules.model.Admin;
import com.generator.codegen.modules.service.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends BaseService<AdminDao, Admin, Long> implements AdminService {
}
