package manageSystem.modules.service.impl;

import manageSystem.common.service.BaseService;
import manageSystem.modules.dao.DictDao;
import manageSystem.modules.model.Dict;
import manageSystem.modules.service.DictService;
import org.springframework.stereotype.Service;

@Service
public class DictServiceImpl extends BaseService<DictDao, Dict, String> implements DictService {
}
