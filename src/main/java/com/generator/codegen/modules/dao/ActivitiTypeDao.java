package manageSystem.modules.dao;


import manageSystem.common.dao.BaseDao;
import manageSystem.common.dao.annotation.MyBatisDao;
import manageSystem.modules.model.ActivitiType;

@MyBatisDao
public interface ActivitiTypeDao extends BaseDao<ActivitiType, Long> {
}