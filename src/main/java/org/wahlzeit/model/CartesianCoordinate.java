package org.wahlzeit.model;

public class CartesianCoordinate extends AbstractCoordinate{
	
	public CartesianCoordinate(double x, double y, double z) {
		super(x, y, z);
	}
	
	
	public double getXDistance(CartesianCoordinate other)	{
		return Math.abs(this.getX() - other.getX());
	}
	
	public double getYDistance(CartesianCoordinate other) {
		return Math.abs(this.getY() - other.getY());
	}
	
	public double getZDistance(CartesianCoordinate other) {
		return Math.abs(this.getZ() - other.getZ());
	}
}
