package org.wahlzeit.model;

public class Coordinate {

	private double latitude;
	private double longitude;
	
	public Coordinate(double lati, double longi) {
		latitude = lati;
		longitude = longi;
	}

	public Coordinate getDistance(Coordinate other) {
		return null;
	}
	
	public double getLatitudinalDistance(Coordinate other)	{
		return 0.0;
	}
	
	public double getLongitudinalDistance(Coordinate other) {
		return 0.0;
	}
}
