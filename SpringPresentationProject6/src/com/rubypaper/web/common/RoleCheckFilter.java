package com.rubypaper.web.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rubypaper.biz.user.UserVO;

public class RoleCheckFilter implements Filter {


    public RoleCheckFilter() {        
    }

	public void init(FilterConfig fConfig) throws ServletException {		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String uri = req.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		
		if(path.equals("/updateBoard.do") || path.equals("/deleteBoard.do")) {
			HttpSession session = req.getSession();
			UserVO user = (UserVO) session.getAttribute("user");
			if(user != null && user.getRole().equals("ADMIN")) {
				chain.doFilter(request, response);
			} else {
				res.sendRedirect("login.jsp");
			}
		} else {
			chain.doFilter(request, response);
		}		
		
	}

	public void destroy() {		
	}
}
