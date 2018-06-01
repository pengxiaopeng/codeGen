package com.codegen.modules.service.impl;

import com.codegen.common.service.BaseService;
import com.codegen.modules.dao.CodeDao;
import com.codegen.modules.model.Code;
import com.codegen.modules.service.CodeService;
import org.springframework.stereotype.Service;

@Service
public class CodeServiceImpl extends BaseService<CodeDao, Code, Long> implements CodeService {
}
