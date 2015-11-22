package org.wahlzeit.model;

public class SphericCoordinate extends AbstractCoordinate{

	private double latitude;
	private double longitude;
	private double radius;
	
	private static final double EPSILON = 0.01;
	
	public SphericCoordinate(double latitude, double longitude, double radius) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
	}

	@Override
	public double getDistance(Coordinate other) {
		//precondition
		assertNotNull(other);
		SphericCoordinate s;
		if(other instanceof CartesianCoordinate) {
			s = convertToSpheric((CartesianCoordinate)other);
		}
		else if(other instanceof SphericCoordinate){
			s = (SphericCoordinate) other;
		}	
		else {
			throw new IllegalArgumentException();
		}
		//precondition
		assertCoordinatesLegal(s.getLatitude(), s.getLongitude(), s.getRadius());
		double deltaX = Math.cos(s.getLongitude())* Math.cos(s.getLatitude()) - Math.cos(getLongitude()) * Math.cos(getLatitude());
		double deltaY = Math.cos(s.getLongitude())* Math.sin(s.getLatitude()) - Math.cos(getLongitude()) * Math.sin(getLatitude());
		double deltaZ = Math.sin(s.getLongitude()) - Math.sin(getLongitude());
		double C = Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);
		double deltaSig = 2.0 * Math.asin(C / 2.0);
		//postcondition
		assertNotNull(other);
		assertCoordinatesLegal(s.getLatitude(), s.getLongitude(), s.getRadius());
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
		//precondition
		assertNotNull(other);
		SphericCoordinate s;
		if(other instanceof SphericCoordinate) {
			s = (SphericCoordinate) other;
			//precondition
			assertNotNull(other);
			assertCoordinatesLegal(s.getLatitude(), s.getLongitude(), s.getRadius());
			if(Math.abs(this.getLatitude() - s.getLatitude()) < EPSILON && Math.abs(this.getLongitude() - s.getLongitude()) < EPSILON && Math.abs(this.getRadius() - s.getRadius()) < EPSILON){
				//postcondition
				assertNotNull(other);
				assertCoordinatesLegal(s.getLatitude(), s.getLongitude(), s.getRadius());
				return true;
			}
		} else if(other instanceof CartesianCoordinate) {
			s = convertToSpheric((CartesianCoordinate) other);
			//precondition
			assertCoordinatesLegal(s.getLatitude(), s.getLongitude(), s.getRadius());
			if(Math.abs(this.getLatitude() - s.getLatitude()) < EPSILON && Math.abs(this.getLongitude() - s.getLongitude()) < EPSILON && Math.abs(this.getRadius() - s.getRadius()) <EPSILON){
				//postcondition
				assertNotNull(other);
				assertCoordinatesLegal(s.getLatitude(), s.getLongitude(), s.getRadius());
				return true;
			}	
		}
		//postcondition
		assertNotNull(other);
		return false;
	}
	
	private SphericCoordinate convertToSpheric(CartesianCoordinate c) {
		double cRadius = Math.sqrt(c.getX()*c.getX() + c.getY()*c.getY() + c.getZ()*c.getZ());
		double cLatitude = Math.asin(c.getZ() / cRadius);
		double cLongitude = Math.atan2(c.getY(), c.getX());
		SphericCoordinate s = new SphericCoordinate(cLatitude, cLongitude, cRadius);
		return s;
	}
}
