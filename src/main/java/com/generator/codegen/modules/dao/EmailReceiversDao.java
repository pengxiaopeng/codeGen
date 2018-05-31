package manageSystem.modules.dao;

import manageSystem.common.dao.BaseDao;
import manageSystem.common.dao.annotation.MyBatisDao;
import manageSystem.modules.model.EmailReceivers;

@MyBatisDao
public interface EmailReceiversDao extends BaseDao<EmailReceivers, Long> {

}