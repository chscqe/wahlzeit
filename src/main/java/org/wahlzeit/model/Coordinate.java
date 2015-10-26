package org.wahlzeit.model;

public class Coordinate {

	private double latitude;
	private double longitude;
	
	public Coordinate(double lati, double longi) {
		latitude = lati;
		longitude = longi;
	}

	public Coordinate getDistance(Coordinate other) {
		return new Coordinate(Math.abs(latitude - other.latitude), Math.abs(longitude - other.longitude));
	}
	
	public double getLatitudinalDistance(Coordinate other)	{
		return Math.abs(latitude - other.latitude) * 6371.0;
	}
	
	public double getLongitudinalDistance(Coordinate other) {
		return Math.abs(longitude - other.longitude) * 6371.0;
	}
}
