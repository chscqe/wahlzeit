package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate {

	
	private static final double EPSILON = 0.01;
	
	private final double x;
	private final double y;
	private final double z;
	
	
	public AbstractCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	protected void assertNotNull(Object o) {
		assert (o != null);		
	}
	
	protected void assertCoordinatesLegal(double x, double y, double z) {
		assert (x != Double.NaN);
		assert (y != Double.NaN);
		assert (z != Double.NaN);
	}
	
	public double getDistance(Coordinate other) {
		//precondition
		assertNotNull(other);
		CartesianCoordinate c;
		if(other instanceof SphericCoordinate) {
			c = convertToCartesian((SphericCoordinate)other);
		}
		else if(other instanceof CartesianCoordinate){
			c = (CartesianCoordinate) other;
		}	
		else {
			throw new IllegalArgumentException();
		}
		//precondition
		assertCoordinatesLegal(c.getX(), c.getY(), c.getZ());
		double distX = c.getXDistance(c);
		double distY = c.getYDistance(c);
		double distZ = c.getZDistance(c);
		//postcondition
		assertNotNull(other);
		assertCoordinatesLegal(c.getX(), c.getY(), c.getZ());
		return Math.sqrt(distX*distX + distY*distY + distZ*distZ);
	}
	
	@Override
	public boolean isEqual(Coordinate other) {
		
		//precondition
		assertNotNull(other);
		
		CartesianCoordinate c;
		if(other instanceof CartesianCoordinate) {
			c = (CartesianCoordinate) other;
			//precondition
			assertCoordinatesLegal(c.getX(), c.getY(), c.getZ());
			if(Math.abs(this.getX() - c.getX()) < EPSILON && Math.abs(this.getY() - c.getY()) < EPSILON && Math.abs(this.getZ() - c.getZ()) < EPSILON){
				//postcondition
				assertNotNull(other);
				assertCoordinatesLegal(c.getX(), c.getY(), c.getZ());
				return true;
			}
		}
		else if(other instanceof SphericCoordinate) {
			c = convertToCartesian((SphericCoordinate) other);
			//precondition
			assertCoordinatesLegal(c.getX(), c.getY(), c.getZ());
			if(Math.abs(this.getX() - c.getX()) < EPSILON && Math.abs(this.getY() - c.getY()) < EPSILON && Math.abs(this.getZ() - c.getZ()) < EPSILON){
				//postcondition
				assertNotNull(other);
				assertCoordinatesLegal(c.getX(), c.getY(), c.getZ());
				return true;
			}	
		}
		//postcondition
		assertNotNull(other);
		return false;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getZ() {
		return z;
	}
	
	private CartesianCoordinate convertToCartesian(SphericCoordinate s) {
		double cX = s.getRadius() * Math.cos(s.getLatitude()) * Math.cos(s.getLongitude());
		double cY = s.getRadius() * Math.cos(s.getLatitude()) * Math.sin(s.getLongitude());
		double cZ = s.getRadius() * Math.sin(s.getLatitude());
		CartesianCoordinate c = new CartesianCoordinate(cX, cY, cZ);
		return c;
	}
	
	
}
