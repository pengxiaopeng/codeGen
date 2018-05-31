package manageSystem.modules.dao;

import manageSystem.common.dao.BaseDao;
import manageSystem.common.dao.annotation.MyBatisDao;
import manageSystem.modules.model.Role;

@MyBatisDao
public interface RoleDao extends BaseDao<Role, Long> {

}