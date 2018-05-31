package manageSystem.modules.service.impl;

import manageSystem.common.service.BaseService;
import manageSystem.modules.dao.ActivitiTypeDao;
import manageSystem.modules.model.ActivitiType;
import manageSystem.modules.service.ActivitiTypeService;
import org.springframework.stereotype.Service;

@Service
public class ActivitiTypeServiceImpl extends BaseService<ActivitiTypeDao, ActivitiType, Long> implements ActivitiTypeService {
}
