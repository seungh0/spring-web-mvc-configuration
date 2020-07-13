package me.will.demobootwebmvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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

}
