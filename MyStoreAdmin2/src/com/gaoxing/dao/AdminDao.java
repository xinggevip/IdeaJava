package com.gaoxing.dao;


import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.gaoxing.domain.Admin;
import com.gaoxing.jdbc.util.JdbcUtil;

public class AdminDao {

	public Admin checkAdmin(String username, String password) throws SQLException {
		
		// 到数据库中查询
		// 1.连接数据库
		QueryRunner qr = JdbcUtil.getQueryRunner();
		// 2.查询
		String sql = "select * from admin where username=? and password=?";
		Admin admin = null;
		admin = qr.query(sql, new BeanHandler<Admin>(Admin.class),username,password);
		// 返回查询结果
		return admin;
	}

}
