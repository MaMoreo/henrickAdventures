package com.digitalwolf.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.digitalwolf.assets.Assets;
import com.digitalwolf.gamedata.GameData;
import com.moribitotech.mtx.AbstractScreen;
import com.moribitotech.mtx.ButtonGame;
import com.moribitotech.mtx.ButtonLevel;
import com.moribitotech.mtx.MenuCreator;
import com.moribitotech.mtx.models.base.EmptyAbstractActor;
import com.moribitotech.mtx.models.base.TableModel;
import com.moribitotech.mtx.settings.AppSettings;

public class LevelSelectScreen extends AbstractScreen {

	Table levelsTable1;
	
	private int selectedLevel;
	private int selectedWorld;
	private String message ="Select a Level to Play";
	private ButtonGame infoButton;
	 private EmptyAbstractActor world1Actor,world2Actor, testActor;
	 private TableModel worldsTable;
	 ScrollPane scrollPane;
	 
	public LevelSelectScreen(Game game, String screenName) {
		super(game, screenName);
		
		//selectedWorld =1;
		setUpScreenElements();
		setUpLevelsScreen();
		setUpMusic();
	}

	/**
	 * Arranca la musica.
	 */
	private void setUpMusic() {
		// Start Playing the Music if the sound is enabled
		if (GameData.getSoundEnabled()) {
			Assets.musicMenus.play();
		}
	}

	public void setUpScreenElements() {
		setBackgroundTexture(Assets.bg);
		setBackButtonActive(true);
	
		testActor = new EmptyAbstractActor(100, 100, true);
		testActor.setPosition(
				100 * AppSettings.getWorldPositionXRatio()
						- testActor.getWidth() / 2.0f,
				60 * AppSettings.getWorldPositionYRatio()
						- testActor.getHeight() / 2.0f);
		getStage().addActor(testActor);		
		testActor.setAnimation(Assets.henrickStill, true, true);
        
		
		infoButton = MenuCreator.createCustomGameButton(Assets.smallFont,
				Assets.tooltip, Assets.tooltip);				
		infoButton.setSize(400, 60);
		infoButton.setText("Select a Level to Play", true);
		
		
		world1Actor = new EmptyAbstractActor(450*AppSettings.getWorldPositionXRatio(),200*AppSettings.getWorldPositionYRatio(), true);
		world1Actor.setTextureRegion(Assets.bg, true);
		world1Actor.addListener(new ActorGestureListener() {
				@Override
				public void touchUp(InputEvent event, float x, float y,
						int pointer, int button) {
					super.touchUp(event, x, y, pointer, button);
					selectedWorld =1;
					infoButton.setText("World 1", true);
				}
			});
		 
		world2Actor = new EmptyAbstractActor(450*AppSettings.getWorldPositionXRatio(),200*AppSettings.getWorldPositionYRatio(), true);
	    world2Actor.setTextureRegion(Assets.world2, true);
		
	    world2Actor.addListener(new ActorGestureListener() {
			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);
				selectedWorld =2;
				infoButton.setText("World 2 ..coming soon", true);
			}
		});
	    
		worldsTable = new TableModel(Assets.transparent,
				AppSettings.WORLD_WIDTH , AppSettings.WORLD_HEIGHT);
		
		worldsTable.add(world1Actor);
		worldsTable.add(world2Actor);
   
		// put the table inside a scrollpane  
        scrollPane = new ScrollPane(worldsTable);  
        scrollPane.setBounds(AppSettings.SCREEN_W/2+ 30*AppSettings.getWorldPositionXRatio(), 2*AppSettings.SCREEN_H/3.2f*AppSettings.getWorldPositionYRatio(), 2*AppSettings.SCREEN_W/5, 2*AppSettings.SCREEN_H/5);  
        scrollPane.setScrollingDisabled(false, false);  
        scrollPane.setOverscroll(false, false);  
        scrollPane.invalidate();  
        getStage().addActor(scrollPane);  
         
		
		//END OF WHAT I WANTEDs
	
		infoButton.setTextPosXY(10*AppSettings.getWorldPositionXRatio(), 50);
		infoButton.setPosition(100*AppSettings.getWorldPositionXRatio(), 100*AppSettings.getWorldPositionYRatio());
		getStage().addActor(infoButton);
	}
	
	private void setUpLevelsScreen() {
		// Create levels table
		// ######################################################################
	    levelsTable1 = MenuCreator.createTable(true, Assets.getSkin());
	    levelsTable1.setSize(AppSettings.SCREEN_W/1.8f, AppSettings.SCREEN_H/1.8f);
		levelsTable1.setPosition(-999, 0);
		levelsTable1.addAction(Actions.moveTo(0, 0, 0.7f));
		levelsTable1.top().left().pad(20, 20, 20, 20);
		
		// Add to stage
		// ######################################################################
		getStage().addActor(levelsTable1);
		
		// Add levels buttons
		// Normally get this number from textfiles or database
		// ######################################################################
		//int numberOfLevels = Settings.NUMBER_OF_LEVELS;
		int numberOfLevels = GameData.NUMBER_OF_LEVELS;
		
		// Create buttons with a loop
		for (int i = 1; i <= numberOfLevels; i++){
			//1. Create level button
			final ButtonLevel levelButton = MenuCreator.createCustomLevelButton(Assets.smallFont,Assets.level_button1,Assets.level_button2);
			
			//final int selectedLevel =i;
			//2. Set level number
			levelButton.setLevelNumber(i , Assets.smallFont);
			
			//3. Set lock condition (get from database if it is locked or not and lock it)
			// use if/else here to lock or not
			
			if(!GameData.prefs.getBoolean("level"+i)){
				levelButton.setTextureExternal(Assets.level_locked, true);
				levelButton.setTextureExternalPosXY(60, 0);
				levelButton.setTextureExternalSize(36*AppSettings.getWorldSizeRatio(), 36*AppSettings.getWorldSizeRatio());
			}
			
//			Random rnd = new Random();
			
//			if(GameData.prefs.getBoolean("level"+i)){
//				levelButton.setLevelStars(Assets.level_star, Assets.level_star, 3, rnd.nextInt(3) + 1);
//				}
			
			//4. Set stars or any other achievements (get from database or text files here)
			// I just made a random number of earned stars 
			
			
			
			
			//5. Add  listener
			//Add button listener to go to a level (gamescreen)
			
			levelButton.addListener(new ActorGestureListener() {
			@Override
				public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
					super.touchUp(event, x, y, pointer, button);
					selectedLevel = levelButton.getLevelNumber();
					
					if(GameData.getLevelInfo()[selectedLevel]){
					message = "You Selected Level "+selectedLevel;
					GameScreen.currentlevel = selectedLevel;
					getGame().setScreen(new GameScreen(getGame(), "GameScreen"));
					
					stopMusic();
					}
					else{
						message = "Level "+selectedLevel+" is Locked";
					}
				
					
					if(selectedWorld ==2){
						//if(GameData.getLevelInfo()[selectedLevel]){
						message = "World 2 is coming soon.. ";
						//GameScreen.currentlevel = selectedLevel;
						//getGame().setScreen(new GameScreen(getGame(), "GameScreen"));
						//}
						//else{
						//	message = "Level "+selectedLevel+" is Locked... "+GameData.prefs.getBoolean("level"+selectedLevel);
						//}
						}
					
					infoButton.setText(message, true);
				}

			
			});

			//6. Add row after each 5 level button to go down or how many do you need
			if((i-1) % 4 == 0){
				levelsTable1.row();
			}
			
			// Add to table
			levelsTable1.add(levelButton).size(80, 80).pad(7, 7, 7, 7);
		}		
	}
	
	@Override
	public void keyBackPressed() {
		super.keyBackPressed();
		getGame().setScreen(new MainMenuScreen(getGame(), "MenuScreen"));
		stopMusic();
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
		
	}
	
	
	/**
	 * Para la musica.
	 */
	private void stopMusic() {
		//PARA LA MUSICA QUE NOS VAMOS A OTRA SCREEN
		if (GameData.getSoundEnabled()) {
			Assets.musicMenus.stop();
		}
	}

}
