package com.codegen.modules.service.impl;


import com.codegen.common.service.BaseService;
import com.codegen.modules.dao.CategoryDao;
import com.codegen.modules.model.Category;
import com.codegen.modules.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends BaseService<CategoryDao, Category, String> implements CategoryService {
}

