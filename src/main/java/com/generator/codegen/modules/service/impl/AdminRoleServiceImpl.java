package manageSystem.modules.service.impl;

import manageSystem.common.service.BaseService;
import manageSystem.modules.dao.AdminRoleDao;
import manageSystem.modules.model.AdminRole;
import manageSystem.modules.service.AdminRoleService;
import org.springframework.stereotype.Service;

@Service
public class AdminRoleServiceImpl extends BaseService<AdminRoleDao, AdminRole, Long> implements AdminRoleService {
}
