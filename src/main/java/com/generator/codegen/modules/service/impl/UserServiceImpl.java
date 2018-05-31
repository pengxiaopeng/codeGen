package manageSystem.modules.service.impl;

import manageSystem.common.service.BaseService;
import manageSystem.modules.dao.UserDao;
import manageSystem.modules.model.User;
import manageSystem.modules.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseService<UserDao, User, String> implements UserService {
}
