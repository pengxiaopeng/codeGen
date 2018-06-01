package com.codegen.modules.dao;

import com.codegen.modules.model.Sequence;
import com.codegen.common.dao.BaseDao;
import com.codegen.common.dao.annotation.MyBatisDao;
import com.codegen.modules.model.Sequence;

@MyBatisDao
public interface SequenceDao extends BaseDao<Sequence, Long> {

}