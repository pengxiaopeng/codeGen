package manageSystem.modules.service.impl;


import manageSystem.common.service.BaseService;
import manageSystem.modules.dao.CategoryDao;
import manageSystem.modules.model.Category;
import manageSystem.modules.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends BaseService<CategoryDao, Category, String> implements CategoryService {
}

