package com.gaoxing.web;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		String desPath = null;
		// 获取当前对象的字节码
		Class clazz = this.getClass();
		try {
			Method method = clazz.getMethod(action, HttpServletRequest.class,HttpServletResponse.class);
			// 判断有没有这个方法
			// 如果有就调用
			if (method != null) {
				desPath = (String)method.invoke(this, request, response);
				// 转发
				request.getRequestDispatcher(desPath).forward(request, response);
			}else {
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
