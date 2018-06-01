package com.codegen.modules.dao;

import com.codegen.modules.model.Menu;
import com.codegen.common.dao.BaseDao;
import com.codegen.common.dao.annotation.MyBatisDao;
import com.codegen.modules.model.Menu;

@MyBatisDao
public interface MenuDao extends BaseDao<Menu, String> {

}