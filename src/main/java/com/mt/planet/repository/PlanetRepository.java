package com.mt.planet.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mt.planet.model.Planet;

@Repository
public interface PlanetRepository extends CrudRepository<Planet, Long> {

	public Planet findPlanetById(Long id); 
	public ArrayList<Planet> findAll();
	public void deletePlanetById(Long id);
	public void deleteAll();
}
