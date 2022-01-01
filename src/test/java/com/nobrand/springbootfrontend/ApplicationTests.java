package com.nobrand.springbootfrontend;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@RunWith(SpringRunner.class)
@WebMvcTest
class ApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	void contextLoads() {
	}

	@Test
	public void hello() throws Exception {
		String hello = "hello";

		mvc.perform(MockMvcRequestBuilders.get("/hello"))
		   .andExpect(MockMvcResultMatchers.status().isOk())
		   .andExpect(MockMvcResultMatchers.content().string(hello));
	}

	@Test
	public void helloDto() throws Exception {
		String name = "hello";
		int amount = 100;

		mvc.perform(MockMvcRequestBuilders.get("/hello/dto")
				                          .param("name", name)
				                          .param("amount", String.valueOf(amount)))
		   .andExpect(MockMvcResultMatchers.status().isOk())
		   .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is(name)))
		   .andExpect(MockMvcResultMatchers.jsonPath("$.amount", Matchers.is(amount)));
	}

}
