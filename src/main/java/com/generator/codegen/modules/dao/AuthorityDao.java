package manageSystem.modules.dao;

import manageSystem.common.dao.BaseDao;
import manageSystem.common.dao.annotation.MyBatisDao;
import manageSystem.modules.model.Authority;

@MyBatisDao
public interface AuthorityDao extends BaseDao<Authority, Long> {

}