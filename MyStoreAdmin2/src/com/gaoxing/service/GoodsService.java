package com.gaoxing.service;

import java.sql.SQLException;
import java.util.List;

import com.gaoxing.dao.GoodsDao;
import com.gaoxing.domain.Goods;

public class GoodsService {
	private static GoodsDao goodsDao = null;
	static {
		goodsDao = new GoodsDao();
	}

	public List<Goods> getAllGoods() throws SQLException {
		List<Goods> allGoods = goodsDao.getAllGoods();
		return allGoods;
	}

	public void deleteGoods(String id) throws SQLException {
		goodsDao.delGoods(Integer.parseInt(id));
	}

	public void addGoods(Goods goods) throws SQLException {
		goodsDao.addGoods(goods);
		
	}

	public Goods getGoodsWidthId(String id) throws NumberFormatException, SQLException {
		return goodsDao.getGoodsWidthId(Integer.valueOf(id));
		
	}

	public void updateGoods(Goods goods) throws SQLException {
		goodsDao.updateGoods(goods);
	}

}
