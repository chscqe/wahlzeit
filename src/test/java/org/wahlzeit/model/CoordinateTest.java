package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CoordinateTest {

	private Coordinate a = new Coordinate(42.3, 50.6);
	private Coordinate b = new Coordinate(-66.2, 80.9);
	private Coordinate c = new Coordinate(-60.2, 103.9);
	private Coordinate d = new Coordinate(90, -2.5);
	
	private Coordinate illegalCoord;
	
	@Test
	public void coordDistanceTest() {
		assertEquals(a.getDistance(b), new Coordinate(63.9, 30.3));
	}
	
}
