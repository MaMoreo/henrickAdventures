package com.digitalwolf.screenhelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.digitalwolf.assets.Assets;
import com.digitalwolf.gamedata.GameData;
import com.digitalwolf.screens.GameScreen;
import com.digitalwolf.screens.MainMenuScreen;
import com.moribitotech.mtx.ButtonGame;
import com.moribitotech.mtx.MenuCreator;
import com.moribitotech.mtx.models.base.TableModel;
import com.moribitotech.mtx.settings.AppSettings;

public class GameScreenGamePauseMenu extends GameScreenAbstractMenu {

	private TableModel pauseMenuTable;
	private ButtonGame mainMenuButton, resumeButton, quitButton;

	@Override
	public void setUpMenu(final GameScreen gameScreen) {
		// pauseMenuTable = new TableModel(Assets.confirmacioncompleta,
		// AppSettings.WORLD_WIDTH , AppSettings.WORLD_HEIGHT);

		// pauseMenuTable.setPosition(0, AppSettings.WORLD_HEIGHT +
		// pauseMenuTable.getHeight());

		pauseMenuTable = new TableModel(Assets.ventanaconfirmacion, 780, 480);
		pauseMenuTable.setPosition(-999, 0);// Para cambiar direccion entrada
											// hENRICK tabla por la izquierda

		// MAIN MENU BUTTON ON THE RIGHT SIDE
		mainMenuButton = MenuCreator.createCustomGameButton(null,
				Assets.cruzno, Assets.cruzsi);

		mainMenuButton.addListener(new ActorGestureListener() {
			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);

				sendAwayMenu(gameScreen);
				gameScreen.getGame().setScreen(
						new MainMenuScreen(gameScreen.getGame(),
								"MainMenuScreen"));
				
				//PARA LA MUSICA QUE NOS VAMOS A OTRA SCREEN
				if (GameData.getSoundEnabled()) {
					Assets.musicJuegoSuperficie.stop();
					Assets.musicMenus.play();
				}
			}
		});

		resumeButton = MenuCreator.createCustomGameButton(null,
				Assets.continuarNO, Assets.continuarSI);

		resumeButton.addListener(new ActorGestureListener() {
			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);

				sendAwayMenu(gameScreen);
				GameScreen.state = GameScreen.GAME_RUNNING;
			}
		});

		quitButton = MenuCreator.createCustomGameButton(null, Assets.salirNO,
				Assets.salirSI);

		quitButton.addListener(new ActorGestureListener() {
			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);

				Gdx.app.exit();
			}
		});

		// float dipRatioWidth = 174 * AppSettings.getWorldSizeRatio();
		// float dipRatioHeight = 74* AppSettings.getWorldSizeRatio();
		// float dipPadding = 1.0f * AppSettings.getWorldSizeRatio();

		float dipRatioWidth = 170 * AppSettings.getWorldSizeRatio();
		float dipRatioHeight = 70 * AppSettings.getWorldSizeRatio();
		float dipPadding = 1.0f * AppSettings.getWorldSizeRatio();

		float padding = 45.0f * AppSettings.getWorldSizeRatio();

		// #######################################
		// tableMenu.add(shootingActor).size(dipRatioWidth,
		// dipRatioHeight).pad(dipPadding);

		pauseMenuTable.add(resumeButton).padRight(padding * 3)
				.size(dipRatioWidth, dipRatioHeight).padTop(317);
		pauseMenuTable.row();
		pauseMenuTable.add(quitButton).padRight(padding * 7)
				.size(dipRatioWidth, dipRatioHeight);
		pauseMenuTable.row();
		pauseMenuTable.add(mainMenuButton).padLeft(padding * 18).size(42, 48);

	}

	@Override
	public void sendInMenu(GameScreen gameScreen) {
		gameScreen.setBackgroundTexture(Assets.menu); // cambiar al fondo del
														// castillo
		gameScreen.getStage().addActor(pauseMenuTable);
		// pauseMenuTable.addAction(Actions.moveTo(0, AppSettings.WORLD_HEIGHT-
		// pauseMenuTable.getHeight(), 0.5f));
		pauseMenuTable.addAction(Actions.moveTo(0, 0, 0.5f)); // Primero vez
																// aparece
																// Henricks por
																// la izquierda
	}

	@Override
	public void sendAwayMenu(GameScreen gameScreen) {
		// pauseMenuTable.addAction(Actions.moveTo(0 , AppSettings.WORLD_HEIGHT
		// + pauseMenuTable.getHeight(), 0.5f));
		gameScreen.setBackgroundTexture(Assets.fondojuego); // cambiar al fondo
															// juego nubes
		pauseMenuTable.addAction(Actions.moveTo(0, -999, 0.5f)); // Despues
																	// aparece y
																	// desaparece
																	// por abajo
	}

}