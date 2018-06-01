package com.generator.codegen.modules.service.impl;

import com.generator.codegen.common.service.BaseService;
import com.generator.codegen.modules.dao.UserDao;
import com.generator.codegen.modules.model.User;
import com.generator.codegen.modules.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseService<UserDao, User, String> implements UserService {
}
