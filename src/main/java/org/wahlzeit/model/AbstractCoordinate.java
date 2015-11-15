package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate {

	public abstract double getDistance(Coordinate other);
	
	public abstract boolean isEqual(Coordinate other);
}
