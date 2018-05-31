package manageSystem.modules.service.impl;

import manageSystem.common.service.BaseService;
import manageSystem.modules.dao.UserRoleDao;
import manageSystem.modules.model.UserRole;
import manageSystem.modules.service.UserRoleService;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl extends BaseService<UserRoleDao, UserRole, String> implements UserRoleService {
}
