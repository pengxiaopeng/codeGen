package manageSystem.modules.dao;

import manageSystem.common.dao.BaseDao;
import manageSystem.common.dao.annotation.MyBatisDao;
import manageSystem.modules.model.Sequence;

@MyBatisDao
public interface SequenceDao extends BaseDao<Sequence, Long> {

}