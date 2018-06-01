package com.generator.codegen.modules.service.impl;

import com.generator.codegen.common.service.BaseService;
import com.generator.codegen.modules.dao.DictDao;
import com.generator.codegen.modules.model.Dict;
import com.generator.codegen.modules.service.DictService;
import org.springframework.stereotype.Service;

@Service
public class DictServiceImpl extends BaseService<DictDao, Dict, String> implements DictService {
}
