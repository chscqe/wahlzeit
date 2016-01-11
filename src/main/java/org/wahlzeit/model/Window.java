package org.wahlzeit.model;

import java.io.Serializable;

public class Window implements Serializable{

	private WindowType windowType;
	private String building;
	private Location location;
	private String epoch;
	
	public Window(WindowType windowType) {
		this.windowType = windowType;
	}
	
	/**
	 * @methodtype get
	 */
	public WindowType getWindowType() {
		return windowType;
	}
	
	/**
	 * @methodtype get
	 */
	public String getBuilding() {
		return building;
	}
	
	/**
	 * @methodtype get
	 */
	public Location getLocation() {
		return location;
	}
	
	/**
	 * @methodtype get
	 */
	public String getEpoch() {
		return epoch;
	}
	
	/**
	 * @methodtype set
	 */
	public void setWindowType(WindowType w) {
		this.windowType = w;
	}
	
	/**
	 * @methodtype set
	 */
	public void setBuilding(String s) {
		this.building = s;
	}
	
	/**
	 * @methodtype set
	 */
	public void setLocation(Location l) {
		this.location = l;
	}
	
	/**
	 * @methodtype set
	 */
	public void setEpoch(String s) {
		this.epoch = s;
	}
}
