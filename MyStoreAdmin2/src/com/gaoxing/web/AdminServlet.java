package com.gaoxing.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gaoxing.domain.Admin;
import com.gaoxing.service.AdminService;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 接收用户名，密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + password);
		// 调用登录的业务
		AdminService adminService = new AdminService();
		try {
			Admin admin = adminService.login(username,password);
			// 1.登录成功把用户存到session
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin);
			// 2.跳转到后台首页，浏览器301重定向跳转
			response.sendRedirect(request.getContextPath()+"/admin/admin_index.jsp");
			
		} catch (Exception e) {
			if (e.getMessage().equals("用户名或密码错误")) {
				System.out.println("登录失败");
				// 跳转回登录页，回显错误信息
				request.setAttribute("err", e.getMessage());
				// 转发，服务器内部转发
				request.getRequestDispatcher("admin/admin_login.jsp").forward(request, response);
			}else {
				e.printStackTrace();
			}
		}
		
	}

}
