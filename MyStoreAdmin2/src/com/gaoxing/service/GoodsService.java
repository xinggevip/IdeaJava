package com.gaoxing.service;

import com.gaoxing.dao.GoodsDao;
import com.gaoxing.domain.Goods;
import com.gaoxing.domain.PageBean;

import java.sql.SQLException;
import java.util.List;

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


	public PageBean getPageBean(String currentPage) throws SQLException {
		PageBean pageBean = new PageBean();
		// ���õ�ǰҳ
		pageBean.setCurrentPage(Integer.valueOf(currentPage));
		// �����ж�������¼
		Long count = goodsDao.getCount();
		pageBean.setTotalCount(count.intValue());
		// ���õ�ǰҳ�Ķ��󼯺�

		// һҳչʾ����������
		Integer pageCount = 5;
		// �����չʾ����ҳ
		double totaPage = Math.ceil(1.0 * count / pageCount);
		pageBean.setTotalPage((int)totaPage);

		// ���㵱ǰҳ�ĽǱ�
		Integer index = (Integer.valueOf(currentPage)-1) * pageCount;
		// sql��ʼ��
		List<Goods> list =goodsDao.getPageData(index,pageCount);
		pageBean.setGoodsList(list);
		return pageBean;
	}
}
