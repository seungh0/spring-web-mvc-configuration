package me.will.demobootwebmvc.config;

import me.will.demobootwebmvc.domain.Person;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component // 스프링 부트에서는 빈으로 등록만 되어있으면 따로 registry.addFormatter(new PersonFormatter()); 과정 필요 없음!
public class PersonFormatter implements Formatter<Person> {

	/**
	 * 문자 -> 객체
	 */
	@Override
	public Person parse(String text, Locale locale) throws ParseException {
		return new Person(text);
	}

	/**
	 * 객체 -> 문자
	 */
	@Override
	public String print(Person object, Locale locale) {
		return null;
	}

}
