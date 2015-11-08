package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CartesianCoordinateTest {

	private CartesianCoordinate a;
	private CartesianCoordinate b;
	private CartesianCoordinate c;
	private CartesianCoordinate d;
	
	private CartesianCoordinate mirrorA;
	
	private SphericCoordinate equA;
	
	@Before
	public void setUp() {
		a = new CartesianCoordinate(22.8, 12.4, 80.9);
		b = new CartesianCoordinate(200.6, 7.3, 99.1);
		c = new CartesianCoordinate(8.0, 104.33, 42.9);
		d = new CartesianCoordinate(1204.54, 459.99, 71.4);	
		mirrorA = new CartesianCoordinate(22.8, 12.4, 80.9);	
		equA = new SphericCoordinate(Math.asin(80.9/(22.8*22.8 + 12.4*12.4 + 80.9*80.9)), Math.atan2(12.4,22.8), Math.sqrt(22.8*22.8 + 12.4*12.4 + 80.9*80.9));
	}
	
	
	@Test
	public void coordDistanceTest() {
		assertEquals(a.getDistance(b), 178.80, 0.01);
		assertEquals(a.getDistance(c), 100.56, 0.01);
		assertEquals(a.getDistance(d), 1263.69, 0.01);
		assertEquals(b.getDistance(c), 222.86, 0.01);
		assertEquals(b.getDistance(d), 1101.63, 0.01);
		assertEquals(c.getDistance(d), 1248.60, 0.01);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void illegalDistanceTest() {
		c.getDistance(null);
	}
	
	@Test
	public void distanceXTest() {
		assertEquals(a.getXDistance(c), 14.80, 0.01);
		assertEquals(b.getXDistance(d), 1003.94, 0.01);
	}
	
	@Test
	public void distanceYTest() {
		assertEquals(a.getYDistance(d), 447.59, 0.01);
		assertEquals(b.getYDistance(c), 97.03, 0.01);
	}
	
	@Test
	public void distanceZTest() {
		assertEquals(a.getZDistance(b), 18.20, 0.01);
		assertEquals(c.getZDistance(d), 28.50, 0.01);
	}
	
	@Test
	public void isEqualTest() {
		assertFalse(c.isEqual(a));
		assertTrue(a.isEqual(a));
		assertTrue(a.isEqual(mirrorA));
		System.out.println(Math.atan2(12.4, 22.8));
		assertTrue(a.isEqual(equA));
	}
}
