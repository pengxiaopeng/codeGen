package manageSystem.modules.dao;


import manageSystem.common.dao.BaseDao;
import manageSystem.common.dao.annotation.MyBatisDao;
import manageSystem.modules.model.Admin;
import manageSystem.modules.model.AdminRole;

@MyBatisDao
public interface AdminRoleDao extends BaseDao<AdminRole, Long> {

}