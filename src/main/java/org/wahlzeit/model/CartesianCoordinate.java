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
		if(other == null) {
			throw new IllegalArgumentException();
		}
		if(!(other instanceof CartesianCoordinate)) {
			throw new IllegalArgumentException();
		}
		CartesianCoordinate c = (CartesianCoordinate) other;
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
		if(other instanceof CartesianCoordinate) {
			CartesianCoordinate c = (CartesianCoordinate) other;
			if(this.getX() == c.getX() && this.getY() == c.getY() && this.getZ() == c.getZ()){
				return true;
			}
		}
		return false;
	}
}
