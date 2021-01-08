package com.ltfs.main;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
@WebAppConfiguration
public class IntegrationAppTests {
	
	@Autowired
	WebApplicationContext webApplicationContext;

	@Test
	public void productsAgreExposureTest() throws Exception {
		String uri = "/productsAgreExposure";
		String inputJson = "{\"lan\": \"T123\"}";
		MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "{\"error\":\"Data not found in Database\",\"status\":1001}");
	}

}