package com.codegen.modules.dao;

import com.codegen.modules.model.DataDictionary;
import com.codegen.common.dao.BaseDao;
import com.codegen.common.dao.annotation.MyBatisDao;
import com.codegen.modules.model.DataDictionary;

@MyBatisDao
public interface DataDictionaryDao extends BaseDao<DataDictionary, Long> {

}