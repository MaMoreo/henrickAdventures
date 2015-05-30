package com.digitalwolf.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.digitalwolf.assets.Assets;
import com.digitalwolf.gamedata.GameData;
import com.moribitotech.mtx.AbstractScreen;
import com.moribitotech.mtx.ButtonGame;
import com.moribitotech.mtx.IScreen;
import com.moribitotech.mtx.MenuCreator;
import com.moribitotech.mtx.models.base.EmptyAbstractActor;
import com.moribitotech.mtx.models.base.TableModel;
import com.moribitotech.mtx.settings.AppSettings;

public class StoryScreen extends AbstractScreen implements IScreen {
//	EmptyAbstractActor testActor;
	Dialog exitDialog;
	ButtonGame mainMenuButton,comenzar,volver;
//###########################################3
	private int selectedLevel;
	private int selectedWorld;
	private ButtonGame infoButton;
	 private EmptyAbstractActor world1Actor,world2Actor,world3Actor, world4Actor, testActor;
	 private TableModel worldsTable;
	 ScrollPane scrollPane;
	
	 
	public StoryScreen(Game game, String screenName) {
		super(game, screenName);
		
		setUpScreenElements();
		

		setUpMenu();
		
		
	}
	
	@Override
	public void setUpScreenElements() {
		setBackgroundTexture(Assets.situacion);
		setBackButtonActive(true);
		setUpMusic();
		
	}
	
	
	/**
	 * Arranca la musica.
	 */
	private void setUpMusic() {
		// Start Playing the Music if the sound is enabled
		if (GameData.getSoundEnabled()) {
			Assets.musicHistoria.play();
		}
	}

	@Override
	public void setUpMenu() {
	
		
		TableModel tableMenu = new TableModel(Assets.Fondocuento, 780, 420);
		
		tableMenu.setPosition(-999, 0);	
		
		tableMenu.addAction(Actions.moveTo(0 , 0, 0.5f));
		
		
		
		
		
		
		volver = MenuCreator.createCustomGameButton(null,
				Assets.volverNO, Assets.volverSI);
		
		
		volver.addListener(new ActorGestureListener() {
			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);
				
				getGame().setScreen(new MapScreen(getGame(), "MapScreen"));
				
				stopMusic();
			}
		});
		
		
		
		
		mainMenuButton = MenuCreator.createCustomGameButton(null,
				Assets.cruzno, Assets.cruzsi);
		mainMenuButton.setPosition(AppSettings.SCREEN_W - mainMenuButton.getWidth(), AppSettings.SCREEN_H-mainMenuButton.getHeight());
		
		mainMenuButton.addListener(new ActorGestureListener() {
			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);
				
				getGame().setScreen(new MainMenuScreen(getGame(), "Main Menu Screen"));
				
				stopMusic();
			}
		});
		
		
		float padding = 45.0f * AppSettings.getWorldSizeRatio();
	
		// #######################################
		
		tableMenu.add(volver).padLeft(padding*16).size(116,54).padTop(20);
		tableMenu.row();
		tableMenu.add(mainMenuButton).padLeft(padding*18).size(42,48).padTop(290);
		
		
		getStage().addActor(tableMenu);
	
	//#################################################################3
	
/*	
		testActor = new EmptyAbstractActor(100, 100, true);
		testActor.setPosition(
				100 * AppSettings.getWorldPositionXRatio()
						- testActor.getWidth() / 2.0f,
				60 * AppSettings.getWorldPositionYRatio()
						- testActor.getHeight() / 2.0f);
		getStage().addActor(testActor);		
		testActor.setAnimation(Assets.henrickStill, true, true);*/
        
		
//		infoButton = MenuCreator.createCustomGameButton(Assets.smallFont,
//				Assets.tooltip, Assets.tooltip);				
//		infoButton.setSize(400, 60);
//		infoButton.setText("Select a Level to Play", true);
		
		
	//	world1Actor = new EmptyAbstractActor(450*AppSettings.getWorldPositionXRatio(),200*AppSettings.getWorldPositionYRatio(), true);//false
		world1Actor = new EmptyAbstractActor(2*AppSettings.SCREEN_W/4, 2*AppSettings.SCREEN_H/4, false);//false
			
		world1Actor.setTextureRegion(Assets.viA, true);
		world1Actor.addListener(new ActorGestureListener() {
				@Override
				public void touchUp(InputEvent event, float x, float y,
						int pointer, int button) {
					super.touchUp(event, x, y, pointer, button);
					selectedWorld =1;
		//			infoButton.setText("World 1", true);
				}
			});
		 
	//	world2Actor = new EmptyAbstractActor(450*AppSettings.getWorldPositionXRatio(),200*AppSettings.getWorldPositionYRatio(), false);//false
		world2Actor = new EmptyAbstractActor( 2*AppSettings.SCREEN_W/4, 2*AppSettings.SCREEN_H/4, false);//false
		world2Actor.setTextureRegion(Assets.viB, true);
		
	    world2Actor.addListener(new ActorGestureListener() {
			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);
				selectedWorld =2;
		//		infoButton.setText("World 2 ..coming soon", true);
			}
		});
	    
	    //###########################
	    
		world3Actor = new EmptyAbstractActor( 2*AppSettings.SCREEN_W/4, 2*AppSettings.SCREEN_H/4, false);//false
		world3Actor.setTextureRegion(Assets.opcionesfondo, true);
		
	    world3Actor.addListener(new ActorGestureListener() {
			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);
				selectedWorld =3;
		//		infoButton.setText("World 2 ..coming soon", true);
			}
		});
	    
	    
		world4Actor = new EmptyAbstractActor( 2*AppSettings.SCREEN_W/4, 2*AppSettings.SCREEN_H/4, false);//false
		world4Actor.setTextureRegion(Assets.menu, true);
		
	    world4Actor.addListener(new ActorGestureListener() {
			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);
				selectedWorld =3;
		//		infoButton.setText("World 2 ..coming soon", true);
			}
		});
	    
	    //############################
	    
	    
	//	worldsTable = new TableModel(Assets.transparent, AppSettings.WORLD_WIDTH , AppSettings.WORLD_HEIGHT);
	 
	    worldsTable = new TableModel(Assets.transparent, AppSettings.WORLD_WIDTH , AppSettings.WORLD_HEIGHT);
	 	
		worldsTable.add(world1Actor);
		worldsTable.add(world2Actor);
		worldsTable.add(world3Actor);
		worldsTable.add(world4Actor);
   
		// put the table inside a scrollpane  
        scrollPane = new ScrollPane(worldsTable);  
      //  scrollPane.setBounds(AppSettings.SCREEN_W/2+ 30*AppSettings.getWorldPositionXRatio(), 2*AppSettings.SCREEN_H/3.2f*AppSettings.getWorldPositionYRatio(), 2*AppSettings.SCREEN_W/5, 2*AppSettings.SCREEN_H/5);  
        scrollPane.setBounds(190, 70, 2*AppSettings.SCREEN_W/4, 2*AppSettings.SCREEN_H/4);  
        scrollPane.setPosition(-999, 0);			
        scrollPane.addAction(Actions.moveTo(190 , 70, 0.5f));// poner cantidades igual que setbound
        
     
        
        
         scrollPane.setScrollPercentX(5);     
    //      scrollPane.setScrollPercentY(50);
     
        
        scrollPane.setupOverscroll(16, 4, 10);//50, 30, 200               
         scrollPane.scrollTo(190, 70, 190,70);
         scrollPane.hit(190, 0, false);
        
        scrollPane.setScrollingDisabled(false, true);  //deshabilita el moviento en x,y
        scrollPane.setOverscroll(false, false);  
        scrollPane.invalidate();  
        
   
        
        getStage().addActor(scrollPane);  
         
		
		//END OF WHAT I WANTEDs
	
     //   infoButton.setTextPosXY(10*AppSettings.getWorldPositionXRatio(), 50);
	//	infoButton.setPosition(100*AppSettings.getWorldPositionXRatio(), 100*AppSettings.getWorldPositionYRatio());
	//	getStage().addActor(infoButton);
	
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
		// TODO Auto-generated method stub
		
	}

	private void stopMusic() {
		//PARA LA MUSICA QUE NOS VAMOS A OTRA SCREEN
		if (GameData.getSoundEnabled()) {
			Assets.musicHistoria.stop();
		}
	}
	
	
}
