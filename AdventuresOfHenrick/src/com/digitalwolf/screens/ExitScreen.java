package com.digitalwolf.screens;



import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.digitalwolf.assets.Assets;
import com.moribitotech.mtx.AbstractScreen;
import com.moribitotech.mtx.ButtonGame;
import com.moribitotech.mtx.IScreen;
import com.moribitotech.mtx.MenuCreator;
import com.moribitotech.mtx.models.base.EmptyAbstractActor;
import com.moribitotech.mtx.models.base.EmptyAbstractActorLight;
import com.moribitotech.mtx.models.base.TableModel;
import com.moribitotech.mtx.settings.AppSettings;


public class ExitScreen extends AbstractScreen implements IScreen{

	EmptyAbstractActor testActor;
	ButtonGame resumeButton, quitButton, mainMenuButton ;
	EmptyAbstractActorLight logo;
	Dialog exitDialog;
	
	public ExitScreen(Game game, String screenName) {
		super(game, screenName);
		//
		setUpScreenElements();
		

		setUpMenu();
	}

	@Override
	public void setUpScreenElements() {
		setBackgroundTexture(Assets.menu);
		setBackButtonActive(true);
		
	}



	

	@Override
	public void setUpMenu() {
		
		// // #######################################

		TableModel tableMenu = new TableModel(Assets.ventanaconfirmacion, 780 , 480);
		
		tableMenu.setPosition(-999, 0);
		
	//	tableMenu.setPosition(5050, 150);
		
		tableMenu.addAction(Actions.moveTo(0 , 0, 0.5f));

		
		// #######################################

		
		

		// #########################################
	
		

			
		resumeButton = MenuCreator.createCustomGameButton(null,
				Assets.continuarNO, Assets.continuarSI);
		
		
		resumeButton.addListener(new ActorGestureListener() {
			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);
				
				getGame().setScreen(new MainMenuScreen(getGame(), "MainMenuScreen"));
			}
		});
		
		
		quitButton = MenuCreator.createCustomGameButton(null,
				Assets.salirNO, Assets.salirSI);
	
		
		quitButton.addListener(new ActorGestureListener() {
			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);
				
				Gdx.app.exit();
			}
		});
		

		
		mainMenuButton = MenuCreator.createCustomGameButton(null,
				Assets.cruzno, Assets.cruzsi);
		
		
		mainMenuButton.addListener(new ActorGestureListener() {
			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);
				
				getGame().setScreen(new MainMenuScreen(getGame(), "MainMenuScreen"));
			}
		});
		
		
		
		
		// #########################################
		
	
		float dipRatioWidth = 170 * AppSettings.getWorldSizeRatio();
		float dipRatioHeight = 70* AppSettings.getWorldSizeRatio();
		//float dipPadding = 1.0f * AppSettings.getWorldSizeRatio();
		
		float padding = 45.0f * AppSettings.getWorldSizeRatio();
		
		// #######################################
		
		
		tableMenu.add(resumeButton).padRight(padding*3).size(dipRatioWidth, dipRatioHeight).padTop(317);
		tableMenu.row();
		tableMenu.add(quitButton).padRight(padding*7).size(dipRatioWidth, dipRatioHeight);
		tableMenu.row();
		tableMenu.add(mainMenuButton).padLeft(padding*18).size(42,48);
		
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
		// TODO Auto-generated method stub
		
	}
		
		
		
	
}

