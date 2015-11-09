package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Container;

public class Location {
	
	private String name;

	@Container
	public SphericCoordinate coordinate;
	
	public Location() {
		
	}
	
	public Location(String name) {
		this.name = name;
	}
	
	public Location(String name, SphericCoordinate coordinate) {
		this.name = name;
		this.coordinate = coordinate;
	}
	
	public String getName() {
		return name;
	}

}
