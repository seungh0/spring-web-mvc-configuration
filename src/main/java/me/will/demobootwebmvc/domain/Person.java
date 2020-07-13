package me.will.demobootwebmvc.domain;

import lombok.Getter;

@Getter
public class Person {

	private String name;

	public Person(String name) {
		this.name = name;
	}

}
