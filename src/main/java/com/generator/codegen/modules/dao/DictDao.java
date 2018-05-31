package manageSystem.modules.dao;

import manageSystem.common.dao.BaseDao;
import manageSystem.common.dao.annotation.MyBatisDao;
import manageSystem.modules.model.Dict;

@MyBatisDao
public interface DictDao extends BaseDao<Dict, String> {

}