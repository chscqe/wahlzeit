package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SphericCoordinateTest {

	private SphericCoordinate a = new SphericCoordinate(42.3, 50.6);
	private SphericCoordinate b = new SphericCoordinate(-66.2, 80.9);
	private SphericCoordinate c = new SphericCoordinate(-60.2, 103.9);
	private SphericCoordinate d = new SphericCoordinate(90.0, -2.5);
	
	private CartesianCoordinate ill = new CartesianCoordinate(1204.54, 459.99, 71.4);
	
	@Test
	public void coordDistanceTest() {
		assertEquals(a.getDistance(b), 12003.62, 0.01);
		assertEquals(a.getDistance(c), 8180.66, 0.01);
		assertEquals(a.getDistance(d), 7118.37, 0.01);
		assertEquals(b.getDistance(c), 13382.34, 0.01);
		assertEquals(b.getDistance(d), 9631.74, 0.01);
		assertEquals(c.getDistance(d), 4300.57, 0.01);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void illegalDistanceTest() {
		c.getDistance(null);
	}
	
	@Test
	public void distanceLatiTest() {
		assertEquals(a.getLatitudinalDistance(c), 102.50, 0.01);
		assertEquals(b.getLatitudinalDistance(d), 156.20, 0.01);
	}
	
	
	@Test
	public void distanceLongiTest() {
		assertEquals(a.getLongitudinalDistance(d), 53.10, 0.01);
		assertEquals(b.getLongitudinalDistance(c), 23.00, 0.01);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void illegalTypesTest() {
		b.getDistance(ill);
	}
}
