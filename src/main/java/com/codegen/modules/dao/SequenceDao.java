package com.codegen.modules.dao;

import com.codegen.modules.model.Sequence;
import com.generator.codegen.common.dao.BaseDao;
import com.generator.codegen.common.dao.annotation.MyBatisDao;
import com.generator.codegen.modules.model.Sequence;

@MyBatisDao
public interface SequenceDao extends BaseDao<Sequence, Long> {

}