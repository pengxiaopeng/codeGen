package manageSystem.modules.service.impl;

import manageSystem.common.service.BaseService;
import manageSystem.modules.dao.RoleDao;
import manageSystem.modules.model.Role;
import manageSystem.modules.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends BaseService<RoleDao, Role, Long> implements RoleService {
}
