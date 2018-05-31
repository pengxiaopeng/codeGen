package manageSystem.modules.dao;

import manageSystem.common.dao.BaseDao;
import manageSystem.common.dao.annotation.MyBatisDao;
import manageSystem.modules.model.Code;

@MyBatisDao
public interface CodeDao extends BaseDao<Code, Long> {

}