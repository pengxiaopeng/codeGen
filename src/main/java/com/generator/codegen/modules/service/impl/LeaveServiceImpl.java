package manageSystem.modules.service.impl;

import manageSystem.common.service.BaseService;
import manageSystem.modules.dao.LeaveDao;
import manageSystem.modules.model.Leave;
import manageSystem.modules.service.LeaveService;
import org.springframework.stereotype.Service;

@Service
public class LeaveServiceImpl extends BaseService<LeaveDao, Leave, Long> implements LeaveService {
}
