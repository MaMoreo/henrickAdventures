package com.mtx.scene2dactors;

import com.digitalwolf.world.World;

public class Gem extends TestActorImpl{

	public static float width =73/4f * World.WORLD_UNIT;
	public static float height = 68/4f * World.WORLD_UNIT;
	
	public Gem(float width, float height, boolean DIPActive) {
		super(width, height, DIPActive);
		// Make the Egg Visible
		visible =true;
		setLifeTime(0);
	}
	
}