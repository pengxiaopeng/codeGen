package com.codegen.modules.service.impl;

import com.codegen.common.service.BaseService;
import com.codegen.modules.service.MenuService;
import com.generator.codegen.common.service.BaseService;
import com.generator.codegen.modules.dao.MenuDao;
import com.generator.codegen.modules.model.Menu;
import com.generator.codegen.modules.service.MenuService;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl extends BaseService<MenuDao, Menu, String> implements MenuService {
}
