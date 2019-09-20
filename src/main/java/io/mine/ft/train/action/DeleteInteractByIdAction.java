package io.mine.ft.train.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.mine.ft.train.service.InteractService;
import io.mine.ft.train.service.impl.InteractServiceImpl;

public class DeleteInteractByIdAction extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			InteractService isi = new InteractServiceImpl();
			try {
				isi.deleteInteractService(new Integer(req.getParameter("interactId")));
				resp.sendRedirect(req.getContextPath()+"/student/queryAllInteractAction");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				req.setAttribute("exe", e.getMessage());
				RequestDispatcher rdp=req.getRequestDispatcher("/student/failPage.jsp");
				rdp.forward(req, resp);
			}
	}
}
