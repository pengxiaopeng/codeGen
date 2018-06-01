package com.codegen.modules.service.impl;

import com.codegen.common.service.BaseService;
import com.codegen.modules.dao.LeaveDao;
import com.codegen.modules.model.Leave;
import com.codegen.modules.service.LeaveService;
import org.springframework.stereotype.Service;

@Service
public class LeaveServiceImpl extends BaseService<LeaveDao, Leave, Long> implements LeaveService {
}
