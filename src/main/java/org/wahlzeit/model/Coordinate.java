package org.wahlzeit.model;

public class Coordinate {

	private double latitude;
	private double longitude;
	
	public Coordinate(double lati, double longi) {
		latitude = lati;
		longitude = longi;
	}

	public Coordinate getDistance(Coordinate other) {
		if(other == null) {
			throw new IllegalArgumentException();
		}
		return new Coordinate(Math.abs(getLatitudinalDistance(other)), Math.abs(getLongitudinalDistance(other)));
	}
	
	public double getLatitudinalDistance(Coordinate other)	{
		return Math.abs(latitude - other.latitude);
	}
	
	public double getLongitudinalDistance(Coordinate other) {
		return Math.abs(longitude - other.longitude);
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public double getLatitude() {
		return latitude;
	}
}
