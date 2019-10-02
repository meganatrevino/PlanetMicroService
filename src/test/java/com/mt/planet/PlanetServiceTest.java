package com.mt.planet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import com.mt.planet.model.Planet;
import com.mt.planet.repository.PlanetRepository;
import com.mt.planet.service.PlanetServiceImpl;
import com.mt.planet.service.PlanetServiceInt;

@RunWith(SpringRunner.class)
public class PlanetServiceTest {
	
	@Configuration
	static class ServiceConfiguration{
		@Bean
		public PlanetServiceInt configuration() {
			return new PlanetServiceImpl();
		}
	}
	
	@Autowired
	PlanetServiceInt planetService;
	
	@MockBean
	PlanetRepository planetRepository; 
	
	private static Planet mercury;
	private static ArrayList<Planet> planetList;
	
	@Before
	public void setUp() {
		mercury = new Planet("Murcury", 0);
		planetList = new ArrayList<>();
		planetList.add(mercury);
	}
	
	@Test
	public void givenPlanetId_returnPlanet() {
		Mockito.when(planetRepository.findPlanetById(1L)).thenReturn(mercury);
		Planet found = planetService.findPlanetByUsingId(1L);
		assertThat(mercury).isEqualToComparingFieldByField(found);
	}
	
	@Test
	public void ifFindAll_returnAllStudents() {
		Mockito.when(planetRepository.findAll()).thenReturn(planetList);
		ArrayList<Planet> found = planetService.getAll();
		assertEquals(planetList, found);
	}

}
