package com.generator.codegen.modules.service.impl;

import com.generator.codegen.common.service.BaseService;
import com.generator.codegen.modules.dao.CodeItemDao;
import com.generator.codegen.modules.model.CodeItem;
import com.generator.codegen.modules.service.CodeItemService;
import org.springframework.stereotype.Service;

@Service
public class CodeItemServiceImpl extends BaseService<CodeItemDao, CodeItem, Long> implements CodeItemService {
}
