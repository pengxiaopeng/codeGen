package manageSystem.modules.dao;

import manageSystem.common.dao.BaseDao;
import manageSystem.common.dao.annotation.MyBatisDao;
import manageSystem.modules.model.Email;

@MyBatisDao
public interface EmailDao extends BaseDao<Email, Long> {

}