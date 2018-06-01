package com.generator.codegen.modules.service.impl;

import com.generator.codegen.common.service.BaseService;
import com.generator.codegen.modules.dao.LogDao;
import com.generator.codegen.modules.model.Log;
import com.generator.codegen.modules.service.LogService;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl extends BaseService<LogDao, Log, Long> implements LogService {
}
