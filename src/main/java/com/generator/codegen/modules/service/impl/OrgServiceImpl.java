package manageSystem.modules.service.impl;

import manageSystem.common.service.BaseService;
import manageSystem.modules.dao.OrgDao;
import manageSystem.modules.model.Org;
import manageSystem.modules.service.OrgService;
import org.springframework.stereotype.Service;

@Service
public class OrgServiceImpl extends BaseService<OrgDao, Org, Long> implements OrgService {
}
