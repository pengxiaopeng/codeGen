package com.codegen.modules.service.impl;

import com.codegen.common.service.BaseService;
import com.codegen.modules.dao.DataTypeDao;
import com.codegen.modules.model.DataType;
import com.codegen.modules.service.DataTypeService;
import org.springframework.stereotype.Service;

@Service
public class DataTypeServiceImpl extends BaseService<DataTypeDao, DataType, Long> implements DataTypeService {
}
