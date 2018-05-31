package manageSystem.modules.dao;

import manageSystem.common.dao.BaseDao;
import manageSystem.common.dao.annotation.MyBatisDao;
import manageSystem.modules.model.Menu;

@MyBatisDao
public interface MenuDao extends BaseDao<Menu, String> {

}