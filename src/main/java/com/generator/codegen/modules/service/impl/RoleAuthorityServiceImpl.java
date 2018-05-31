package manageSystem.modules.service.impl;

import manageSystem.common.service.BaseService;
import manageSystem.modules.dao.RoleAuthorityDao;
import manageSystem.modules.model.RoleAuthority;
import manageSystem.modules.service.RoleAuthorityService;
import org.springframework.stereotype.Service;

@Service
public class RoleAuthorityServiceImpl extends BaseService<RoleAuthorityDao, RoleAuthority, Long> implements RoleAuthorityService {
}
