package com.mt.planet;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.RequestMatcher;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.mt.planet.model.Planet;
import com.mt.planet.repository.PlanetRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment = WebEnvironment.MOCK,
		classes = PlanetApplication.class
	)

@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")

public class PlanetApplicationIntegrationTest {

	@Autowired
	private PlanetRepository planetRepository;
	
	@Autowired
	private MockMvc mvc;
	
	private Planet mercury;
	
	@Before
	public void setUp() {
		mercury = new Planet("Mercury", 0);
		planetRepository.save(mercury);
	}
	
	@After 
	public void tearDown() {
		planetRepository.delete(mercury);
	}
	
	@Test
	public void givenPlanetId_getPlanet_returnsPlanet() throws Exception{
		Long planetId = mercury.getId();
		
		mvc.perform(get("/planet/" + planetId).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$", hasSize(3)))
		.andExpect(jsonPath("$.name", is("Mercury")));
	}

}
