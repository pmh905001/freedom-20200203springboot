package com.pmh.freedom.springboot.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component("sessionInterceptor")
public class SessionInterceptor extends HandlerInterceptorAdapter {
	
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		return true;
		
//        System.out.println("SessionInterceptor preHandle");
//        HttpSession session = request.getSession(false);
//        if (session != null && session.getAttribute("user") != null) {
//            return true;
//        } else {
//            PrintWriter printWriter = response.getWriter();
//            printWriter.write("{code: 501, message:\"not login!\"}");
//            return false;
//        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("SessionInterceptor postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("SessionInterceptor afterCompletion");
    }

}
