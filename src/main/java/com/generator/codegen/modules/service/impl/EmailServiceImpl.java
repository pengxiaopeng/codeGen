package manageSystem.modules.service.impl;

import manageSystem.common.service.BaseService;
import manageSystem.modules.dao.EmailDao;
import manageSystem.modules.model.Email;
import manageSystem.modules.service.EmailService;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl extends BaseService<EmailDao, Email, Long> implements EmailService {
}
