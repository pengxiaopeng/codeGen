package manageSystem.modules.service.impl;

import manageSystem.common.service.BaseService;
import manageSystem.modules.dao.MenuDao;
import manageSystem.modules.model.Menu;
import manageSystem.modules.service.MenuService;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl extends BaseService<MenuDao, Menu, String> implements MenuService {
}
