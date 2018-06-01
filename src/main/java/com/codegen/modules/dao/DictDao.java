package com.codegen.modules.dao;

import com.codegen.common.dao.BaseDao;
import com.codegen.common.dao.annotation.MyBatisDao;
import com.generator.codegen.common.dao.BaseDao;
import com.generator.codegen.common.dao.annotation.MyBatisDao;
import com.generator.codegen.modules.model.Dict;

@MyBatisDao
public interface DictDao extends BaseDao<Dict, String> {

}