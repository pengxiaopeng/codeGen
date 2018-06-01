package com.codegen.modules.service.impl;

import com.codegen.common.service.BaseService;
import com.codegen.modules.service.EmailReceiversService;
import com.codegen.common.service.BaseService;
import com.codegen.modules.dao.EmailReceiversDao;
import com.codegen.modules.model.EmailReceivers;
import com.codegen.modules.service.EmailReceiversService;
import org.springframework.stereotype.Service;

@Service
public class EmailReceiversServiceImpl extends BaseService<EmailReceiversDao, EmailReceivers, Long> implements EmailReceiversService {
}
