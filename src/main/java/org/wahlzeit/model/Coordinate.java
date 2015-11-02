package org.wahlzeit.model;

public class Coordinate {

	private double latitude;
	private double longitude;
	
	public Coordinate(double lati, double longi) {
		latitude = lati;
		longitude = longi;
	}

	public double getDistance(Coordinate other) {
		if(other == null) {
			throw new IllegalArgumentException();
		}
		double deltaX = Math.cos(other.getLongitude())*Math.cos(other.getLatitude()) - Math.cos(getLongitude()) * Math.cos(getLatitude());
		double deltaY = Math.cos(other.getLongitude())*Math.sin(other.getLatitude()) - Math.cos(getLongitude()) * Math.sin(getLatitude());
		double deltaZ = Math.sin(other.getLongitude()) - Math.sin(getLongitude());
		double C = Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);
		double deltaSig = 2.0 * Math.asin(C / 2.0);
		return 6371.0 * deltaSig;
	}
	
	public double getLatitudinalDistance(Coordinate other)	{
		return Math.abs(latitude - other.getLatitude());
	}
	
	public double getLongitudinalDistance(Coordinate other) {
		return Math.abs(longitude - other.getLongitude());
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public double getLatitude() {
		return latitude;
	}
}
