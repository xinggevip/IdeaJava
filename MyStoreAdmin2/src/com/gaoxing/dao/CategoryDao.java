package com.gaoxing.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.gaoxing.domain.Category;
import com.gaoxing.jdbc.util.JdbcUtil;

public class CategoryDao {
	private static QueryRunner qr = null;
	static {
		qr = JdbcUtil.getQueryRunner();
	}
	public List<Category> getAllCategory() throws Exception {
		String sql = "select * from category";
		List<Category> allCategory = qr.query(sql, new BeanListHandler<Category>(Category.class));
		return allCategory;
	}
	
	//

}
