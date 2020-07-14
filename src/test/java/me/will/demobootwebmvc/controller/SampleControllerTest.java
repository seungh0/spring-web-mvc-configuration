package me.will.demobootwebmvc.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import me.will.demobootwebmvc.domain.Man;
import me.will.demobootwebmvc.domain.ManRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class SampleControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ManRepository manRepository;

	@Autowired
	private ObjectMapper objectMapper;

	@AfterEach
	void cleanUp() {
		manRepository.deleteAll();
	}

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

	@Test
	void helloId() throws Exception {
		Man man = new Man("will");
		manRepository.save(man);

		this.mockMvc.perform(get("/hello")
				.param("id", man.getId().toString()))
				.andDo(print())
				.andExpect(content().string("hello will"));
	}

	@Test
	void helloStatic() throws Exception {
		this.mockMvc.perform(get("/index.html"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(Matchers.containsString("Hello index")));
	}

	@Test
	void helloMobileStatic() throws Exception {
		this.mockMvc.perform(get("/mobile/index.html"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(Matchers.containsString("Hello Mobile")))
				.andExpect(header().exists(HttpHeaders.CACHE_CONTROL));
	}

	@Test
	void messageConverter() throws Exception {
		this.mockMvc.perform(get("/message")
				.content("hello"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string("hello"));
	}

	@Test
	void jsonMessage() throws Exception {
		Man man = new Man("will");
		manRepository.save(man);

		String jsonString = objectMapper.writeValueAsString(man);

		this.mockMvc.perform(get("/jsonMessage")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE)
				.content(jsonString))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json(jsonString));
	}

}