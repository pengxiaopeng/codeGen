package manageSystem.modules.dao;


import manageSystem.common.dao.BaseDao;
import manageSystem.common.dao.annotation.MyBatisDao;
import manageSystem.modules.model.UserRole;

@MyBatisDao
public interface UserRoleDao extends BaseDao<UserRole, String> {

}