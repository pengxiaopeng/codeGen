package com.codegen.modules.service.impl;

import com.codegen.common.service.BaseService;
import com.codegen.modules.dao.UserDao;
import com.codegen.modules.model.User;
import com.codegen.modules.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseService<UserDao, User, String> implements UserService {
}
