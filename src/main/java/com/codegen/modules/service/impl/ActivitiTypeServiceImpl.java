package com.codegen.modules.service.impl;

import com.codegen.common.service.BaseService;
import com.codegen.modules.service.ActivitiTypeService;
import com.generator.codegen.common.service.BaseService;
import com.generator.codegen.modules.dao.ActivitiTypeDao;
import com.generator.codegen.modules.model.ActivitiType;
import com.generator.codegen.modules.service.ActivitiTypeService;
import org.springframework.stereotype.Service;

@Service
public class ActivitiTypeServiceImpl extends BaseService<ActivitiTypeDao, ActivitiType, Long> implements ActivitiTypeService {
}
