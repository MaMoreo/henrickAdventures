package com.mtx.scene2dactors;

import com.digitalwolf.world.World;

public class Door extends TestActor{

	public boolean visible;
	public static float width =40 * World.WORLD_UNIT;
	public static float height = 80 * World.WORLD_UNIT;
	
	//VARIABLES FOR TRACKING THE LIFE TIME OF THE EGGS
	private float startTime = System.nanoTime();
	public static float SECONDS_TIME = 0;
	
	public Door(float width, float height, boolean DIPActive) {
		super(width, height, DIPActive);
		
		// Make the Egg Visible
		visible =true;
		setLifeTime(0);
	}
	
	public void update(float delta){
		if (System.nanoTime() - startTime >= 1000000000) {
			SECONDS_TIME++;
			startTime = System.nanoTime();
		}
	}
	
	public float getLifeTime() {
		return SECONDS_TIME;
	}
	
	public void setLifeTime(float secondsTime) {
		SECONDS_TIME = secondsTime;
	}
}