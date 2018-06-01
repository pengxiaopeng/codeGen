package com.codegen.modules.dao;

import com.codegen.modules.model.Menu;
import com.generator.codegen.common.dao.BaseDao;
import com.generator.codegen.common.dao.annotation.MyBatisDao;
import com.generator.codegen.modules.model.Menu;

@MyBatisDao
public interface MenuDao extends BaseDao<Menu, String> {

}