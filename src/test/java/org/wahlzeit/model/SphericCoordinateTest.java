package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SphericCoordinateTest {

	private SphericCoordinate a;
	private SphericCoordinate b;
	private SphericCoordinate c;
	private SphericCoordinate d;
	
	private SphericCoordinate mirrorA;
	
	private CartesianCoordinate equA;	
	
	@Before
	public void setUp() {
		a = new SphericCoordinate(42.3, 50.6, 6371.0);
		b = new SphericCoordinate(-66.2, 80.9, 6371.0);
		c = new SphericCoordinate(-60.2, 103.9, 6371.0);
		d = new SphericCoordinate(90.0, -2.5, 6371.0);		
		mirrorA = new SphericCoordinate(42.3, 50.6, 6371.0);		
		equA = new CartesianCoordinate(6371.0 * Math.cos(42.3) * Math.cos(50.6), 6371.0 * Math.cos(42.3) * Math.sin(50.6), 6371.0 * Math.sin(42.3));	
	}
	
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
	
	@Test
	public void mixedCoordsDistanceTest() {
		assertEquals(a.getDistance(equA), 0.0, 0.01);
	}
	
	@Test
	public void isEqualTest() {
		assertFalse(c.isEqual(a));
		assertTrue(a.isEqual(a));
		assertTrue(a.isEqual(mirrorA));
		assertTrue(a.isEqual(equA));
	}
}
