package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Subclass;

@Subclass(index=true)
public class WindowPhoto extends Photo{

	private Window window;
	
	public WindowPhoto() {
		super();
	}

	public WindowPhoto(PhotoId id){
		super(id);
	}
	
	/**
	 * @methodtype get
	 */
	public Window getWindow() {
		return window;
	}
	
	/**
	 * @methodtype set
	 */
	public void setWindow(Window window) {
		this.window = window;
	}
}
