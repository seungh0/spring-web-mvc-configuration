package me.will.demobootwebmvc.config;

import me.will.demobootwebmvc.config.interceptor.AnotherInterceptor;
import me.will.demobootwebmvc.config.interceptor.GreetingInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	/**
	 * 생성한 Formatter을 등록하는 방법~
	 * 단 스프링 부트에서는 Formatter가 빈으로 등록되어 있으면 이 과정 생략가능.!
	 */
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(new PersonFormatter());
	}

	/**
	 * 인터셉터 등록
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new GreetingInterceptor());
		registry.addInterceptor(new AnotherInterceptor())
				.addPathPatterns("/hello/*") // 특정 Path에만 적용하고 싶을 경우
				.order(1); // 우선순위 커스텀하고 싶을때 (작을수록 높음)
	}
	// preHandle1 -> preHandle2 -> postHandle2 -> postHandle1 -> afterCompletion2 -> afterCompletion1


	/**
	 * 리소스 핸들러 등록
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/mobile/**")
				.addResourceLocations("classpath:/mobile/")
				.setCacheControl(CacheControl.maxAge(10, TimeUnit.MINUTES)); // 캐싱 전략 (10분 동안 캐싱)
	}

}
