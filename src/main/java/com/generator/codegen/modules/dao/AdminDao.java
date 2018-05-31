package manageSystem.modules.dao;

import manageSystem.common.dao.BaseDao;
import manageSystem.common.dao.annotation.MyBatisDao;
import manageSystem.modules.model.Admin;

@MyBatisDao
public interface AdminDao extends BaseDao<Admin, Long> {

}