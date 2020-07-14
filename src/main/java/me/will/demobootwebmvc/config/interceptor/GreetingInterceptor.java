package me.will.demobootwebmvc.config.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Handler Interceptor
 * Handler Mapping에 설정할 수 있는 인터셉터.
 * 핸들러를 실행하기 전, 완료 시점에 부가 작업을 하고 싶은 경우 사용 가능.
 * (로깅, 인증 체크, Locale 변경 등)
 *
 * preHandle
 * 요청 처리
 * postHandler
 * 뷰 렌더링
 * afterCompletion
 *
 * 서블릿 필터와의 차이?
 * - 서블릿 보다 구체적인 처리 가능
 * - 서블릿은 보다 일반적인 용도의 기능을 구현하는데 사용하는게 좋다.
 */

public class GreetingInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("preHandle 1");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle 1");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		System.out.println("afterCompletion 1");
	}

}
