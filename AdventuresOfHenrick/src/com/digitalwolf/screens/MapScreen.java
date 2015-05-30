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
import com.moribitotech.mtx.models.base.EmptyAbstractActor;
import com.moribitotech.mtx.models.base.EmptyAbstractActorLight;
import com.moribitotech.mtx.models.base.TableModel;
import com.moribitotech.mtx.settings.AppSettings;

public class MapScreen extends AbstractScreen implements IScreen {

	EmptyAbstractActor testActor;
	ButtonGame castilloButton, cementerioButton, volverButton,comenzar;

	public MapScreen(Game game, String screenName) {
		super(game, screenName);

		setUpLevelsScreen();
		setUpScreenElements();
	}

	private void setUpLevelsScreen() {

		setBackButtonActive(true);

		setUpMusic();
	}

	/**
	 * Arranca al musica.
	 */
	private void setUpMusic() {
		// Start Playing the Music if the sound is enabled
		if (GameData.getSoundEnabled()) {
			Assets.musicMenus.play();
		}
	}

	@Override
	public void setUpScreenElements() {

		setBackgroundTexture(Assets.situacion);
		castilloButton = MenuCreator.createCustomGameButton(null,
				Assets.castillo, Assets.castilloluz, 261, 445, true); // 405,
																		// 466

		castilloButton.setPosition(120, 90); // 56
		castilloButton.addListener(new ActorGestureListener() {
			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);

				getGame().setScreen(new StoryScreen(getGame(), "StoryScreen"));

				stopMusic();
			}
		});

		getStage().addActor(castilloButton);

		cementerioButton = MenuCreator.createCustomGameButton(null,
				Assets.cementerio, Assets.cementerioluz, 367, 292, true);// 459,
																			// 352

		cementerioButton.setPosition(338, 9); // 320,-25
		cementerioButton.addListener(new ActorGestureListener() {
			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);

				getGame().setScreen(
						new LevelSelectScreen(getGame(), "Level Select"));
			}

		});

		getStage().addActor(cementerioButton);

		float dipRatioWidth = 174 * AppSettings.getWorldSizeRatio();
		float dipRatioHeight = 74 * AppSettings.getWorldSizeRatio();

		
		
		TableModel tableMenu = new TableModel(null, 780, 740);
		
		tableMenu.setPosition(AppSettings.WORLD_WIDTH + tableMenu.getWidth(),
				-AppSettings.getWorldPositionYRatio());
		
		
		tableMenu.addAction(Actions.moveTo(0 , 0, 0.5f));
		
		
		
		
		
		comenzar = MenuCreator.createCustomGameButton(null,
				Assets.comenzarNO, Assets.comenzarSI);
		
		
		comenzar.addListener(new ActorGestureListener() {
			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);
				
				getGame().setScreen(new LevelSelectScreen(getGame(), "LevelSelectScreen"));
				
				stopMusic();
			}

			
		});
		
		
	//	getStage().addActor(comenzar);
		
		
		
		
		volverButton = MenuCreator.createCustomGameButton(null,
				Assets.volverNO, Assets.volverSI, dipRatioWidth,
				dipRatioHeight, true);

		volverButton.setPosition(
				AppSettings.SCREEN_W - volverButton.getWidth(),
				AppSettings.SCREEN_H - volverButton.getHeight());
		volverButton.addListener(new ActorGestureListener() {
			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);

				getGame().setScreen(new MainMenuScreen(getGame(), "MainMenu"));

				stopMusic();

			}
		});

		//getStage().addActor(volverButton);
	
		
		float padding = 45.0f * AppSettings.getWorldSizeRatio();
		//float padding = 9.0f * AppSettings.getWorldSizeRatio();
	
	tableMenu.add(comenzar).padLeft(padding*16).size(116,54);
	tableMenu.row();
	tableMenu.add(volverButton).padLeft(padding*16).size(116,54).padTop(30);
	
	
	getStage().addActor(tableMenu);

	}
	
	
	@Override
	public void setUpMenu() {
		// TODO Auto-generated method stub

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
		// PARA LA MUSICA QUE NOS VAMOS A OTRA SCREEN
		if (GameData.getSoundEnabled()) {
			Assets.musicMenus.stop();
		}
	}
}
