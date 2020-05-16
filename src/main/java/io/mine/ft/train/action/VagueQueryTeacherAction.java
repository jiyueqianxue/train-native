package io.mine.ft.train.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.mine.ft.train.entity.User;
import io.mine.ft.train.service.InteractService;
import io.mine.ft.train.service.impl.InteractServiceImpl;

public class VagueQueryTeacherAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		InteractService isi = new InteractServiceImpl();
	
		List<User> list = isi.QueryAllTeacherService();
		String choice = req.getParameter("choice");
		String str = req.getParameter("name");
		List<User> nlist=new ArrayList<User>();
		try {
			if (choice.equals("department")) {
				for (User user : list) {
					boolean bl = user.getDepartment().contains(str);
					System.out.println(bl);
					if (bl==true) {
						nlist.add(user);
					}
				}
			}
			if (choice.equals("teacher")) {
				for (User user : list) {
					boolean bl = user.getRealname().contains(str);
			
					if (bl == true) {
						nlist.add(user);
					}
				}
			}
			req.setAttribute("list", nlist);
			RequestDispatcher rdp = req
					.getRequestDispatcher("/student/queryTeacher.jsp");
			rdp.forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			req.setAttribute("exe", e.getMessage());
			RequestDispatcher rdp = req
					.getRequestDispatcher("/student/failPage.jsp");
			rdp.forward(req, resp);
		}
	}
}