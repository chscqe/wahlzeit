package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Subclass;

@Subclass
public class WindowPhoto extends Photo{


	public WindowPhoto() {
		super();
	}

	public WindowPhoto(PhotoId id){
		super(id);
	}
}
