package com.directa24.main.challenge.controllers;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.directa24.main.challenge.services.IDirectaService;


@SpringBootTest
@AutoConfigureMockMvc
public class DirectorsControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private IDirectaService service;
	
	@Test
	public void getDirectors() throws Exception {
		this.initTest();
		mvc.perform(MockMvcRequestBuilders.get("/directors/1/1").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("{\"status\":\"OK\",\"data\":[\"Prueba\"]}")));
	}
	
	private void initTest() {
		List<String> resp = new ArrayList<String>();
		resp.add("Prueba");
		when(service.getDirectors("1", "1")).thenReturn(resp);		
	}
	
}
