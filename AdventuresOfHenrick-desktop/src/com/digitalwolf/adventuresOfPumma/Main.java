package com.digitalwolf.adventuresOfPumma;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.digitalwolf.adventuresOfHenrick.AdventuresOfHenrick;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "AdventuresOfHenrick";
		cfg.useGL20 = true;
		cfg.width = 800;
		cfg.height = 480;
		
		new LwjglApplication(new AdventuresOfHenrick(), cfg);
	}
}
