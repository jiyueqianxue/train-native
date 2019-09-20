package io.mine.ft.train.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.mine.ft.train.entity.Interact;
import io.mine.ft.train.entity.User;
import io.mine.ft.train.service.InteractService;
import io.mine.ft.train.service.impl.InteractServiceImpl;
import io.mine.ft.train.util.IDGenerator;

public class CreateInteractAction extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		InteractService isi = new InteractServiceImpl();
		User user=(User)req.getSession(true).getAttribute("user");
		
		try {
			Interact it=new Interact(IDGenerator.getInteractID(),req.getParameter("title"),req.getParameter("content"),user.getDepartment(),user.getRealname(),
					req.getParameter("teacherName"),"n",null,null,null,
					2,1,2.0,null,null,
					null,req.getParameter("teacherDepartment"),"n",null);
			isi.addInteractService(it);
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
