package com.gaoxing.web;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestServlet")
public class TestServlet extends BaseServlet {
	
		/*
		if (action.equals("add")) {
			// 添加
			desPath = add(request,response);
		}else if (action.equals("del")) {
			// 删除
			desPath = del(request,response);
		}else if (action.equals("update")) {
			// 更新
			desPath = update(request,response);
		}
		*/

	public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("添加操作");
		return "add.jsp";
	}
	
	public String del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("删除操作");
		return "del.jsp";
	}
	
	public String update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("更新操作");
		return "update.jsp";
	}
}
