package com.codegen.modules.dao;


import com.codegen.modules.model.User;
import com.codegen.common.dao.BaseDao;
import com.codegen.common.dao.annotation.MyBatisDao;
import com.codegen.modules.model.User;

@MyBatisDao
public interface UserDao extends BaseDao<User, String> {

}