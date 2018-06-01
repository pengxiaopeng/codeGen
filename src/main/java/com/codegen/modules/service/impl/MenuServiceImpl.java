package com.codegen.modules.service.impl;

import com.codegen.common.service.BaseService;
import com.codegen.modules.service.MenuService;
import com.codegen.common.service.BaseService;
import com.codegen.modules.dao.MenuDao;
import com.codegen.modules.model.Menu;
import com.codegen.modules.service.MenuService;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl extends BaseService<MenuDao, Menu, String> implements MenuService {
}
