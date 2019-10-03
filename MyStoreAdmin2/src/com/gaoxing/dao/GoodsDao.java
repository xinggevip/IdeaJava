package com.gaoxing.dao;

import com.gaoxing.domain.Goods;
import com.gaoxing.jdbc.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class GoodsDao {
	private static QueryRunner qr = null;
	static {
		qr = JdbcUtil.getQueryRunner();
	}
	
	// 1.��ѯ������Ʒ
	public List<Goods> getAllGoods() throws SQLException{
		
		String sql = "select * from goods";
		List<Goods> allGoods = null;
		allGoods = qr.query(sql, new BeanListHandler<Goods>(Goods.class));
		return allGoods;
	}
	
	// 2.�����Ʒ�����ݿ�
	public void addGoods(Goods goods) throws SQLException {
		String sql = "insert into goods(name,price,image,gdesc,is_hot,cid) value(?,?,?,?,?,?)";
		qr.update(sql, goods.getName(),goods.getPrice(),goods.getImage(),goods.getGdesc(),goods.getIs_hot(),goods.getCid());
	}
	
	// 3.����id�����ݿ⵱��ɾ��һ����Ʒ
	public void delGoods(int id) throws SQLException {
		String sql = "delete from goods where id=?";
		qr.update(sql,id);
	}
	
	// 4.������Ʒ
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


	public Long getCount() throws SQLException {
		String sql = "select count(*) from goods";
		Long count = (Long)qr.query(sql, new ScalarHandler());
		return count;
	}

	public List<Goods> getPageData(Integer index, Integer pageCount) throws SQLException {
		String sql = "select * from (select * from goods ORDER BY id DESC) goods limit ?,?";
		List<Goods> list = null;
		list = qr.query(sql,new BeanListHandler<Goods>(Goods.class),index,pageCount);
		//Collections.reverse(list); // ���Ϸ�ת
		return list;
	}
}
