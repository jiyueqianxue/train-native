package io.mine.ft.train.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.mine.ft.train.entity.Interact;
import io.mine.ft.train.service.InteractService;
import io.mine.ft.train.service.impl.InteractServiceImpl;

public class QueryInteractDetailAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		InteractService isi = new InteractServiceImpl();
		Interact it = null;
		RequestDispatcher rdp;
		try {
			it = isi.QueryDetailById(new Integer(req.getParameter("interactId")));
			req.setAttribute("it", it);
			 rdp = req.getRequestDispatcher("/student/interactDetail.jsp");
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
