package org.wahlzeit.model;

public class CartesianCoordinate extends AbstractCoordinate{

	private double x;
	private double y;
	private double z;
	
	private static final double EPSILON = 0.01;
	
	public CartesianCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	@Override
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
		double distX = getXDistance(c);
		double distY = getYDistance(c);
		double distZ = getZDistance(c);
		//postcondition
		assertNotNull(other);
		assertCoordinatesLegal(c.getX(), c.getY(), c.getZ());
		return Math.sqrt(distX*distX + distY*distY + distZ*distZ);
	}
	
	public double getXDistance(CartesianCoordinate other)	{
		return Math.abs(x - other.getX());
	}
	
	public double getYDistance(CartesianCoordinate other) {
		return Math.abs(y - other.getY());
	}
	
	public double getZDistance(CartesianCoordinate other) {
		return Math.abs(z - other.getZ());
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
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public void setZ(double z) {
		this.z = z;
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
	
	private CartesianCoordinate convertToCartesian(SphericCoordinate s) {
		double cX = s.getRadius() * Math.cos(s.getLatitude()) * Math.cos(s.getLongitude());
		double cY = s.getRadius() * Math.cos(s.getLatitude()) * Math.sin(s.getLongitude());
		double cZ = s.getRadius() * Math.sin(s.getLatitude());
		CartesianCoordinate c = new CartesianCoordinate(cX, cY, cZ);
		return c;
	}
}
