package com.codegen.modules.service.impl;

import com.codegen.common.service.BaseService;
import com.codegen.modules.dao.DictDao;
import com.codegen.modules.model.Dict;
import com.codegen.modules.service.DictService;
import org.springframework.stereotype.Service;

@Service
public class DictServiceImpl extends BaseService<DictDao, Dict, String> implements DictService {
}
