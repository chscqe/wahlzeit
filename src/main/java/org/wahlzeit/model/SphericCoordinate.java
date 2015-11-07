package org.wahlzeit.model;

public class SphericCoordinate implements Coordinate{

	private double latitude;
	private double longitude;
	private double radius;
	
	public SphericCoordinate(double latitude, double longitude, double radius) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
	}

	@Override
	public double getDistance(Coordinate other) {
		if(other == null) {
			throw new IllegalArgumentException();
		}
		if(!(other instanceof SphericCoordinate)){
			throw new IllegalArgumentException();
		}
		SphericCoordinate c = (SphericCoordinate) other;
		double deltaX = Math.cos(c.getLongitude())*Math.cos(c.getLatitude()) - Math.cos(getLongitude()) * Math.cos(getLatitude());
		double deltaY = Math.cos(c.getLongitude())*Math.sin(c.getLatitude()) - Math.cos(getLongitude()) * Math.sin(getLatitude());
		double deltaZ = Math.sin(c.getLongitude()) - Math.sin(getLongitude());
		double C = Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);
		double deltaSig = 2.0 * Math.asin(C / 2.0);
		return radius * deltaSig;
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
	
	public void setLongitude(double lo) {
		this.longitude = lo;
	}
	
	public void setLatitude(double la) {
		this.latitude = la;
	}
	
	public void setRadius (double r) {
		this.radius = r;
	}

	@Override
	public boolean isEqual(Coordinate other) {
		if(other instanceof SphericCoordinate) {
			SphericCoordinate s = (SphericCoordinate) other;
			if(this.getLatitude() == s.getLatitude() && this.getLongitude() == s.getLongitude() && this.getRadius() == s.getRadius()){
				return true;
			}
		}
		return false;
	}
}
