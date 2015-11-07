package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SphericCoordinateTest {

	private SphericCoordinate a = new SphericCoordinate(42.3, 50.6);
	private SphericCoordinate b = new SphericCoordinate(-66.2, 80.9);
	private SphericCoordinate c = new SphericCoordinate(-60.2, 103.9);
	private SphericCoordinate d = new SphericCoordinate(90.0, -2.5);
	
	@Test
	public void coordDistanceTest1() {
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
