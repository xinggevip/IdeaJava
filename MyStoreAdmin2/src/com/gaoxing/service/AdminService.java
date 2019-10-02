package com.gaoxing.service;

import java.sql.SQLException;

import com.gaoxing.dao.AdminDao;
import com.gaoxing.domain.Admin;

public class AdminService {

	public Admin login(String username, String password) throws Exception {
		// 调用dao层到数据库中查询
		AdminDao adminDao = new AdminDao();
		Admin admin = adminDao.checkAdmin(username,password);
		if (admin != null) {
			return admin;
		}else {
			throw new Exception("用户名或密码错误");
		}
		
	}

}
