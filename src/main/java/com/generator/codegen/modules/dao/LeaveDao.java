package manageSystem.modules.dao;

import manageSystem.common.dao.BaseDao;
import manageSystem.common.dao.annotation.MyBatisDao;
import manageSystem.modules.model.Leave;

@MyBatisDao
public interface LeaveDao extends BaseDao<Leave, Long> {

}