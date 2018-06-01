package com.codegen.modules.service.impl;

import com.generator.codegen.common.service.BaseService;
import com.generator.codegen.modules.dao.LeaveDao;
import com.generator.codegen.modules.model.Leave;
import com.generator.codegen.modules.service.LeaveService;
import org.springframework.stereotype.Service;

@Service
public class LeaveServiceImpl extends BaseService<LeaveDao, Leave, Long> implements LeaveService {
}
