package com.nobrand.springbootfrontend;

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

}
