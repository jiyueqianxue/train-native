package io.mine.ft.train.action;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.mine.ft.train.entity.Accusation;
import io.mine.ft.train.entity.Interact;
import io.mine.ft.train.service.InteractService;
import io.mine.ft.train.service.impl.InteractServiceImpl;
import io.mine.ft.train.util.IDGenerator;

public class EstimateAccusationUpdateAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 1.评价
		InteractService isi = new InteractServiceImpl();
		Interact it = new Interact();
		String iId=req.getParameter("interactId");
		it.setInteractId(new Integer(iId));
		Accusation acc = new Accusation();
		String select = req.getParameter("select");
		try {
			if (select.equals("estimate")) {
				it.setEstimateContent(req.getParameter("content"));
				it.setFlagEstimate("y");
				it.setEstimateTime(new Date());
				isi.updateInteractService(it);
			} else if (select.equals("accusation")) {
				
				acc.setAccusationId(IDGenerator.getAccusationID());
				acc.setiId(new Integer(req.getParameter("interactId")));
				acc.setStudentAccusationContent(req.getParameter("content"));
				isi.AddAccusationService(acc);
				it.setFlagStudentAccusation("y");
				isi.updateInteractService(it);
			} else {
				it.setInteractDetail(req.getParameter("content"));
				isi.updateInteractService(it);
			}
			resp.sendRedirect(req.getContextPath() + "/student/queryInteractDetailAction?interactId="+iId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			req.setAttribute("exe", e.getMessage());
			RequestDispatcher rdp=req.getRequestDispatcher("/student/failPage.jsp");
			rdp.forward(req, resp);
		}
	}
}
