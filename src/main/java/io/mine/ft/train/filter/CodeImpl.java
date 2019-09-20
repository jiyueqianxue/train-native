package io.mine.ft.train.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


public class CodeImpl implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
			
				HttpServletRequest req = (HttpServletRequest)request;
				ServletContext ctx = req.getSession().getServletContext();
				String encoding = ctx.getInitParameter("encoding");
				
				request.setCharacterEncoding(encoding);
				response.setCharacterEncoding(encoding);
				response.setContentType("text/html;charset=utf-8");
				chain.doFilter(request, response);
		}	
	

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}



}
