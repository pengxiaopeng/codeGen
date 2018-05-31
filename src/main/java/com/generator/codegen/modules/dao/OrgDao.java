package manageSystem.modules.dao;

import manageSystem.common.dao.BaseDao;
import manageSystem.common.dao.annotation.MyBatisDao;
import manageSystem.modules.model.Org;

@MyBatisDao
public interface OrgDao extends BaseDao<Org, Long> {

}