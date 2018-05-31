package manageSystem.modules.service.impl;

import manageSystem.common.service.BaseService;
import manageSystem.modules.dao.CodeItemDao;
import manageSystem.modules.model.CodeItem;
import manageSystem.modules.service.CodeItemService;
import org.springframework.stereotype.Service;

@Service
public class CodeItemServiceImpl extends BaseService<CodeItemDao, CodeItem, Long> implements CodeItemService {
}
