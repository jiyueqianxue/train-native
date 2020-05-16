package io.mine.ft.train.action;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import io.mine.ft.train.entity.User;
import io.mine.ft.train.service.UserService;
import io.mine.ft.train.service.impl.UserServiceImpl;

public class LoginAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			// 1.获取客户端数据
			String name = request.getParameter("username");
			String psw = request.getParameter("password");
			// 2.调用业务方法。实现功能

			UserService userService = new UserServiceImpl();
			User user = userService.queryOneUserByNameAndPass(name, psw);

			HttpSession session = request.getSession(true);
			session.setAttribute("user", user);
			// 选择视图跳转
			if ("student".equals(user.getRole())) {
				response.sendRedirect(request.getContextPath()
						+ "/student/queryAllInteractAction");
			}
			if ("teacher".equals(user.getRole())) {
				 response.sendRedirect(request.getContextPath()+"/teacher/queryInteract.jsp");
				System.out.println("这是老师登录位置");
			}
		} catch (Exception e) {
			String message = e.getMessage();
			String mes = URLEncoder.encode(message, "UTF-8");
			response.sendRedirect(request.getContextPath()
					+ "/login.jsp?message=" + mes);
		}
	}
}
