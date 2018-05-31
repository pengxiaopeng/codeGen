package manageSystem.modules.dao;

import manageSystem.common.dao.BaseDao;
import manageSystem.common.dao.annotation.MyBatisDao;
import manageSystem.modules.model.DataDictionary;

@MyBatisDao
public interface DataDictionaryDao extends BaseDao<DataDictionary, Long> {

}