package com.codegen.modules.service.impl;

import com.codegen.common.service.BaseService;
import com.codegen.modules.service.DataDictionaryService;
import com.codegen.common.service.BaseService;
import com.codegen.modules.dao.DataDictionaryDao;
import com.codegen.modules.model.DataDictionary;
import com.codegen.modules.service.DataDictionaryService;
import org.springframework.stereotype.Service;

@Service
public class DataDictionaryServiceImpl extends BaseService<DataDictionaryDao, DataDictionary, Long> implements DataDictionaryService {
}
