package com.codegen.modules.service.impl;

import com.codegen.common.service.BaseService;
import com.codegen.modules.dao.AdminDao;
import com.codegen.modules.model.Admin;
import com.codegen.modules.service.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends BaseService<AdminDao, Admin, Long> implements AdminService {
}
