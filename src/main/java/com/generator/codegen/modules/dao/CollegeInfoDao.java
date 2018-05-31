package manageSystem.modules.dao;

import manageSystem.common.dao.BaseDao;
import manageSystem.common.dao.annotation.MyBatisDao;
import manageSystem.modules.model.CollegeInfo;

@MyBatisDao
public interface CollegeInfoDao extends BaseDao<CollegeInfo, Long> {

}