package me.will.demobootwebmvc.controller;

import me.will.demobootwebmvc.domain.Man;
import me.will.demobootwebmvc.domain.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

	/**
	 * name에 들어오는 문자열을 Person으로 변환하고 싶다 => Formatter
	 */

	@GetMapping("/hello/{name}")
	public String hello(@PathVariable("name") Person person) {
		return "hello " + person.getName();
	}

	@GetMapping("/bye")
	public String bye(@RequestParam("name") Person person) {
		return "bye " + person.getName();
	}

	@GetMapping("/hello")
	public String helloId(@RequestParam("id") Man man) {
		return "hello " + man.getName();
	}

	@GetMapping("/message")
	public String message(@RequestBody String body) {
		return body;
	}

	@GetMapping("/jsonMessage")
	public Man jsonMessage(@RequestBody Man man) { //원래는 Dto로 변환 해야함 ㅠ.
		return man;
	}

}