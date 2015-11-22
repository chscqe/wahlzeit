package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate {

	public abstract double getDistance(Coordinate other);
	
	public abstract boolean isEqual(Coordinate other);
	
	
	protected void assertNotNull(Object o) {
		assert (o != null);		
	}
	
	protected void assertCoordinatesLegal(double x, double y, double z) {
		assert (x != Double.NaN);
		assert (y != Double.NaN);
		assert (z != Double.NaN);
	}
}
