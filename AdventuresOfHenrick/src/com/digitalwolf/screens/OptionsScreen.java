package com.digitalwolf.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.digitalwolf.assets.Assets;
import com.digitalwolf.gamedata.GameData;
import com.moribitotech.mtx.AbstractScreen;
import com.moribitotech.mtx.ButtonGame;
import com.moribitotech.mtx.IScreen;
import com.moribitotech.mtx.MenuCreator;
import com.moribitotech.mtx.models.base.TableModel;
import com.moribitotech.mtx.settings.AppSettings;
import com.mtx.scene2dactors.TestActor;

public class OptionsScreen extends AbstractScreen implements IScreen {

	ButtonGame conectarButton, volverButton ;
	
	public OptionsScreen(Game game, String screenName) {
		super(game, screenName);
		
		setUpScreenElements();
		setUpInfoPanel();
		setUpMenu();
	}
	
	@Override
	public void setUpScreenElements() {
		setBackgroundTexture(Assets.opcionesfondo);
		setBackButtonActive(true);
	}
	
	@Override
	public void setUpMenu() {
		
		// // #######################################

		TableModel tableMenu = new TableModel(null, 200,200);
	//	tableMenu.setPosition(300,150);
		
		tableMenu.setPosition(-999, 150);
		
		tableMenu.addAction(Actions.moveTo(300 ,150, 0.5f));

		
		// #######################################

		
		

		// #########################################
	
		

			
		conectarButton = MenuCreator.createCustomGameButton(null,
				Assets.conectarNO, Assets.conectarSI);
		
		
		conectarButton.addListener(new ActorGestureListener() {
			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);
				
				getGame().setScreen(new MainMenuScreen(getGame(), "MainMenuScreen"));
			}
		});
		
	/*	
		musicaButton = MenuCreator.createCustomGameButton(null,
				Assets.musicaNO, Assets.musicaSI);
	
		
		 musicaButton.addListener(new ActorGestureListener() {
			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);
				
			//	Gdx.app.exit();
			}
		});*/
		
		final TestActor musicOn = new TestActor(90, 90, true);
		TextureRegion temp = (GameData.getSoundEnabled())?Assets.musicaSI:Assets.musicaNO;
		musicOn.setTextureRegion(temp, true);
		
		musicOn.addListener(new ActorGestureListener() {
					@Override
					public void touchUp(InputEvent event, float x, float y,
							int pointer, int button) {
						super.touchUp(event, x, y, pointer, button);
                  //
						if(GameData.getSoundEnabled()){
							if(Assets.musicMenus.isPlaying())
							Assets.musicMenus.pause();							
							musicOn.setTextureRegion(Assets.musicaNO, true);
							GameData.setSoundEnabled(false);
						}
						else{
							if(!(Assets.musicMenus.isPlaying()))
								Assets.musicMenus.play();
							musicOn.setTextureRegion(Assets.musicaSI, true);
							GameData.setSoundEnabled(true);
						}
					}
				});
		
		
	// Boton de efectos de Sonido 	
		
		final TestActor effectOn = new TestActor(90, 90, true);
		TextureRegion temp2 = (GameData.getSoundEnabled2())?Assets.sonidoSI:Assets.sonidoNO;
		effectOn.setTextureRegion(temp2, true);
		
		effectOn.addListener(new ActorGestureListener() {
					@Override
					public void touchUp(InputEvent event, float x, float y,
							int pointer, int button) {
						super.touchUp(event, x, y, pointer, button);
                  //
						if(GameData.getSoundEnabled2()){
							
							/*  No necesario ??
							Assets.egggrab.stop(); 
							Assets.gemgrab.stop();
							Assets.cry.stop(); 
							Assets.ow.stop(); 
							Assets.success.stop();
							Assets.fall.stop();
							Assets.jump.stop();
							Assets.walk.stop();
							Assets.fly.stop();
							*/
							effectOn.setTextureRegion(Assets.sonidoNO, true);
							GameData.setSoundEnabled2(false);
						}
						else{
							if(!GameData.getSoundEnabled2()){
							Assets.egggrab.play(); 
							Assets.gemgrab.play();
							Assets.cry.play(); 
							Assets.ow.play(); 
							Assets.success.play();
							Assets.fall.play();
							Assets.jump.play();
							//Assets.walk.play();  //TODO: sonido muy largo (arreglar)
							//Assets.fly.play();   //TODO: sonido muy largo (arreglar)
							effectOn.setTextureRegion(Assets.sonidoSI, true);
							GameData.setSoundEnabled2(true);
						}
						}
					}
				});
		
		
		
	/*
	 * 						Assets.egggrab.stop(); 
							Assets.gemgrab.stop();
							Assets.cry.stop(); 
							Assets.ow.stop(); 
							Assets.success.stop();
							Assets.fall.stop();
							
							
							
							Assets.egggrab.play(); 
							Assets.gemgrab.play();
							Assets.cry.play(); 
							Assets.ow.play(); 
							Assets.success.play();
							Assets.fall.play();
	 * 
	 * 
	 * 
	 * */			
		 
		 
		 // #########################################
		
	
		float dipRatioWidth = 174 * AppSettings.getWorldSizeRatio();
		float dipRatioHeight = 74* AppSettings.getWorldSizeRatio();
		float dipPadding = 5.0f * AppSettings.getWorldSizeRatio();

		
		// #######################################
		
		
		tableMenu.add(conectarButton).size(dipRatioWidth, dipRatioHeight).pad(dipPadding);
		tableMenu.row();
		tableMenu.add(musicOn).size(dipRatioWidth, dipRatioHeight).pad(dipPadding);
		tableMenu.row();
		tableMenu.add(effectOn).size(dipRatioWidth, dipRatioHeight).pad(dipPadding);
		tableMenu.row();
		getStage().addActor(tableMenu);
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
		
	}

	@Override
	public void keyBackPressed() {
		super.keyBackPressed();
		Gdx.app.exit();		
    }

	@Override
	public void setUpInfoPanel() {
		
		float dipRatioWidth = 174 * AppSettings.getWorldSizeRatio();
		float dipRatioHeight = 74 * AppSettings.getWorldSizeRatio();
		
		volverButton = MenuCreator.createCustomGameButton(null,
				Assets.volverNO, Assets.volverSI, dipRatioWidth, dipRatioHeight ,true);
		
		volverButton.setPosition(AppSettings.SCREEN_W - volverButton.getWidth(), AppSettings.SCREEN_H-volverButton.getHeight());
		volverButton.addListener(new ActorGestureListener() {
			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);
				
				getGame().setScreen(new MainMenuScreen(getGame(), "MainMenu"));
			}
		});
		
		getStage().addActor(volverButton);
	}	
	
}
