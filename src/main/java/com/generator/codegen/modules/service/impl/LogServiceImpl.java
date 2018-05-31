package manageSystem.modules.service.impl;

import manageSystem.common.service.BaseService;
import manageSystem.modules.dao.LogDao;
import manageSystem.modules.model.Log;
import manageSystem.modules.service.LogService;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl extends BaseService<LogDao, Log, Long> implements LogService {
}
