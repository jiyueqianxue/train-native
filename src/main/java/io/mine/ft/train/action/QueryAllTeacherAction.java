package io.mine.ft.train.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.mine.ft.train.entity.User;
import io.mine.ft.train.service.InteractService;
import io.mine.ft.train.service.impl.InteractServiceImpl;

public class QueryAllTeacherAction extends HttpServlet{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Override
protected void service(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	InteractService isi = new InteractServiceImpl();
	List<User> list=null;
	RequestDispatcher rdp;
	try {
		list=isi.QueryAllTeacherService();
		req.setAttribute("list", list);
		rdp=req.getRequestDispatcher("/student/queryTeacher.jsp");
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
