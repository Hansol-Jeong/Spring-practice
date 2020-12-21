package com.rubypaper.web.common;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class TimeCheckFilter implements Filter {

    public TimeCheckFilter() {
    	System.out.println("===> TimeCheckFilter 생성");
    }


	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//클라이언트가 요청한 서블릿 정보 추출
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		//		System.out.println("---[ 사전 처리 로직 ]");
		long startTime = System.currentTimeMillis();
		
		chain.doFilter(request, response);//제어권을 서블릿으로 넘김, 클라이언트가 호출한 서블릿을 실행시키는 순간.
		
//		System.out.println("---[ 사후 처리 로직 ]");
		long endTime = System.currentTimeMillis();
		System.out.println(path + "서블릿 수행에 소요된 시간: " + (endTime- startTime) + "(ms)초");
	}


	public void init(FilterConfig fConfig) throws ServletException {
	}

}
