package org.wahlzeit.model;

import java.io.Serializable;

public class WindowType implements Serializable{

	private final String windowType;
	private final WindowType superType;
	
	public WindowType(String windowType, WindowType superType) {
		this.windowType = windowType;
		this.superType = superType;
	}
	
	/**
	 * @methodtype construct
	 */
	public Window createInstance() {
		return new Window(this);
	}
	
	/**
	 * @methodtype get
	 */
	public WindowType getSuperType() {
		return superType;
	}
	
	/**
	 * @methodtype get
	 */
	public String getWindowTypeName() {
		return windowType;
	}
}
