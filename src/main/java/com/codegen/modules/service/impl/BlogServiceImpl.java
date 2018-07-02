package com.codegen.modules.service.impl;

import com.codegen.common.service.BaseService;
import com.codegen.modules.dao.BlogDao;
import com.codegen.modules.model.Blog;
import com.codegen.modules.service.BlogService;
import org.springframework.stereotype.Service;

/**
 * Service - bid_blog
 * @author	pengxiaopeng
 * @version 2.0
 * @date 	2018-07-02
 */
@Service
public class BlogServiceImpl extends BaseService<BlogDao, Blog, Long> implements BlogService {
}
