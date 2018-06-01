package com.generator.codegen.modules.service.impl;

import com.generator.codegen.common.service.BaseService;
import com.generator.codegen.modules.dao.DataDictionaryDao;
import com.generator.codegen.modules.model.DataDictionary;
import com.generator.codegen.modules.service.DataDictionaryService;
import org.springframework.stereotype.Service;

@Service
public class DataDictionaryServiceImpl extends BaseService<DataDictionaryDao, DataDictionary, Long> implements DataDictionaryService {
}
