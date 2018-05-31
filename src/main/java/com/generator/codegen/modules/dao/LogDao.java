package manageSystem.modules.dao;

import manageSystem.common.dao.BaseDao;
import manageSystem.common.dao.annotation.MyBatisDao;
import manageSystem.modules.model.Log;

@MyBatisDao
public interface LogDao extends BaseDao<Log, Long> {

}