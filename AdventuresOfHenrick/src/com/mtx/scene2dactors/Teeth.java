package com.mtx.scene2dactors;

import com.digitalwolf.world.World;

public class Teeth extends TestActorImpl {

	public static float width = 39 * World.WORLD_UNIT;
	public static float height = 39 * World.WORLD_UNIT;

	public Teeth(boolean DIPActive) {
		super(width, height, DIPActive);
		// Make the Teeth Visible
		visible = true;
	}

}
