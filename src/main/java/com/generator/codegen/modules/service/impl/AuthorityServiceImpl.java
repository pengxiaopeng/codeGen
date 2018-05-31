package manageSystem.modules.service.impl;

import manageSystem.common.service.BaseService;
import manageSystem.modules.dao.AuthorityDao;
import manageSystem.modules.model.Authority;
import manageSystem.modules.service.AuthorityService;
import org.springframework.stereotype.Service;

@Service
public class AuthorityServiceImpl extends BaseService<AuthorityDao, Authority, Long> implements AuthorityService {
}
