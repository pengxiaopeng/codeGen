package manageSystem.modules.dao;

import manageSystem.common.dao.BaseDao;
import manageSystem.common.dao.annotation.MyBatisDao;
import manageSystem.modules.model.RoleAuthority;

@MyBatisDao
public interface RoleAuthorityDao extends BaseDao<RoleAuthority, Long> {

}