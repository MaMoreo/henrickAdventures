/*
 * This is the Main Menu Screen. As soon as the Game class set up the game data and load the assets, it sets the screen to MainMenuScreen
 */

package com.digitalwolf.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.digitalwolf.assets.Assets;
import com.digitalwolf.gamedata.GameData;
import com.moribitotech.mtx.AbstractScreen;
import com.moribitotech.mtx.ButtonGame;
import com.moribitotech.mtx.IScreen;
import com.moribitotech.mtx.MenuCreator;
import com.moribitotech.mtx.effects.EffectCreator;
import com.moribitotech.mtx.models.base.EmptyAbstractActor;
import com.moribitotech.mtx.models.base.EmptyAbstractActorLight;
import com.moribitotech.mtx.models.base.TableModel;
import com.moribitotech.mtx.settings.AppSettings;

public class MainMenuScreen extends AbstractScreen implements IScreen{

	EmptyAbstractActor testActor;
	//ButtonGame timerActor;
	EmptyAbstractActorLight logo;
	Dialog exitDialog;
	
	public MainMenuScreen(Game game, String screenName) {
		super(game, screenName);
		//
		setUpScreenElements();
		setUpInfoPanel();
		//setUpActors();
		setUpMenu();
	}

	@Override
	public void setUpScreenElements() {
		setBackgroundTexture(Assets.bg_completo);
		setBackButtonActive(true);
		
		//Start Playing the Music if the sound is enabled
		if (GameData.getSoundEnabled()) {
			Assets.musicMenus.play();
		}
	}

	@Override
	public void setUpInfoPanel() {
		// Game Logo
		logo = new EmptyAbstractActorLight(358, 188, true);
		logo.setPosition(AppSettings.SCREEN_W -1.7f*logo.getWidth(), AppSettings.WORLD_HEIGHT - 1.1f*logo.getHeight());		
		logo.setTextureRegion(Assets.logo, true);
		EffectCreator.create_SC_BTN(logo, 1.0f, 1.0f, 1.0f, null, false);		
		//getStage().addActor(logo);

	}

	/**
	 * No lo llamamos
	 */
	private void setUpActors() {
		
		testActor = new EmptyAbstractActor(100, 100, true);
		testActor.setPosition(
				240 * AppSettings.getWorldPositionXRatio()
						- testActor.getWidth() / 2.0f,
				140 * AppSettings.getWorldPositionYRatio()
						- testActor.getHeight() / 2.0f);
		testActor.setAnimation(Assets.henrickStill, true, true);
		getStage().addActor(testActor);
		
		//timerActor = MenuCreator.createCustomGameButton(Assets.smallFont, Assets.tooltip, Assets.tooltip,350,60,true);		
		//timerActor.setPosition(testActor.getX()+testActor.getWidth(), testActor.getY()+testActor.getHeight());
		//timerActor.setTextPosXY(10, 52);
		
		//if(GameData.isTimerOn())
		//timerActor.setText("200 seconds to go", true);
		//else
		//timerActor.setText("Let's go.. advent", true);
		
		//getStage().addActor(timerActor);


	}

	@Override
	public void setUpMenu() {
		
		// // #######################################
/*		TableModel tableMenu = new TableModel(null,
				300*AppSettings.getWorldPositionXRatio(), 2*AppSettings.WORLD_HEIGHT/3);
		
		tableMenu.setPosition(AppSettings.WORLD_WIDTH + tableMenu.getWidth(),
				-AppSettings.getWorldPositionYRatio());
		
		tableMenu.addAction(Actions.moveTo(AppSettings.WORLD_WIDTH - tableMenu.getWidth(), 0, 0.5f));*/

		TableModel tableMenu = new TableModel(null,
				300*AppSettings.getWorldPositionXRatio(), 4*AppSettings.WORLD_HEIGHT/3);
		
		tableMenu.setPosition(AppSettings.WORLD_WIDTH + tableMenu.getWidth(),
				-AppSettings.getWorldPositionYRatio());
		
		tableMenu.addAction(Actions.moveTo(AppSettings.WORLD_WIDTH - tableMenu.getWidth(), 0, 0.5f));

		
		// #######################################
	/*	ButtonGame startGameButton = MenuCreator.createCustomGameButton(null, Assets.startgame_button, Assets.startgame_button2);
		
		startGameButton.addListener(new ActorGestureListener() {
			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);
				//
				getGame().setScreen(new LevelSelectScreen(getGame(), "Game Screen"));
			}
		});*/
		
ButtonGame startGameButton = MenuCreator.createCustomGameButton(null, Assets.jugarNO, Assets.jugarSI);
	
		startGameButton.addListener(new ActorGestureListener() {
			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);
				//
				//getGame().setScreen(new LevelSelectScreen(getGame(), "Game Screen"));
				getGame().setScreen(new MapScreen(getGame(), "Map Screen"));
			}
		});


		// #########################################

		

		ButtonGame settingsButton = MenuCreator.createCustomGameButton(null,
				Assets.opcionesNO, Assets.opcionesSI);
		
		settingsButton.addListener(new ActorGestureListener() {
			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);
				//
				getGame().setScreen(new OptionsScreen(getGame(), "Options Screen"));
			}
		});
		

		ButtonGame quitButton = MenuCreator.createCustomGameButton(null,
				Assets.salirNO, Assets.salirSI);
	
		
		quitButton.addListener(new ActorGestureListener() {
			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);
				getGame().setScreen(new ExitScreen(getGame(), "Exit Screen"));

			
			}
		});
		
		// #######################################
	/*	ButtonGame creditsButton = MenuCreator.createCustomGameButton(
				null, Assets.button_credits,
				Assets.button_credits2);
	
		creditsButton.addListener(new ActorGestureListener() {
			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);
				getGame().setScreen(new CreditsScreen(getGame(), "Credits Screen"));
		
			}
		});*/
/*		ButtonGame connectButton = MenuCreator.createCustomGameButton(
				null, Assets.conectarNO,
				Assets.conectarSI);
	
		connectButton.addListener(new ActorGestureListener() {
			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);
				getGame().setScreen(new CreditsScreen(getGame(), "Connect Screen"));
		
			}
		});*/
		// #########################################
	/*	final TestActor btnOn = new TestActor(90, 90, true);
		TextureRegion temp = (GameData.getSoundEnabled())?Assets.button_on:Assets.button_off;
		btnOn.setTextureRegion(temp, true);
		
		btnOn.addListener(new ActorGestureListener() {
					@Override
					public void touchUp(InputEvent event, float x, float y,
							int pointer, int button) {
						super.touchUp(event, x, y, pointer, button);
                  //
						if(GameData.getSoundEnabled()){
							if(Assets.music.isPlaying())
							Assets.music.pause();
							btnOn.setTextureRegion(Assets.button_off, true);
							GameData.setSoundEnabled(false);
						}
						else{
							if(!(Assets.music.isPlaying()))
								Assets.music.play();
							btnOn.setTextureRegion(Assets.button_on, true);
							GameData.setSoundEnabled(true);
						}
					}
				});*/
				
				// #########################################
		/*ButtonGame btnInstructions = MenuCreator.createCustomGameButton(null,
						Assets.timer, Assets.timer);
				
		btnInstructions.addListener(new ActorGestureListener() {
					@Override
					public void touchUp(InputEvent event, float x, float y,
							int pointer, int button) {
						super.touchUp(event, x, y, pointer, button);
						//
						/*if(GameData.isTimerOn()){
						GameData.setTimer(false);
						timerActor.setText("Let's go.. advent", true);
						}
						else{
						GameData.setTimer(true);
						timerActor.setText("200 seconds to go", true);
						}*/
						
						/*if(testActor.getAnimation() == Assets.henrickWalk)
						testActor.setAnimation(Assets.henrickStill, true, true);
						else
						testActor.setAnimation(Assets.henrickWalk, true, true);
					
					}
				});*/

		//
		float dipRatioWidth = 1.1f* 174 * AppSettings.getWorldSizeRatio();
		float dipRatioHeight =  1.1f* 74 * AppSettings.getWorldSizeRatio();
		float padding = 9.0f * AppSettings.getWorldSizeRatio();

		// #######################################
		
		
		tableMenu.add(startGameButton).size(dipRatioWidth, dipRatioHeight).pad(padding);
		tableMenu.row();
		tableMenu.add(settingsButton).size(dipRatioWidth, dipRatioHeight).pad(padding);
		tableMenu.row();
		tableMenu.add(quitButton).size(dipRatioWidth, dipRatioHeight).pad(padding);
	//	tableMenu.row();
	//	tableMenu.add(btnOn).padLeft(padding*20).size(80* AppSettings.getWorldSizeRatio(), 80* AppSettings.getWorldSizeRatio());
		//tableMenu.add(btnInstructions).padRight(padding*20).size(80* AppSettings.getWorldSizeRatio(), 80* AppSettings.getWorldSizeRatio());
		
		getStage().addActor(tableMenu);
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
		
    // You can uncomment the code below to create effects in the gamelogo
		
		if(logo.getScaleX() <= 0.8f)
		EffectCreator.create_SC_BTN(logo, 1.2f, 1.2f, 1.0f, null, false);
		else
		EffectCreator.create_SC_BTN(logo, 0.5f, 0.5f, 1.0f, null, false);
		
		   if(getSecondsTime() % 3 ==0){
	        	 EffectCreator.create_SC_BTN(logo, 1.2f, 1.2f, 0.5f, null, false);
		   }
		   
	}

	@Override
	public void keyBackPressed() {
		super.keyBackPressed();
		//getGame().setScreen(new MainMenuScreen(getGame(), "MainMenu Screen"));
		Gdx.app.exit();		
    }
}
