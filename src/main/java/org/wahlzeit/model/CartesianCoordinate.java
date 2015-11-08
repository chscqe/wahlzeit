package org.wahlzeit.model;

public class CartesianCoordinate implements Coordinate{

	private double x;
	private double y;
	private double z;
	
	public CartesianCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	@Override
	public double getDistance(Coordinate other) {
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
		double distX = getXDistance(c);
		double distY = getYDistance(c);
		double distZ = getZDistance(c);
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
		CartesianCoordinate c;
		if(other instanceof CartesianCoordinate) {
			c = (CartesianCoordinate) other;
			if(this.getX() == c.getX() && this.getY() == c.getY() && this.getZ() == c.getZ()){
				return true;
			}
		}
		else if(other instanceof SphericCoordinate) {
			c = convertToCartesian((SphericCoordinate) other);
			if(this.getX() == c.getX() && this.getY() == c.getY() && this.getZ() == c.getZ()){
				return true;
			}	
		}
		return false;
	}
	
	private CartesianCoordinate convertToCartesian(SphericCoordinate s) {
		double x = s.getRadius() * Math.cos(s.getLatitude()) * Math.cos(s.getLongitude());
		double y = s.getRadius() * Math.cos(s.getLatitude()) * Math.sin(s.getLongitude());
		double z = s.getRadius() * Math.sin(s.getLatitude());
		CartesianCoordinate c = new CartesianCoordinate(x, y, z);
		return c;
	}
}
