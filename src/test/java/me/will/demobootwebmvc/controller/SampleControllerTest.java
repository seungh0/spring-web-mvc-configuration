package me.will.demobootwebmvc.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@WebMvcTest
class SampleControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void hello() throws Exception {
		this.mockMvc.perform(get("/hello/will"))
				.andDo(print())
				.andExpect(content().string("hello will"));
	}

	@Test
	void bye() throws Exception {
		this.mockMvc.perform(get("/bye")
				.param("name", "will"))
				.andDo(print())
				.andExpect(content().string("bye will"));
	}

}