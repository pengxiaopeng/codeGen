package manageSystem.modules.service.impl;

import manageSystem.common.service.BaseService;
import manageSystem.modules.dao.EmailReceiversDao;
import manageSystem.modules.model.EmailReceivers;
import manageSystem.modules.service.EmailReceiversService;
import org.springframework.stereotype.Service;

@Service
public class EmailReceiversServiceImpl extends BaseService<EmailReceiversDao, EmailReceivers, Long> implements EmailReceiversService {
}
