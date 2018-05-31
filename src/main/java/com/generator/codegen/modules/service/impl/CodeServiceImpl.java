package manageSystem.modules.service.impl;

import manageSystem.common.service.BaseService;
import manageSystem.modules.dao.CodeDao;
import manageSystem.modules.model.Code;
import manageSystem.modules.service.CodeService;
import org.springframework.stereotype.Service;

@Service
public class CodeServiceImpl extends BaseService<CodeDao, Code, Long> implements CodeService {
}
