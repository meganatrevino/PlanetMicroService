package com.mt.planet.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mt.planet.model.Planet;
import com.mt.planet.service.PlanetServiceImpl;
//CRUD
@RestController
public class PlanetController {
	
	@Autowired
	public PlanetServiceImpl planetServiceImpl; 

	@PostMapping("/planet/create")
	public String save(Planet planet) {
		planetServiceImpl.savePlanet(planet);
		return "Created Successfully.";
		}
	
	@GetMapping("/planet/find/{id}")
	public Planet findById(@PathVariable Long id) {
		return planetServiceImpl.findPlanetByUsingId(id);
		}
	
	@GetMapping("/planets")
	public ArrayList<Planet> getAllPlanets(){
		return planetServiceImpl.getAll();
		}
	
	@PutMapping("/planet/update/{id}")
	public String updatePlanet(@PathVariable Long id, Planet planet) {
		planetServiceImpl.updatePlanet(id, planet);
		return "Updated Successfully.";
		}
	
	@DeleteMapping("/planet/delete/{id}")
	public String deletePlanet(@PathVariable Long id) {
		planetServiceImpl.deletePlanetUsingId(id);
		return "Deleted Successfully.";
		}
	
	@DeleteMapping("/planet/deleteAll/{id}")
	public void deleteAllPlanets() {
		planetServiceImpl.deleteEveryPlanet();
		}
	}
