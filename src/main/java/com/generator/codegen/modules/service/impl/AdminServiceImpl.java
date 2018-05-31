package manageSystem.modules.service.impl;

import manageSystem.common.service.BaseService;
import manageSystem.modules.dao.AdminDao;
import manageSystem.modules.model.Admin;
import manageSystem.modules.service.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends BaseService<AdminDao, Admin, Long> implements AdminService {
}
