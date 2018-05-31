package manageSystem.modules.dao;


import manageSystem.common.dao.BaseDao;
import manageSystem.common.dao.annotation.MyBatisDao;
import manageSystem.modules.model.User;

@MyBatisDao
public interface UserDao extends BaseDao<User, String> {

}