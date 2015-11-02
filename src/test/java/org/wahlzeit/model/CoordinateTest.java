package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoordinateTest {

	private Coordinate a = new Coordinate(42.3, 50.6);
	private Coordinate b = new Coordinate(-66.2, 80.9);
	private Coordinate c = new Coordinate(-60.2, 103.9);
	private Coordinate d = new Coordinate(90.0, -2.5);
	
	@Test
	public void coordDistanceTest1() {
		assertEquals(a.getDistance(b), 108.5, 0.01);
		assertEquals(a.getDistance(b), 30.3, 0.01);
	}
	
	@Test
	public void coordDistanceTest2() {
		assertEquals(c.getDistance(d), 150.2, 0.01);
		assertEquals(c.getDistance(d), 106.4, 0.01);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void illegalDistanceTest() {
		c.getDistance(null);
	}
	
	@Test
	public void distanceLatiTest1() {
		assertEquals(a.getLatitudinalDistance(c), 102.5, 0.01);
	}
	
	@Test
	public void distanceLatiTest2() {
		assertEquals(b.getLatitudinalDistance(d), 156.2, 0.01);
	}
	
	@Test
	public void distanceLongiTest1() {
		assertEquals(a.getLongitudinalDistance(d), 53.1, 0.01);
	}
	
	@Test
	public void distanceLongiTest2() {
		assertEquals(b.getLongitudinalDistance(c), 23.0, 0.01);
	}
}
