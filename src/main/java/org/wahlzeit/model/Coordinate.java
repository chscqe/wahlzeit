package org.wahlzeit.model;

public class Coordinate {

	private double latitude;
	private double longitude;
	
	public Coordinate(double lati, double longi) {
		if(Math.abs(lati) > 90.0 || Math.abs(longi) > 180.0) {
			throw new IllegalArgumentException();
		}
		latitude = lati;
		longitude = longi;
	}

	public Coordinate getDistance(Coordinate other) {
		if(other == null) {
			throw new IllegalArgumentException();
		}
		return new Coordinate(Math.abs(latitude - other.latitude), Math.abs(longitude - other.longitude));
	}
	
	public double getLatitudinalDistance(Coordinate other)	{
		return Math.abs(latitude - other.latitude);
	}
	
	public double getLongitudinalDistance(Coordinate other) {
		return Math.abs(longitude - other.longitude);
	}
}
