package com.codegen.modules.service.impl;

import com.codegen.common.service.BaseService;
import com.codegen.modules.dao.LogDao;
import com.codegen.modules.model.Log;
import com.codegen.modules.service.LogService;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl extends BaseService<LogDao, Log, Long> implements LogService {
}
