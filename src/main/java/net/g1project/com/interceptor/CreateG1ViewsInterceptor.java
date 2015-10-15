package net.g1project.com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CreateG1ViewsInterceptor extends HandlerInterceptorAdapter {


	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		System.out.println("View Name : "+modelAndView.getViewName());
		super.postHandle(request, response, handler, modelAndView);
	}	
}
