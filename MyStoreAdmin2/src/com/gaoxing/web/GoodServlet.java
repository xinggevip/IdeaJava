package com.gaoxing.web;

import com.gaoxing.domain.Category;
import com.gaoxing.domain.Goods;
import com.gaoxing.domain.PageBean;
import com.gaoxing.service.CategoryService;
import com.gaoxing.service.GoodsService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@WebServlet("/GoodServlet")
public class GoodServlet extends BaseServlet {

	public String getListGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GoodsService goodsService = new GoodsService();
		try {
			List<Goods> allGoods = goodsService.getAllGoods();
			// ��Ʒ���Ϸ�ת
			Collections.reverse(allGoods);
			System.out.println(allGoods);
			// request.setAttribute("allGoods", allGoods);
			PageBean pageBean = new PageBean();
			pageBean.setGoodsList(allGoods);
			pageBean.setTotalCount(10);
			pageBean.setTotalPage(10);
			pageBean.setCurrentPage(1);
			request.setAttribute("pageBean",pageBean);
			// ��ǰҳ��Ʒ
			// ��ǰ����һҳ
			// ������ҳ
			// �����ټ�¼
			return "admin/main.jsp";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String getPageData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.��ȡ��ǰҳ��
		String currentPage = request.getParameter("currentPage");
		// 2.��ҳ���ҵ���
		GoodsService goodsService = new GoodsService();
		PageBean pageBean = null;
		try {
			pageBean = goodsService.getPageBean(currentPage);
			System.out.println(pageBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 3.��pageBeanд������
		request.setAttribute("pageBean",pageBean);
		// 4.ת��
		return "admin/main.jsp";
	}


	public String delGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ����idɾ����Ʒ
		String id = request.getParameter("id");
		System.out.println(id);
		GoodsService goodsService = new GoodsService();
		try {
			goodsService.deleteGoods(id);
			return "GoodServlet?action=getPageData&currentPage=1";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String addGoodsUi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Ϊ������Ʒҳ��׼����������
		// 1.ȡ�����з���
		// 2.�ѷ��������
		// 3.ת��add.jsp
		System.out.println("GoodsAddUIServlet---");
		// 1.ȡ�����з���
		CategoryService categoryService = new CategoryService();
		List<Category> allCategory = null;
		try {
			allCategory = categoryService.findCategory();
			// 2.�ѷ��������
			request.setAttribute("allCategory", allCategory);
			System.out.println(allCategory);
			// 3.ת��add.jsp
			return "admin/add.jsp";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String addGood(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Map<String, String[]> parameterMap = request.getParameterMap();
		System.out.println("GoodsAddServlet----------------");
		Goods goods = new Goods();
		try {
			BeanUtils.populate(goods, parameterMap);
			System.out.println(goods);
			GoodsService goodsService = new GoodsService();
			goodsService.addGoods(goods);
			return "GoodServlet?action=getPageData&currentPage=1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String editGoodsUi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ����id������id�޸���Ʒ
		String id = request.getParameter("id");
		System.out.println("GoodsEditUIServlet======" + id);
		
		// ����Ʒ��Ϣ
		GoodsService goodsService = new GoodsService();
		Goods goods = new Goods();
		
		// �������Ϣ
		CategoryService categoryService = new CategoryService();
		List<Category> allCategory = null;

	
		try {
			// 1.��ȡ��Ʒ��Ϣ���浽��
			goods = goodsService.getGoodsWidthId(id);
			request.setAttribute("goods", goods);
			System.out.println(goods);
			
			// 2.��ȡ������Ϣ���浽��
			allCategory = categoryService.findCategory();
			request.setAttribute("allCategory", allCategory);
			System.out.println(allCategory);
			
			// 3.�������ڲ�ת��
			return "admin/edit.jsp";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public String editGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 1.��ȡ���в���
		Map<String, String[]> parameterMap = request.getParameterMap();
		// 2.�Ѳ�����װ�ɶ���
		Goods goods = new Goods();
		try {
			BeanUtils.populate(goods, parameterMap);
			// 3.����id��������
			System.out.println(goods);
			// ���÷����
			GoodsService goodsService = new GoodsService();
			goodsService.updateGoods(goods);
			// 4.ת��
			return "GoodServlet?action=getPageData&currentPage=1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
}