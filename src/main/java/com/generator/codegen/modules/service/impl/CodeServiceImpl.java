package com.generator.codegen.modules.service.impl;

import com.generator.codegen.common.service.BaseService;
import com.generator.codegen.modules.dao.CodeDao;
import com.generator.codegen.modules.model.Code;
import com.generator.codegen.modules.service.CodeService;
import org.springframework.stereotype.Service;

@Service
public class CodeServiceImpl extends BaseService<CodeDao, Code, Long> implements CodeService {
}
