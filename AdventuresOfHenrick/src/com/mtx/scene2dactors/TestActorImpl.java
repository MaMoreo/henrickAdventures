package com.mtx.scene2dactors;

public class TestActorImpl extends TestActor {

	public boolean visible;
	private float startTime = System.nanoTime();
	public static float SECONDS_TIME = 0;

	public TestActorImpl(float width, float height, boolean DIPActive) {
		super(width, height, DIPActive);
	}

	public void update(float delta) {
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