package com.generator.codegen.modules.service.impl;


import com.generator.codegen.common.service.BaseService;
import com.generator.codegen.modules.dao.CategoryDao;
import com.generator.codegen.modules.model.Category;
import com.generator.codegen.modules.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends BaseService<CategoryDao, Category, String> implements CategoryService {
}

