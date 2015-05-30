package com.digitalwolf.screenhelpers;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.digitalwolf.assets.Assets;
import com.digitalwolf.gamedata.GameData;
import com.digitalwolf.screens.CongratsScreen;
import com.digitalwolf.screens.GameScreen;
import com.moribitotech.mtx.ButtonGame;
import com.moribitotech.mtx.MenuCreator;
import com.moribitotech.mtx.models.base.TableModel;
import com.moribitotech.mtx.settings.AppSettings;

public class GameScreenLevelEndMenu extends GameScreenAbstractMenu {

	private TableModel levelCompletedMenuTable;
	private ButtonGame infoButton, messageButton, okButton;
	private ButtonGame creditsBar;

	float dipRatioWidth = 80 * AppSettings.getWorldSizeRatio();
	float dipRatioHeight = 80 * AppSettings.getWorldSizeRatio();
	float padding = 5.0f * AppSettings.getWorldSizeRatio();

	@Override
	public void setUpMenu(final GameScreen gameScreen) {
		// Set Up means create and add the required Actors/UI Widgets to the
		// Screen
		levelCompletedMenuTable = new TableModel(Assets.table_menu,
				600 * AppSettings.getWorldPositionXRatio(),
				2 * AppSettings.WORLD_HEIGHT / 3);
		levelCompletedMenuTable.setOrigin(
				levelCompletedMenuTable.getWidth() / 2,
				levelCompletedMenuTable.getHeight() / 2);
		levelCompletedMenuTable.setPosition(
				200 * AppSettings.getWorldPositionXRatio(),
				-levelCompletedMenuTable.getHeight());

		gameScreen.getStage().addActor(levelCompletedMenuTable);

		infoButton = MenuCreator.createCustomGameButton(Assets.bigFont,
				Assets.tooltip, Assets.tooltip, dipRatioWidth * 5.5f,
				dipRatioHeight, true);

		infoButton.setTextPosXY(30 * AppSettings.getWorldSizeRatio(),
				60 * AppSettings.getWorldSizeRatio());

		messageButton = MenuCreator.createCustomGameButton(Assets.smallFont,
				Assets.transparent, Assets.transparent, dipRatioWidth * 5.5f,
				dipRatioHeight, true);
		messageButton.setOrigin(messageButton.getWidth() / 2,
				messageButton.getHeight() / 2);
		messageButton.setTextPosXY(30 * AppSettings.getWorldPositionXRatio(),
				60 * AppSettings.getWorldPositionYRatio());
		messageButton.setOrigin(0, 0);

		creditsBar = MenuCreator.createCustomGameButton(Assets.smallFont,
				Assets.health_bar, Assets.health_bar, dipRatioWidth * 5.0f,
				dipRatioHeight / 3, true);

		okButton = MenuCreator.createCustomGameButton(null,
				Assets.right_button, Assets.right_button);
		okButton.addListener(new ActorGestureListener() {
			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				super.touchUp(event, x, y, pointer, button);

				if (GameScreen.currentlevel <= 7) {
					if (GameScreen.currentlevel == 0) {
						GameScreen.currentlevel = 2;
					} else {
						GameScreen.currentlevel++;
					}
					GameData.addToUnLockedLevel(GameScreen.currentlevel);
					sendAwayMenu(gameScreen);
					GameScreen.state = GameScreen.GAME_READY;
					gameScreen.resetGame();
				}

				else {
					gameScreen.getGame().setScreen(
							new CongratsScreen(gameScreen.getGame(),
									"Congrats Screen"));
				}

			}
		});

		levelCompletedMenuTable.add(infoButton)
				.size(infoButton.getWidth(), infoButton.getHeight())
				.pad(padding);
		levelCompletedMenuTable.row();

		levelCompletedMenuTable.add(messageButton)
				.size(messageButton.getWidth(), messageButton.getHeight())
				.pad(padding);
		levelCompletedMenuTable.row();

		levelCompletedMenuTable.add(creditsBar)
				.size(creditsBar.getWidth(), creditsBar.getHeight())
				.pad(padding);
		levelCompletedMenuTable.row();

		levelCompletedMenuTable.add(okButton)
				.size(dipRatioWidth, dipRatioHeight).pad(padding)
				.align(Align.center);
	}

	@Override
	public void sendInMenu(GameScreen gameScreen) {
		infoButton.setText("Level " + GameScreen.currentlevel + " Completed",
				true);
		messageButton.setText("" + GameScreen.scoreString, true);

		creditsBar.setWidth((GameScreen.creditsPoint * 4)
				* AppSettings.getWorldPositionXRatio());
		// creditsBar.setTextPosXY(creditsBar.getWidth()+40*AppSettings.getWorldPositionXRatio(),
		// 30);

		creditsBar.setTextPosXY(0, -10);
		creditsBar.setText(GameScreen.creditsPoint + " %", true);

		levelCompletedMenuTable.addAction(Actions.moveTo(
				200 * AppSettings.getWorldPositionXRatio(),
				100 * AppSettings.getWorldPositionXRatio(), 1.5f));

	}

	@Override
	public void sendAwayMenu(GameScreen gameScreen) {
		levelCompletedMenuTable.addAction(Actions.moveTo(
				200 * AppSettings.getWorldPositionXRatio(),
				-levelCompletedMenuTable.getHeight(), 0.5f));

	}

}
