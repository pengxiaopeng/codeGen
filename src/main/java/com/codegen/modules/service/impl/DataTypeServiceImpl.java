package com.codegen.modules.service.impl;

import com.generator.codegen.common.service.BaseService;
import com.generator.codegen.modules.dao.DataTypeDao;
import com.generator.codegen.modules.model.DataType;
import com.generator.codegen.modules.service.DataTypeService;
import org.springframework.stereotype.Service;

@Service
public class DataTypeServiceImpl extends BaseService<DataTypeDao, DataType, Long> implements DataTypeService {
}
