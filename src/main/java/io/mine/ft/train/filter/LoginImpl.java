package io.mine.ft.train.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.mine.ft.train.entity.User;

public class LoginImpl implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
	HttpServletRequest req=(HttpServletRequest)request;
	HttpServletResponse resp=(HttpServletResponse)response;
	User user =(User)req.getSession().getAttribute("user");
	if(user==null){
		resp.sendRedirect(req.getContextPath()+"/login.jsp");
		return;
	}
	chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
