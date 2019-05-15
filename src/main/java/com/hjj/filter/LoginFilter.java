package com.hjj.filter;

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

public class LoginFilter implements Filter {
	String paramValue = null;
	public void init(FilterConfig fConfig) throws ServletException {
	}


    public static boolean isContains(String container, String[] regx) {
        boolean result = false;

        for (int i = 0; i < regx.length; i++) {
            if (container.indexOf(regx[i]) != -1) {
                return true;
            }
        }
        return result;
    }
    
    
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		String uri = req.getRequestURI();
		String[] loginList = {""};

        if (isContains(uri, loginList)) {
            chain.doFilter(request, response);
            return;
        }
		if(session.getAttribute("user")==null){
			res.sendRedirect("/Alice/LoginView");
		}
		else{
         //request -> filter1 -> filter2 ->filter3 -> .... -> request resource.
			chain.doFilter(request, response);
		}
	}
	
	public void destroy() {
	}

}
