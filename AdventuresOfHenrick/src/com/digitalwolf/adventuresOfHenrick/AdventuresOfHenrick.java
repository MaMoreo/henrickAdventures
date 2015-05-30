package com.digitalwolf.adventuresOfHenrick;

/*
 * Chronicles of Henrick is a 2D Open Source game written in LibGDX by Burntcity.
 * This game is meant for the
 * purpose of learning. You may use the source code to create your own games.
 */
/*
 * This is the Main class of the Project. AdventuresOfHenrick extends the Game class.
 */

import com.badlogic.gdx.Game;
import com.digitalwolf.assets.Assets;
import com.digitalwolf.gamedata.GameData;
import com.digitalwolf.screens.MainMenuScreen;
import com.moribitotech.mtx.SettingsManager;
import com.moribitotech.mtx.settings.AppSettings;
import com.moribitotech.mtx.settings.MtxLogger;

public class AdventuresOfHenrick extends Game {
	
	@Override
	public void create() {
		
		//Set Up the Application
		AppSettings.setUp();
		
		//If the Application is launched for the first time, create preferences to store game data such as Array of top 5
		//Highscores, timer mode  and sound settings
		
		if(SettingsManager.isFirstLaunch()){
			SettingsManager.setFirstLaunchDone(true);
			MtxLogger.log(true, true, "LAUNCH", "THIS IS FIRST LAUNCH");
			GameData.createPrefs();
			GameData.saveLevelInfo();
		}
		else{
			MtxLogger.log(true, true, "LAUNCH", "THIS IS NOT FIRST LAUNCH");
			if(GameData.prefs == null)
			GameData.createPrefs();
		}
		
		// Load assets before setting the screen
		// #####################################
		Assets.loadAll();
	
		// Set up the main menu screen
		// #####################################
		setScreen(new MainMenuScreen(this, "MainMenu Screen"));
	}
	
	@Override
	public void resume(){
		Assets.loadAll();
	}

}
