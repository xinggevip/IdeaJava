package com.gaoxing.service;

import java.util.List;

import com.gaoxing.dao.CategoryDao;
import com.gaoxing.domain.Category;

public class CategoryService {

	public List<Category> findCategory() throws Exception {
		CategoryDao categoryDao = new CategoryDao();
		return categoryDao.getAllCategory();
		
	}

}
