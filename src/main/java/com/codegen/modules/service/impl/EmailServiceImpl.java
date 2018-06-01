package com.codegen.modules.service.impl;

import com.codegen.common.service.BaseService;
import com.codegen.modules.service.EmailService;
import com.codegen.common.service.BaseService;
import com.codegen.modules.dao.EmailDao;
import com.codegen.modules.model.Email;
import com.codegen.modules.service.EmailService;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl extends BaseService<EmailDao, Email, Long> implements EmailService {
}
