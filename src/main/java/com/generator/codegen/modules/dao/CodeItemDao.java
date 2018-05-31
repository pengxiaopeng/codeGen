package manageSystem.modules.dao;

import manageSystem.common.dao.BaseDao;
import manageSystem.common.dao.annotation.MyBatisDao;
import manageSystem.modules.model.CodeItem;

@MyBatisDao
public interface CodeItemDao extends BaseDao<CodeItem, Long> {

}