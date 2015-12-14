package org.wahlzeit.model;

public class CartesianCoordinate extends AbstractCoordinate{
	
	protected CartesianCoordinate(double x, double y, double z) {
		super(x, y, z);
		list.add(this);
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
