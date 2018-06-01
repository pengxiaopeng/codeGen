package com.codegen.generator.db;

/**
 * 数据库常量
 * 
 * @author xuyb
 */
public interface Consts {
	String DB_NAME = "zyfast"; // 数据库名称
	String DB_HOST = "localhost"; // 数据库HOST
	int DB_PORT = 3307; // 数据库端口
	String DB_USER = "root"; // 用户名
	String DB_PASS = "123456"; // 密码

	// 表前缀限制,传空表示不限制表前缀
	String DB_TABLE_PREFIX = "bid_"; // 表前缀

	String TARGET_DIR = "E:/generate/"; // 生成代码存放目录

}