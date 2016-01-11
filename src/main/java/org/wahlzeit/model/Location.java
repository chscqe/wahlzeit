package org.wahlzeit.model;

import org.wahlzeit.services.DataObject;

import com.googlecode.objectify.annotation.Container;

public class Location extends DataObject{
	
	private String name;

	@Container
	public Coordinate coordinate;
	
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
