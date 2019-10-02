package com.mt.planet.service;

import java.util.ArrayList;

import com.mt.planet.model.Planet;

public interface PlanetServiceInt {

	public void savePlanet(Planet planet);

	Planet findPlanetByUsingId(Long id);

	ArrayList<Planet> getAll();

	public void updatePlanet(Long id, Planet planetChanges);

	void deletePlanetUsingId(Long id);

	void deleteEveryPlanet();

}
