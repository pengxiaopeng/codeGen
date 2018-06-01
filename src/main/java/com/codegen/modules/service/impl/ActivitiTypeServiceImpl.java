package com.codegen.modules.service.impl;

import com.codegen.common.service.BaseService;
import com.codegen.modules.service.ActivitiTypeService;
import com.codegen.common.service.BaseService;
import com.codegen.modules.dao.ActivitiTypeDao;
import com.codegen.modules.model.ActivitiType;
import com.codegen.modules.service.ActivitiTypeService;
import org.springframework.stereotype.Service;

@Service
public class ActivitiTypeServiceImpl extends BaseService<ActivitiTypeDao, ActivitiType, Long> implements ActivitiTypeService {
}
