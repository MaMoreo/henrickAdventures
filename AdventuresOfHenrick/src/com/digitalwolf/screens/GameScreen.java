package com.digitalwolf.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.digitalwolf.assets.Assets;
import com.digitalwolf.creatures.Henrick.Estado;
import com.digitalwolf.gamedata.EggData;
import com.digitalwolf.gamedata.GameData;
import com.digitalwolf.gamedata.GemData;
import com.digitalwolf.screenhelpers.GameScreenGameOverMenu;
import com.digitalwolf.screenhelpers.GameScreenGamePauseMenu;
import com.digitalwolf.screenhelpers.GameScreenGameReadyMenu;
import com.digitalwolf.screenhelpers.GameScreenLevelEndMenu;
import com.digitalwolf.world.World;
import com.digitalwolf.world.WorldRenderer;
import com.moribitotech.mtx.AbstractScreen;
import com.moribitotech.mtx.IScreen;
import com.moribitotech.mtx.models.base.EmptyAbstractActorLight;
import com.moribitotech.mtx.settings.AppSettings;

public class GameScreen extends AbstractScreen implements IScreen {

	// THREE ACTORS ONLY FOR DEMONSTRATION
	private BitmapFont gameFont;

	// DEFINITION OF SCREEN HELPERS THAT HELP CREATE MENU FOR VARIOUS GAME
	// STATES
	public GameScreenGameReadyMenu gameScreenGameReadyMenu;
	public GameScreenGamePauseMenu gameScreenGamePauseMenu;
	public GameScreenGameOverMenu gameScreenGameOverMenu;
	public GameScreenLevelEndMenu gameScreenLevelEndMenu;
	EmptyAbstractActorLight healthBar;

	private OrthographicCamera camera;

	// DEFINING THE VARIOUS STATES OF THE GAME
	public static final int GAME_READY = 0;
	public static final int GAME_RUNNING = 1;
	public static final int GAME_PAUSED = 2;
	public static final int GAME_LEVEL_END = 3;
	public static final int GAME_OVER = 4;
	public static int state;

	public static int lastScore;
	public static String gameoverinfo;
	public static String scoreString;
	public static int currentlevel = 1;

	// CREATE AN INSTANCE OF WORLD AND WORLD RENDERER
	World world;
	WorldListener worldListener;
	WorldRenderer renderer;

	// KEEP A MODE FOR TESTING
	public static boolean DEBUG_MODE = false;

	public static int creditsPoint;

	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	private boolean jump;
	private boolean buttonPressed;

	public GameScreen(Game game, String screenName) {
		super(game, screenName);

		setUpTheWorld();
		/*
		 * gameFont = new BitmapFont(Gdx.files.internal("data/gameFont.fnt"),
		 * Gdx.files.internal("data/gameFont.png"), false);
		 */
		gameFont = new BitmapFont(Gdx.files.internal("data/tipoletra.fnt"),
				Gdx.files.internal("data/tipoletra.png"), false);

		state = GAME_READY;
		setUpScreenElements();
		setUpInfoPanel();
		setUpMenu();
		setUpMusic();

		// CREATE AN ORTHOGRAPHIC CAMERA THAT SHOWS US 30X20 UNITS OF THE WORLD
		// IN THIS FRAMEWORK 1 WORLD UNIT = 16 SCREEN PIXELS
		worldListener = new WorldListener(GameData.getSoundEnabled2());

		camera = new OrthographicCamera(AppSettings.SCREEN_W,
				AppSettings.SCREEN_H);
		camera.setToOrtho(false, 30, 20); // 30, 20
		camera.update();
		// movemos la camara un poco hacia arriba para que no se vea
		// tanta tierra
		camera.translate(0, 5);

		// Called once the player completes a Level
		resetGame();
	}

	public void resetGame() {
		// The game is reset each time the game is over
		lastScore = World.score;

		// ###########################
		if (!DEBUG_MODE) {
			if (state == GAME_READY)
				gameScreenGameReadyMenu.sendInMenu(GameScreen.this);
		}

		creditsPoint = 0;
	}

	public void setUpTheWorld() {
		world = new World(worldListener);
		renderer = new WorldRenderer(world);
	}

	@Override
	public void setUpScreenElements() {
		// TODO Auto-generated method stub
		// setBackgroundTexture(Assets.bg); //fondo juego cambiado
		setBackgroundTexture(Assets.fondojuego);

		if (!DEBUG_MODE) {
			gameScreenGameReadyMenu = new GameScreenGameReadyMenu();
			gameScreenGamePauseMenu = new GameScreenGamePauseMenu();
			gameScreenGameOverMenu = new GameScreenGameOverMenu();
			gameScreenLevelEndMenu = new GameScreenLevelEndMenu();
		}

		/*
		 * healthBar = new EmptyAbstractActorLight( 500 *
		 * AppSettings.getWorldPositionXRatio(), 18, true);
		 * healthBar.setPosition( 140 * AppSettings.getWorldPositionXRatio(),
		 * AppSettings.SCREEN_H - 25 AppSettings.getWorldPositionYRatio());
		 * healthBar.setTextureRegion(Assets.transparent, true);
		 */

	}

	/**
	 * Arranca la musica para esta fase;
	 */
	public void setUpMusic() {
		// Start Playing the Music if the sound is enabled
		if (GameData.getSoundEnabled()) {
			Assets.musicJuegoSuperficie.play();
		}

	}

	/**
	 * Detiene la musica en esta fase;
	 */
	private void stopMusic() {
		// Start Playing the Music if the sound is enabled
		if (GameData.getSoundEnabled()) {
			Assets.musicJuegoSuperficie.stop();
		}

	}

	@Override
	public void setUpInfoPanel() {

	}

	@Override
	public void setUpMenu() {

		// SET UP ALL THE SCREEN HELPERS HERE
		if (!DEBUG_MODE) {
			gameScreenGameReadyMenu.setUpMenu(this);
			gameScreenGameOverMenu.setUpMenu(this);
			gameScreenGamePauseMenu.setUpMenu(this);
			gameScreenLevelEndMenu.setUpMenu(this);
		}
	}

	@Override
	public void render(float delta) {
		super.render(delta);

		/************* VERY IMPORTANT ***********************************************************************/
		// SET THE VIEW OF THE WORLD RENDERER AS PER MY CAMERA DEFINED HERE
		// SOcam
		// THAT IT CAN MAP TO WORLD UNITS
		renderer.renderer.setView(camera);

		// BASE THE HORIZONTAL MOVEMENT OF THE CAMERA ON THE PLAYER MOVEMENT
		camera.position.x = world.henrick.position.x;

		// DON'T LET THE CAMERA SHOW PLACES WHERE THERE IS NO MAP
		if (camera.position.x < World.WORLD_WIDTH / 2) {
			camera.position.x = World.WORLD_WIDTH / 2;
		} else if (camera.position.x > World.mapWidth - World.WORLD_WIDTH / 2) {
			camera.position.x = World.mapWidth - World.WORLD_WIDTH / 2;
		}

		// UPDATE THE CAMERA TO REFLECT ALL THE CHANGES
		camera.update();

		// UPDATE THE GAMESCREEN ACCORDING TO THE CURRENT GAME STATE
		update(delta);

		// THE SEQUENCE MATTERS.. IF I DRAW ALL THESE AFTER SWITCH STATES , THE
		// GAME SHALL BE VISIBLE ONLY WHEN THE GAME
		// IS RUNNING AND NOT IN STATES LIKE LEVEL COMPLETED, PAUSE , READY AND
		// GAMEOVER

		// RENDER THE GAME SPRITES & THE LEVEL MAP LAYER BY LAYER
		int[] prevlayers;
		if (currentlevel == 0)
			prevlayers = new int[] { 0 }; // Henrick
		else
			prevlayers = new int[] { 0, 1 }; // Pumma
		renderer.render(prevlayers);
		renderer.renderKey(delta);
		renderer.renderDoor(delta);
		renderer.renderSprings(delta);
		renderer.renderGems(delta);
		// renderer.renderEggs(delta);
		renderer.renderTeeth(delta);
		renderer.renderFlightBottle(delta);
		renderer.renderLifetBottle(delta);

		renderer.renderSnakes(delta);
		renderer.renderDragons(delta);
		renderer.renderPlayer(delta);

		//para que pinte las capas (layers) del mapa
		if (currentlevel == 0)
			renderer.render(new int[] { 1, 2, 3 }); // Henrick
		else
			renderer.render(new int[] { 2 }); // Pumma

		// UPDATE THE GAMESCREEN ACCORDING TO THE CURRENT GAME STATE

		// THIS METHOD IS CALLED IN RENDER() LOOP SO THAT IT CAN CONTINUOSLY
		// CHECK THE
		// GAME STATES AND CALL A PARTICULAR RENDERSTATE() TO DRAW THINGS
		// ACCORDINGLY
		/******************************************************************************/

		// IMPLEMENT DIFFERENT UPDATE AND PRESENT METHODS FOR VARIOUS GAME
		// STATES
		getStage().getSpriteBatch().begin();
		switch (state) {

		case GAME_READY:
			renderReady();
			break;

		case GAME_RUNNING:
			renderRunning();
			break;

		case GAME_PAUSED:
			renderPaused();
			break;

		case GAME_LEVEL_END:
			renderLevelEnd();
			break;

		case GAME_OVER:
			renderGameOver();
			break;
		}

		if (DEBUG_MODE) {
			gameFont.draw(getStage().getSpriteBatch(), "DEBUGGING MODE: ON",
					300, 50);
		}

		getStage().getSpriteBatch().end();

		// Muevo la cámara si estoy pulsando las teclas apropiadas.
		if (Gdx.input.isKeyPressed(Input.Keys.W)) {
			camera.translate(0, 1);

		} else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
			camera.translate(0, -1);
		}

		if (Gdx.input.isKeyPressed(Input.Keys.A)) {
			camera.translate(-10, 0);
		} else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
			camera.translate(10, 0);
		}

	}

	private void update(float delta) {
		// TODO Auto-generated method stub

		switch (state) {
		case GAME_READY:
			updateReady();
			break;
		case GAME_RUNNING:
			updateRunning(delta);
			break;
		case GAME_PAUSED:
			updatePaused();
			break;
		case GAME_LEVEL_END:
			updateLevelEnd();
			break;
		case GAME_OVER:
			updateGameOver();
			break;
		}
	}

	private void updateGameOver() {
		// TODO Auto-generated method stub
		if (DEBUG_MODE) {

			if (Gdx.input.justTouched()) {
				Gdx.app.log("A HIT", "GAME WENT FROM GAMEOVER TO MAINMENU");
				getGame().setScreen(
						new MainMenuScreen(getGame(), "MainMenuScreen"));
				setUpMusic();
			}
		}
	}

	private void updateLevelEnd() {
		// TODO Auto-generated method stub
		if (DEBUG_MODE) {
			if (Gdx.input.justTouched()) {
				Gdx.app.log("A HIT", "GAME WENT FROM LEVEL TO LEVEL");
				if (currentlevel == 0) {
					currentlevel = 2;
				} else {
					currentlevel++;
				}
				GameData.addToUnLockedLevel(GameScreen.currentlevel);

				world = new World(worldListener);
				renderer = new WorldRenderer(world);
				World.score = lastScore;
				state = GAME_READY;
				resetGame();
			}
		}
	}

	private void updatePaused() {
		// TODO Auto-generated method stub
		if (DEBUG_MODE) {
			if (Gdx.input.justTouched()) {
				Gdx.app.log("A HIT", "GAME WENT TO PAUSE STATE");
				state = GAME_RUNNING;
				return;
			}
		}
	}

	private void updateRunning(float delta) {
		lastScore = World.score;
		currentlevel = World.levelID;
		scoreString = "" + lastScore;

		if (world.state == World.WORLD_STATE_GAME_OVER) {
			saveGameStates();
			lastScore = World.score = 0;
			if (!DEBUG_MODE) {
				stopMusic();
				gameScreenGameOverMenu.sendInMenu(this);
			}
			state = GAME_OVER;
		}

		if (world.state == World.WORLD_STATE_NEXT_LEVEL) {

			creditsPoint = ((world.eggsPummaHave * 50)
					/ EggData.getEggPosition(currentlevel).length + ((world.gemsPummaHave * 50) / GemData
					.getGemPosition(currentlevel).length));

			if (!DEBUG_MODE) {
				gameScreenLevelEndMenu.sendInMenu(this);
			}
			state = GAME_LEVEL_END;
			world.listener.success();
		}

		// UPDATE THE PLAYER FOR USER INPUT
		updatePlayerForUserInput(delta);

		// UPDATE THE WORLD
		world.update(delta);
	}

	/**
	 * Actualiza el Sprite del jugador con la entrada del usuario.
	 * 
	 * @param delta
	 */
	private void updatePlayerForUserInput(float delta) {

		left = false;
		right = false;
		up = false;
		down = false;

		jump = false;
		buttonPressed = false;
		boolean pause = false;

		// solo para la version Android
		// Mike: // if (Gdx.app.getType() == ApplicationType.Android
		// || Gdx.app.getType() == ApplicationType.iOS) {

		for (int i = 0; i < 2; i++) {
			int x = (int) (Gdx.input.getX(i) / (float) Gdx.graphics.getWidth() * AppSettings.SCREEN_W);
			int y = (int) (Gdx.input.getY(i) / (float) Gdx.graphics.getWidth() * AppSettings.SCREEN_W);
			if (!Gdx.input.isTouched(i))
				continue;

			if (y >= 400 && y <= 440) {
				if (x >= 20 && x <= 50) {
					left |= true;
				}
				if (x >= 90 && x <= 115) {
					right |= true;
				}
			} else {

				if ((x > 50 && x < 90) && (y >= 370 && y <= 400)) {
					up |= true;
				}
				if ((x > 50 && x < 90) && (y > 440 && y <= 470)) {
					down |= true;
				}
			}
			// boton salto
			if (y <= AppSettings.SCREEN_H && y >= AppSettings.SCREEN_H - 90) {
				if (x >= AppSettings.SCREEN_W - 90 && x < AppSettings.SCREEN_W) {
					jump |= true;
				}
			}

			// boton vampiro
			if (y <= AppSettings.SCREEN_H && y >= AppSettings.SCREEN_H - 90) {
				if (x >= AppSettings.SCREEN_W - 180
						&& x < AppSettings.SCREEN_W - 90) {
					buttonPressed |= true; // el boton esta pulsado

					if (!world.henrick.isTransformandose()
							&& world.henrick.estadoHenrick != Estado.E_VAMPIRIZED) {
						if (world.henrick.getNivelVuelo()/* getPocima() */> 0) {
							// world.henrick.setPocima(world.henrick.getPocima()
							// - 1);

							world.henrick.setTransformandose(true);
							world.henrick.estadoHenrick = Estado.E_VAMPIRIZED;
							world.henrick.grounded = false;
						}
					} else if (!world.henrick.isTransformandose()
							&& world.henrick.estadoHenrick == Estado.E_VAMPIRIZED) {
						world.henrick.setTransformandose(true);
						world.henrick.estadoHenrick = Estado.E_STILL;
						world.henrick.grounded = true;
					}

				}
			}

			if (x >= AppSettings.SCREEN_W - 64 && y >= 0 && y <= 70) {
				pause |= true;
			}
		}

		// CHECK USER INPUT AND APPLY TO VELOCITY AND STATES OF THE MAIN PLAYER
		if ((Gdx.input.isKeyPressed(Keys.SPACE) && world.henrick.grounded)
				|| (jump && world.henrick.grounded)) {
			world.henrick.velocity.y += world.henrick.JUMP_VELOCITY;
			world.henrick.estadoHenrick = Estado.E_JUMP;
			world.henrick.grounded = false;
			world.listener.jump();
		}

		// tecla vampiro
		if (Gdx.input.isKeyPressed(Keys.V)) {
			/*
			 * world.henrick.vampirized = !world.henrick.vampirized; if
			 * (world.henrick.vampirized) { world.henrick.estadoHenrick =
			 * Estado.E_VAMPIRIZED; world.henrick.grounded = false; }
			 */

			if (world.henrick.estadoHenrick != Estado.E_VAMPIRIZED) {
				world.henrick.estadoHenrick = Estado.E_VAMPIRIZED;
				// world.henrick.pocima = false;
				world.henrick.grounded = false;
			} /*
			 * else if (world.henrick.estadoHenrick == Estado.E_VAMPIRIZED) {
			 * world.henrick.estadoHenrick = Estado.E_STILL;
			 * //world.henrick.vampirized = false; world.henrick.grounded =
			 * true; }
			 */
		}

		if (Gdx.input.isKeyPressed(Keys.H)) {

			if (world.henrick.estadoHenrick == Estado.E_VAMPIRIZED) {
				world.henrick.estadoHenrick = Estado.E_STILL;
				// world.henrick.vampirized = false;
				world.henrick.grounded = true;
			}
		}

		if (Gdx.input.isKeyPressed(Keys.D)) {

			world.teethHenrickhas = 0;
			world.henrick.setNivelVuelo(6);
			// world.flightBottleHenrickhas = 0;
			world.lifeBottleHenrickHas = 0;
			world.henrick.setHeartsHenrickHas(3);
			world.henrick.setPocima(1);
			world.listener.walk();
		}

		if (Gdx.input.isKeyPressed(Keys.LEFT) || left) {
			world.henrick.velocity.x = -world.henrick.MAX_VELOCITY;
			if (world.henrick.grounded)
				world.henrick.estadoHenrick = Estado.E_WALK;
			world.henrick.facesRight = false;
			world.listener.walk();
		}

		if (Gdx.input.isKeyPressed(Keys.RIGHT) || right) {
			world.henrick.velocity.x = world.henrick.MAX_VELOCITY;
			if (world.henrick.grounded)
				world.henrick.estadoHenrick = Estado.E_WALK;
			world.henrick.facesRight = true;
			world.listener.walk();

		}

		if (Gdx.input.isKeyPressed(Keys.P) || pause) {
			state = GAME_PAUSED;

			if (!DEBUG_MODE) {
				gameScreenGamePauseMenu.sendInMenu(this);
			}
		}

	}

	private void updateReady() {
		// TODO Auto-generated method stub
		if (DEBUG_MODE) {
			if (Gdx.input.justTouched()) {
				Gdx.app.log("A HIT", "GAME WENT FROM READY TO RUNNING STATE");
				state = GAME_RUNNING;
				return;
			}
		}
	}

	private void renderGameOver() {
		// TODO Auto-generated method stub
		if (DEBUG_MODE) {
			gameFont.draw(getStage().getSpriteBatch(), " " + gameoverinfo,
					AppSettings.SCREEN_W / 3, AppSettings.SCREEN_H / 2 + 80);
			getStage().getSpriteBatch().draw(Assets.logo,
					AppSettings.SCREEN_W / 3, AppSettings.SCREEN_H / 2);
		}
	}

	private void renderLevelEnd() {
		// TODO Auto-generated method stub
		if (DEBUG_MODE) {
			gameFont.draw(getStage().getSpriteBatch(), "Level " + currentlevel
					+ " Completed", AppSettings.SCREEN_W / 3,
					AppSettings.SCREEN_H / 2 + 80);
			getStage().getSpriteBatch().draw(Assets.logo,
					AppSettings.SCREEN_W / 3, AppSettings.SCREEN_H / 2);
		}
	}

	private void renderPaused() {
		// TODO Auto-generated method stub

		if (DEBUG_MODE) {
			gameFont.draw(getStage().getSpriteBatch(), " TOUCH TO RESUME",
					AppSettings.SCREEN_W / 3, AppSettings.SCREEN_H / 2 + 80);
			getStage().getSpriteBatch().draw(Assets.pummaIcon,
					AppSettings.SCREEN_W / 3, AppSettings.SCREEN_H / 2);
		}
	}

	private void renderRunning() {

		// gameFont.setScale(0.6f);
		gameFont.setScale(1);
		// Score
		/*
		 * gameFont.draw( getStage().getSpriteBatch(), "Score :" + World.score,
		 * 140 * AppSettings.getWorldPositionXRatio(), AppSettings.SCREEN_H - 30
		 * AppSettings.getWorldPositionYRatio());
		 */
		// GEM AND NUMBER OF GEMS COLLECTED
		/*
		 * getStage().getSpriteBatch().draw( Assets.snake_gem, 5,
		 * AppSettings.SCREEN_H - 30 AppSettings.getWorldPositionYRatio(), 73 /
		 * 2.5f * AppSettings.getWorldSizeRatio(), 68 / 2.5f *
		 * AppSettings.getWorldSizeRatio());
		 * gameFont.draw(getStage().getSpriteBatch(), " X " +
		 * world.gemsPummaHave, 30 * AppSettings.getWorldPositionXRatio(),
		 * AppSettings.SCREEN_H - 5);
		 */
		// EGGS AND NUMBER OF EGGS COLLECTED
		/*
		 * getStage().getSpriteBatch().draw( Assets.egg, 5, AppSettings.SCREEN_H
		 * - 60 AppSettings.getWorldPositionYRatio(), 300 / 10 *
		 * AppSettings.getWorldSizeRatio(), 233 / 10 *
		 * AppSettings.getWorldSizeRatio());
		 * gameFont.draw(getStage().getSpriteBatch(), " X " +
		 * world.eggsPummaHave, 30 * AppSettings.getWorldPositionXRatio(),
		 * AppSettings.SCREEN_H - 30);
		 */

		// LA CABEZA DE HENRICK
		getStage().getSpriteBatch().draw(
				Assets.cabezaHenrick,
				35,
				AppSettings.SCREEN_H - 60
						* AppSettings.getWorldPositionYRatio(),
				500 / 10 * AppSettings.getWorldSizeRatio(),
				500 / 10 * AppSettings.getWorldSizeRatio());

		// CORAZONES
		TextureRegion corazones = Assets.corazon;
		;
		switch (world.henrick.getHeartsHenrickHas()) {
		case 1:
			corazones = Assets.corazonC;
			break;
		case 2:
			corazones = Assets.corazonB;
			break;
		case 0:
			corazones = Assets.corazonD;
			break;
		}

		getStage().getSpriteBatch().draw(
				corazones,
				5,
				AppSettings.SCREEN_H - 90
						* AppSettings.getWorldPositionYRatio(),
				1000 / 10 * AppSettings.getWorldSizeRatio(),
				300 / 10 * AppSettings.getWorldSizeRatio());

		// NIVEL DE VIDA
		TextureRegion nivelVida = Assets.corazon;
		;
		switch (world.henrick.getNivelVidaHenrickHas()) {
		case 11:
			nivelVida = Assets.nivelvida11;
			break;
		case 10:
			nivelVida = Assets.nivelvida10;
			break;
		case 9:
			nivelVida = Assets.nivelvida9;
			break;
		case 8:
			nivelVida = Assets.nivelvida8;
			break;
		case 7:
			nivelVida = Assets.nivelvida7;
			break;
		case 6:
			nivelVida = Assets.nivelvida6;
			break;
		case 5:
			nivelVida = Assets.nivelvida5;
			break;
		case 4:
			nivelVida = Assets.nivelvida4;
			break;
		case 3:
			nivelVida = Assets.nivelvida3;
			break;
		case 2:
			nivelVida = Assets.nivelvida2;
			break;
		case 1:
			nivelVida = Assets.nivelvida1;
			break;
		case 0:
			nivelVida = Assets.nivelvida0;
			break;
		}
		getStage().getSpriteBatch().draw(
				nivelVida,
				85,
				AppSettings.SCREEN_H - 60
						* AppSettings.getWorldPositionYRatio(),
				1500 / 10 * AppSettings.getWorldSizeRatio(),
				500 / 10 * AppSettings.getWorldSizeRatio());

		// NIVEL DE VUELO
		Integer nivelVuelo = world.henrick.getNivelVuelo();
		String nVuelo = "nivelvuelo" + nivelVuelo.toString();
		getStage().getSpriteBatch().draw(
				Assets.getSpritesVuelo(nVuelo),
				110,
				AppSettings.SCREEN_H - 90
						* AppSettings.getWorldPositionYRatio(),
				1000 / 10 * AppSettings.getWorldSizeRatio(),
				250 / 10 * AppSettings.getWorldSizeRatio());

		// CAJETINES OBJETOS
		TextureRegion cajetinS = Assets.cajetinVacio;
		if (world.lifeBottleHenrickHas != 0) {
			cajetinS = Assets.cajetinSangre;
		}
		getStage().getSpriteBatch().draw(
				cajetinS,
				AppSettings.SCREEN_W - 360,
				AppSettings.SCREEN_H - 90
						* AppSettings.getWorldPositionYRatio());

		// cajetin vuelo
		TextureRegion cajetinV = Assets.cajetinVacio;
		if (world.henrick.getPocima() != 0) {
			cajetinV = Assets.cajetinVuelo;
		}
		getStage().getSpriteBatch().draw(
				cajetinV,
				AppSettings.SCREEN_W - 400,
				AppSettings.SCREEN_H - 90
						* AppSettings.getWorldPositionYRatio());

		// cajetin colmillos
		TextureRegion cajetinD = Assets.cajetinVacio;
		if (world.teethHenrickhas != 0) {
			cajetinD = Assets.cajetinDientes;
		}
		getStage().getSpriteBatch().draw(
				cajetinD,
				AppSettings.SCREEN_W - 440,
				AppSettings.SCREEN_H - 90
						* AppSettings.getWorldPositionYRatio());

		// puntuacion
		gameFont.draw(getStage().getSpriteBatch(), "00000000",
				AppSettings.SCREEN_W - 440, AppSettings.SCREEN_H - 20);

		// RELOJ DE ARENA
		getStage().getSpriteBatch().draw(
				Assets.reloj,
				AppSettings.SCREEN_W - 120,
				AppSettings.SCREEN_H - 60
						* AppSettings.getWorldPositionYRatio());

		// tiempo del reloj
		gameFont.draw(getStage().getSpriteBatch(), getScreenTime(),// /SECONDS_TIME
																	// + "",
				AppSettings.SCREEN_W - 120, AppSettings.SCREEN_H - 70
						* AppSettings.getWorldPositionYRatio());

		// Display the Health Bar here using Scene2D Actor
		/*
		 * healthBar.setWidth((world.henrick.health / 2.2f)
		 * AppSettings.getWorldPositionXRatio());
		 * healthBar.draw(getStage().getSpriteBatch(), 1.0f);
		 */
		// porcentaje vida Pumma
		/*
		 * gameFont.draw(getStage().getSpriteBatch(), world.henrick.health / 10
		 * + " %", healthBar.getX() + 1.05f * healthBar.getWidth(),
		 * AppSettings.SCREEN_H - 8 * AppSettings.getWorldPositionYRatio());
		 */
		// TO BE DRAWN ONLY AFTER ALL GAME ELEMENTS ARE DRAWN TO AVOID OVERRIDE
		// DRAW THE GAME CONTROL UI ONLY ON ANDROID DEVICES IF THE GAME STATE IS
		// RUNNING

		// Mike: //if ((Gdx.app.getType() == ApplicationType.Android) ||
		// (Gdx.app.getType() == ApplicationType.iOS)){

		/*
		 * getStage().getSpriteBatch().draw(Assets.left_button, 0f, 0f, 0f, 0f,
		 * 90f, 90f, 1f, 1f, 0f);
		 * getStage().getSpriteBatch().draw(Assets.right_button, 130f, 0f, 0f,
		 * 0f, 90f, 90f, 1f, 1f, 0f);
		 */
		// Pinta la cruceta del mando
		if (!left && !right && !up && !down) {
			getStage().getSpriteBatch().draw(Assets.crucetaMandoDefault, -20f,
					-30f, -100f, -100f, 170f, 170f, 1f, 1f, 0f);
		} else if (left) {
			getStage().getSpriteBatch().draw(Assets.crucetaMandoIzquierda,
					-20f, -30f, -100f, -100f, 170f, 170f, 1f, 1f, 0f);
		} else if (right) {
			getStage().getSpriteBatch().draw(Assets.crucetaMandoDerecha, -20f,
					-30f, -100f, -100f, 170f, 170f, 1f, 1f, 0f);
		} else if (up) {
			getStage().getSpriteBatch().draw(Assets.crucetaMandoArriba, -20f,
					-30f, -100f, -100f, 170f, 170f, 1f, 1f, 0f);
		} else if (down) {
			getStage().getSpriteBatch().draw(Assets.crucetaMandoAbajo, -20f,
					-30f, -100f, -100f, 170f, 170f, 1f, 1f, 0f);
		}

		// pinta boton salto cambia de color al pulsarlo
		if (!jump) {
			getStage().getSpriteBatch().draw(Assets.botonNO,
					AppSettings.SCREEN_W - 130, -40f, 0, 0, 180, 180, 1, 1, 0);
		} else if (jump) {
			getStage().getSpriteBatch().draw(Assets.botonSI,
					AppSettings.SCREEN_W - 130, -40f, 0, 0, 180, 180, 1, 1, 0);
			world.listener.jump();
		}

		// pinta el botón de vampiro
		if (!buttonPressed) {
			getStage().getSpriteBatch().draw(Assets.botonNO,
					AppSettings.SCREEN_W - 240, -40f, 0, 0, 180, 180, 1, 1, 0);
		} else {
			getStage().getSpriteBatch().draw(Assets.botonSI,
					AppSettings.SCREEN_W - 240, -40f, 0, 0, 180, 180, 1, 1, 0);
		}

		/*
		 * getStage().getSpriteBatch().draw(Assets.vampire_button,
		 * AppSettings.SCREEN_W - 350, -160, 0, 0, 420, 420, 1, 1, 0);
		 */
		getStage().getSpriteBatch().draw(Assets.transformarNO,
				AppSettings.SCREEN_W - 350, -40, 0, 0, 170, 170, 1, 1, 0);

		// boton pausa
		getStage().getSpriteBatch().draw(Assets.pause_button,
				AppSettings.SCREEN_W - 64, AppSettings.SCREEN_H - 64, 0, 0, 64,
				64, 1, 1, 0);

		// }
	}

	private void renderReady() {
		// TODO Auto-generated method stub
		if (DEBUG_MODE) {
			gameFont.draw(getStage().getSpriteBatch(), " Touch to Begin Level "
					+ currentlevel, AppSettings.SCREEN_W / 3,
					AppSettings.SCREEN_H / 2 + 80);
			getStage().getSpriteBatch().draw(Assets.logo,
					AppSettings.SCREEN_W / 3, AppSettings.SCREEN_H / 2);
		}
	}

	private void saveGameStates() {
		// STATES ARE SAVED IN KEY AND VALUE PAIRS AS PREFERENCES

		// GET THE EXISTING HIGHSCORES FROM PREFERENCES
		int[] scoresfromdb = GameData.getHighScores();

		// CHECK IF THE CURRENT SCORE IS GREATER THAN THE STORED ONE
		if (lastScore > scoresfromdb[4])
			scoreString = "NEW RECORD : " + lastScore;
		else
			scoreString = "SCORE : " + lastScore;

		// ADD THE NEW SCORE TO THE PREFERENCES IN DECREASING ORDER
		GameData.addScore(lastScore);
		GameData.savePefs();
	}

}
