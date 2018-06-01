package com.codegen.modules.dao;

import com.codegen.modules.model.DataDictionary;
import com.generator.codegen.common.dao.BaseDao;
import com.generator.codegen.common.dao.annotation.MyBatisDao;
import com.generator.codegen.modules.model.DataDictionary;

@MyBatisDao
public interface DataDictionaryDao extends BaseDao<DataDictionary, Long> {

}