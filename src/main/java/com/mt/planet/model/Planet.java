package com.mt.planet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Planet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;
	private String nameOfPlanet;
	private Integer numOfMoons;
	
	public Planet() {};
	
	public Planet(String nameOfPlanet, Integer numOfMoons) {
		super();
		this.nameOfPlanet = nameOfPlanet;
		this.numOfMoons = numOfMoons;
	}
	public Long getId() {
		return id;
	}
	public String getNameOfPlanet() {
		return nameOfPlanet;
	}

	public void setNameOfPlanet(String nameOfPlanet) {
		this.nameOfPlanet = nameOfPlanet;
	}

	public Integer getNumOfMoons() {
		return numOfMoons;
	}

	public void setNumOfMoons(Integer numOfMoons) {
		this.numOfMoons = numOfMoons;
	}

	@Override
	public String toString() {
		return "Planet [id=" + id + ", nameOfPlanet=" + nameOfPlanet + ", numOfMoons=" + numOfMoons + "]";
	}

}
