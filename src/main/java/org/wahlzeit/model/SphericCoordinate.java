package org.wahlzeit.model;

public class SphericCoordinate extends AbstractCoordinate{

	private double latitude;
	private double longitude;
	private double radius;
	
	
	protected SphericCoordinate(double latitude, double longitude, double radius) {
		super(radius * Math.cos(latitude) * Math.cos(longitude), radius * Math.cos(latitude) * Math.sin(longitude), radius * Math.sin(latitude));
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
		list.add(convertToCartesian(this));
	}
	
	public static CartesianCoordinate getInstance(double x, double y, double z) {
		for(CartesianCoordinate c : list) {
			if(c.getX() == x && c.getY() == y && c.getZ() == z) {
				return c;
			}
		}
		CartesianCoordinate c = new CartesianCoordinate(x, y, z);
		return c;
	}
	
	public double getLatitudinalDistance(SphericCoordinate other)	{
		return Math.abs(latitude - other.getLatitude());
	}
	
	public double getLongitudinalDistance(SphericCoordinate other) {
		return Math.abs(longitude - other.getLongitude());
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public double getLatitude() {
		return latitude;
	}
}
