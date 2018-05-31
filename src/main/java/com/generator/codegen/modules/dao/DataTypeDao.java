package manageSystem.modules.dao;

import manageSystem.common.dao.BaseDao;
import manageSystem.common.dao.annotation.MyBatisDao;
import manageSystem.modules.model.DataType;

@MyBatisDao
public interface DataTypeDao extends BaseDao<DataType, Long> {

}