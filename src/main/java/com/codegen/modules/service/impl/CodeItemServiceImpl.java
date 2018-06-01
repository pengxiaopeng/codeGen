package com.codegen.modules.service.impl;

import com.codegen.common.service.BaseService;
import com.codegen.modules.dao.CodeItemDao;
import com.codegen.modules.model.CodeItem;
import com.codegen.modules.service.CodeItemService;
import org.springframework.stereotype.Service;

@Service
public class CodeItemServiceImpl extends BaseService<CodeItemDao, CodeItem, Long> implements CodeItemService {
}
