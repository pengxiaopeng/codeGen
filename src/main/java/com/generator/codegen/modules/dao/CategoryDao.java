package manageSystem.modules.dao;


import manageSystem.common.dao.BaseDao;
import manageSystem.common.dao.annotation.MyBatisDao;
import manageSystem.modules.model.Category;


@MyBatisDao
public interface CategoryDao extends BaseDao<Category, String> {
}