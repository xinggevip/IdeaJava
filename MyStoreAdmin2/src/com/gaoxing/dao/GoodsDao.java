package com.gaoxing.dao;

import com.gaoxing.domain.Goods;
import com.gaoxing.jdbc.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class GoodsDao {
	private static QueryRunner qr = null;
	static {
		qr = JdbcUtil.getQueryRunner();
	}
	
	// 1.查询所有商品
	public List<Goods> getAllGoods() throws SQLException{
		
		String sql = "select * from goods";
		List<Goods> allGoods = null;
		allGoods = qr.query(sql, new BeanListHandler<Goods>(Goods.class));
		return allGoods;
	}
	
	// 2.添加商品到数据库
	public void addGoods(Goods goods) throws SQLException {
		String sql = "insert into goods(name,price,image,gdesc,is_hot,cid) value(?,?,?,?,?,?)";
		qr.update(sql, goods.getName(),goods.getPrice(),goods.getImage(),goods.getGdesc(),goods.getIs_hot(),goods.getCid());
	}
	
	// 3.根据id从数据库当中删除一个商品
	public void delGoods(int id) throws SQLException {
		String sql = "delete from goods where id=?";
		qr.update(sql,id);
	}
	
	// 4.更新商品
	public void updateGoods(Goods goods) throws SQLException {
		String sql = "update goods set name=?,price=?,image=?,gdesc=?,is_hot=?,cid=? where id=?";
		qr.update(sql,goods.getName(),goods.getPrice(),goods.getImage(),goods.getGdesc(),goods.getIs_hot(),goods.getCid(),goods.getId());
	}

	public Goods getGoodsWidthId(Integer id) throws SQLException {
		String sql = "select * from goods where id=?";
		Goods goods = null;
		goods = qr.query(sql, new BeanHandler<Goods>(Goods.class),id);
		return goods;
		
	}
	

}
