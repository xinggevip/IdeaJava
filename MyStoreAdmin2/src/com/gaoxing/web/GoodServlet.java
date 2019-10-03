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
			// 商品集合反转
			Collections.reverse(allGoods);
			System.out.println(allGoods);
			// request.setAttribute("allGoods", allGoods);
			PageBean pageBean = new PageBean();
			pageBean.setGoodsList(allGoods);
			pageBean.setTotalCount(10);
			pageBean.setTotalPage(10);
			pageBean.setCurrentPage(1);
			request.setAttribute("pageBean",pageBean);
			// 当前页商品
			// 当前是那一页
			// 共多少页
			// 共多少纪录
			return "admin/main.jsp";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String getPageData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.获取当前页码
		String currentPage = request.getParameter("currentPage");
		// 2.把页码给业务层
		GoodsService goodsService = new GoodsService();
		PageBean pageBean = null;
		try {
			pageBean = goodsService.getPageBean(currentPage);
			System.out.println(pageBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 3.把pageBean写到域当中
		request.setAttribute("pageBean",pageBean);
		// 4.转发
		return "admin/main.jsp";
	}


	public String delGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 根据id删除商品
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
		// 为添加商品页面准备分类数据
		// 1.取出所有分类
		// 2.把分类存域当中
		// 3.转发add.jsp
		System.out.println("GoodsAddUIServlet---");
		// 1.取出所有分类
		CategoryService categoryService = new CategoryService();
		List<Category> allCategory = null;
		try {
			allCategory = categoryService.findCategory();
			// 2.把分类存域当中
			request.setAttribute("allCategory", allCategory);
			System.out.println(allCategory);
			// 3.转发add.jsp
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
		// 接收id，根据id修改商品
		String id = request.getParameter("id");
		System.out.println("GoodsEditUIServlet======" + id);
		
		// 存商品信息
		GoodsService goodsService = new GoodsService();
		Goods goods = new Goods();
		
		// 存分类信息
		CategoryService categoryService = new CategoryService();
		List<Category> allCategory = null;

	
		try {
			// 1.获取商品信息并存到域
			goods = goodsService.getGoodsWidthId(id);
			request.setAttribute("goods", goods);
			System.out.println(goods);
			
			// 2.获取分类信息并存到域
			allCategory = categoryService.findCategory();
			request.setAttribute("allCategory", allCategory);
			System.out.println(allCategory);
			
			// 3.服务器内部转发
			return "admin/edit.jsp";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public String editGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 1.获取所有参数
		Map<String, String[]> parameterMap = request.getParameterMap();
		// 2.把参数封装成对象
		Goods goods = new Goods();
		try {
			BeanUtils.populate(goods, parameterMap);
			// 3.根据id更新数据
			System.out.println(goods);
			// 调用服务层
			GoodsService goodsService = new GoodsService();
			goodsService.updateGoods(goods);
			// 4.转发
			return "GoodServlet?action=getPageData&currentPage=1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
}
