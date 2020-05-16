package io.mine.ft.train.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.mine.ft.train.entity.Interact;
import io.mine.ft.train.entity.User;
import io.mine.ft.train.service.InteractService;
import io.mine.ft.train.service.impl.InteractServiceImpl;

public class VagueQueryInteractAction extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获得登录数据
		InteractService isi = new InteractServiceImpl();
		User	user=(User)req.getSession(true).getAttribute("user");	
		String flagAnswer=req.getParameter("flagAnswer");
		String information=req.getParameter("information");
		String name=req.getParameter("name");
		RequestDispatcher rdp;
		//调用service层方法
		try {
			List<Interact> list=isi.QueryAllInteract(flagAnswer,information,name,user.getUserId());
			req.setAttribute("list", list);
			//跳转jsp显示
			rdp=req.getRequestDispatcher("/student/queryInteract.jsp");
			rdp.forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			req.setAttribute("exe", e.getMessage());
			rdp=req.getRequestDispatcher("/student/failPage.jsp");
			rdp.forward(req, resp);
		}
	}
}
