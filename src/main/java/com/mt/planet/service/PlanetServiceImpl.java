package com.mt.planet.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.planet.model.Planet;
import com.mt.planet.repository.PlanetRepository;

@Service 
public class PlanetServiceImpl implements PlanetServiceInt {
	
	@Autowired
	public PlanetRepository planetRepository;
	
	@Override
	public void savePlanet(Planet planet) {
		planetRepository.save(planet); 
	}
	
	@Override
	public Planet findPlanetByUsingId(Long id) {
		return planetRepository.findPlanetById(id);
	}
	
	@Override
	public ArrayList<Planet> getAll(){
		return planetRepository.findAll();
	}
	
	@Override
	public void updatePlanet(Long id, Planet planetChanges) {
		String nameOfPlanet = planetChanges.getNameOfPlanet();
		Integer numOfMoons = planetChanges.getNumOfMoons();
		
		Planet currentPlanet = planetRepository.findPlanetById(id);
		currentPlanet.setNameOfPlanet(nameOfPlanet);
		currentPlanet.setNumOfMoons(numOfMoons);
		planetRepository.save(currentPlanet);

	}
	
	@Override
	public void deletePlanetUsingId(Long id) {
		planetRepository.deletePlanetById(id);
	}
	
	@Override
	public void deleteEveryPlanet() {
		planetRepository.deleteAll();
	}

}
