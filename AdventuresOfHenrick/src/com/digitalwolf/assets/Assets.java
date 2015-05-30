package com.digitalwolf.assets;

/*
 *This is the Assets class. All the graphics (Textures) and Audio are loaded in this class.  
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.digitalwolf.gamedata.GameData;

public class Assets {

	//JUEGO
	private final static String FILE_SPRITE_ATLAS = "data/sprite_sheet.sprites"; //PUMMA
	private final static String FILE_SPRITE_ATLAS_BC = "data/henrick_sprite_sheet.txt";
	private final static String FILE_SPRITE_ATLAS_FINAL01 = "data/sprite_sheet_final.txt";
	private final static String FILE_SPRITE_ATLAS_PAUSE = "data/Sprite_botones_pause.txt";
	
	//CUENTO
	private final static String FILE_SPRITE_ATLAS_MAPA = "data/mapasituacion.txt";
	private final static String FILE_SPRITE_ATLAS_CUENTO = "data/basecuento.txt";
	private final static String FILE_SPRITE_ATLAS_SITUACION = "data/situacionycuento.txt";
	
	private final static String FILE_UI_SKIN = "skin/uiskin.json";

	public static TextureAtlas spriteAtlasBC;
	public static TextureAtlas spriteAtlas;
	public static TextureAtlas spriteAtlasMenu;
	public static TextureAtlas spriteAtlasCabecera;
	public static TextureAtlas spriteAtlasBackGround;
	public static TextureAtlas spriteAtlasPause;
	public static TextureAtlas spriteAtlasHenrickPrueba;
	public static TextureAtlas spriteAtlasFondoJuego;
	public static TextureAtlas spriteAtlasVentanas;
	public static TextureAtlas spriteAtlasMapa;
	public static TextureAtlas spriteAtlasCuento;
	public static TextureAtlas spriteAtlasSituacion;
	public static Skin skin;

	// Defining the Audio Files here
	public static Music musicMenus;
	//public static Music musicMenus;
	public static Music musicJuegoSuperficie;
	public static Music musicHistoria;
	public static Music musicGameOver;
	public static Sound egggrab;
	public static Sound gemgrab;
	public static Sound cry;
	public static Sound ow;
	public static Sound success;
	public static Sound fall;
	public static Sound jump;
	public static Sound walk;
	public static Sound fly;

	// Defining the Texture Regions
	public static TextureRegion left_button;
	public static TextureRegion right_button;
	public static TextureRegion jump_button;
	public static TextureRegion level_button1, level_button2, level_locked,
			level_star;
	public static TextureRegion logo;

	// Mando
	public static TextureRegion crucetaMandoRegion;
	public static TextureRegion crucetaMandoDefault;
	public static TextureRegion crucetaMandoIzquierda;
	public static TextureRegion crucetaMandoDerecha;
	public static TextureRegion crucetaMandoArriba;
	public static TextureRegion crucetaMandoAbajo;

	// /////BASE CUENTOS//////////////////////////////////////
	public static TextureRegion Fondocuento;

	/////////////////SITUACION/////////////////////
	public static TextureRegion situacion;
	public static TextureRegion viAboB;
	public static TextureRegion viBboA;
	public static TextureRegion cementerio;
	public static TextureRegion cementerioluz;
	public static TextureRegion castillo;
	public static TextureRegion viB;
	public static TextureRegion castilloluz;
	public static TextureRegion viBboB;
	public static TextureRegion viAboA;
	public static TextureRegion viA;
	public static TextureRegion oscuridadA;
	public static TextureRegion viAboC;
	public static TextureRegion oscuridadB;
	
	
	// //////////////////////////////////////////////////////

	// /////FONDOS JUEGO//////////////////////////////////////
	public static TextureRegion bg;
	public static TextureRegion bg_completo;
	public static TextureRegion fondojuego;

	// ///////BOTONES MANDO///////////////////////////////////
	public static TextureRegion abajo;
	public static TextureRegion transformarSI;
	public static TextureRegion transformarNO;
	public static TextureRegion derecha;
	public static TextureRegion botonSI;
	public static TextureRegion botonNO;
	public static TextureRegion arriba;
	public static TextureRegion izquierda;
	public static TextureRegion direccion;

	// //////////FONDOS VENTANAS////////////////////////////
	
	public static TextureRegion opcionesfondo;
	public static TextureRegion menu;
	public static TextureRegion ventanaconfirmacion;
	public static TextureRegion fantasmatransparente;

	// //////////////////////////////////////////////////////

	public static TextureRegion henrickStillTR;
	public static TextureRegion henrickJumpTR;
	public static TextureRegion henrickRunTR;
	// public static TextureRegion pumma;
	public static TextureRegion snake;
	public static TextureRegion dragon;
	public static TextureRegion pause_button;
	public static TextureRegion transparent_credit;
	public static TextureRegion transparent;
	public static TextureRegion tooltip;
	public static TextureRegion timer;

	public static TextureRegion button_continue;
	public static TextureRegion button_continue2;
	public static TextureRegion button_exit;
	public static TextureRegion button_exit2;
	public static TextureRegion button_mainmenu;
	public static TextureRegion button_mainmenu2;
	public static TextureRegion button_on;
	public static TextureRegion button_off;
	public static TextureRegion default_button1;
	public static TextureRegion default_button2;
	public static TextureRegion table_menu;

	// ////////////// BOTONES MENU PRINCIPAL & PAUSE//////////////////
	public static TextureRegion confirmacioncompleta;
	public static TextureRegion cruzsi;
	public static TextureRegion cruzno;
	public static TextureRegion jugarSI;
	public static TextureRegion jugarNO;
	public static TextureRegion opcionesSI;
	public static TextureRegion opcionesNO;
	public static TextureRegion continuarSI;
	public static TextureRegion continuarNO;
	public static TextureRegion salirSI;
	public static TextureRegion salirNO;
	public static TextureRegion conectarSI;
	public static TextureRegion conectarNO;

	// //////////////////////////////////////////

	
	// BOTONES MENU OPCIONES///////////////////
	public static TextureRegion musicaSI;
	public static TextureRegion musicaNO;
	public static TextureRegion volverSI;
	public static TextureRegion volverNO;
	public static TextureRegion sonidoSI;
	public static TextureRegion sonidoNO;
	public static TextureRegion comenzarSI;
	public static TextureRegion comenzarNO;

	// /////////////////////////////////////////

	// public static TextureRegion button_credits;
	// public static TextureRegion button_credits2;
	// public static TextureRegion button_highscore;
	// public static TextureRegion button_highscore2;
	// public static TextureRegion startgame_button;
	// public static TextureRegion startgame_button2;

	// //////////////CABECERA/////////////////
	public static TextureRegion cabezaHenrick;
	public static TextureRegion corazon;
	public static TextureRegion corazonB;
	public static TextureRegion corazonC;
	public static TextureRegion corazonD;
	public static TextureRegion nivelvida11, nivelvida10, nivelvida9,
			nivelvida8, nivelvida7, nivelvida6, nivelvida5, nivelvida4,
			nivelvida3, nivelvida2, nivelvida1, nivelvida0;
	public static TextureRegion nivelvuelo6, nivelvuelo5, nivelvuelo4,
			nivelvuelo3, nivelvuelo2, nivelvuelo1, nivelvuelo0;
	public static TextureRegion reloj;
	public static TextureRegion cajetinVacio;
	public static TextureRegion cajetinDientes;
	public static TextureRegion cajetinVuelo;
	public static TextureRegion cajetinSangre;

	// OBJETOS
	public static TextureRegion dientes;
	public static TextureRegion botellaVuelo;
	public static TextureRegion botellaVida;

	public static TextureRegion congrats_screen;
	public static TextureRegion snake_gem;
	public static TextureRegion egg;
	public static TextureRegion key;

	public static TextureRegion health_bar; // eliminar esto?
	public static TextureRegion stone, menubox, snake2;

	public static Animation henrickStill;
	public static Animation henrickWalk;
	public static Animation henrickJump;

	public static TextureRegion snakeIcon;
	public static Animation snakeStill;
	public static Animation snakeMove;

	public static TextureRegion dragonIcon, pummaIcon;
	public static Animation dragonStill;
	public static Animation dragonFlying;

	public static TextureRegion spring1;
	public static TextureRegion spring2;
	public static TextureRegion spring3;
	public static TextureRegion door;

	public static Animation springActive;

	public static BitmapFont smallFont, bigFont, tipoLetra;
	public static TextureRegion world2;

	// vampiro
	public static TextureRegion vampiro;
	public static Animation vampiroFly;
	

	public static Texture loadTexture(String file) {
		return new Texture(Gdx.files.internal(file));
	}

	/**
	 * Devuelve el Sprite Atlas de Burntcity.
	 * 
	 * @return Un Texture Atlas con los dibujos de Burntcity.
	 */
	public static TextureAtlas getSpriteAtlasCuento() {
		if (spriteAtlasCuento == null) {
			spriteAtlasCuento = new TextureAtlas(
					Gdx.files.internal(FILE_SPRITE_ATLAS_CUENTO));
		}
		return spriteAtlasCuento;
	}

	/**
	 * Devuelve el Sprite Atlas de la cabecera de Burntcity.
	 * 
	 * @return Un Texture Atlas con los dibujos de la cabecera.
	 */
	public static TextureAtlas getSpriteAtlasFinal01() {
		if (spriteAtlasCabecera == null) {
			spriteAtlasCabecera = new TextureAtlas(
					Gdx.files.internal(FILE_SPRITE_ATLAS_FINAL01));
		}
		return spriteAtlasCabecera;
	}
	
	public static TextureAtlas getSpriteAtlasSituacion() {
		if (spriteAtlasSituacion == null) {
			spriteAtlasSituacion = new TextureAtlas(
					Gdx.files.internal(FILE_SPRITE_ATLAS_SITUACION));
		}
		return spriteAtlasSituacion;
	}


	public static TextureAtlas getSpriteAtlasMapa() {
		if (spriteAtlasMapa == null) {
			spriteAtlasMapa = new TextureAtlas(
					Gdx.files.internal(FILE_SPRITE_ATLAS_MAPA));
		}
		return spriteAtlasMapa;
	}

	

	public static TextureAtlas getSpriteAtlasBC() {
		if (spriteAtlasBC == null) {
			spriteAtlasBC = new TextureAtlas(
					Gdx.files.internal(FILE_SPRITE_ATLAS_BC));
		}
		return spriteAtlasBC;
	}


	public static TextureAtlas getSpriteAtlasPause() {
		if (spriteAtlasPause == null) {
			spriteAtlasPause = new TextureAtlas(
					Gdx.files.internal(FILE_SPRITE_ATLAS_PAUSE));
		}
		return spriteAtlasPause;
	}
	
	public static TextureAtlas getSpriteAtlas() {
		if (spriteAtlas == null) {
			spriteAtlas = new TextureAtlas(
					Gdx.files.internal(FILE_SPRITE_ATLAS));
		}
		return spriteAtlas;
	}

	public static Skin getSkin() {
		if (skin == null) {
			FileHandle skinFile = Gdx.files.internal(FILE_UI_SKIN);
			skin = new Skin(skinFile);
		}
		return skin;
	}

	public static void loadAll() {
		relaseResources();
		loadImages();
		loadButtons();
		loadFonts();
		loadAnimations();
		// loadSoundsAndMusics();
		loadMusics();
		loadSounds();
	}

	private static void relaseResources() {
		skin = null;
		spriteAtlas = null;
		spriteAtlasBC = null;
		spriteAtlasMenu = null;
		spriteAtlasCabecera = null;
		spriteAtlasBackGround = null;
		spriteAtlasPause = null;
		spriteAtlasFondoJuego = null;
		spriteAtlasVentanas = null;
		spriteAtlasMapa = null;
		spriteAtlasCuento = null;
		spriteAtlasSituacion = null;
	}

	public static void loadImages() {

		// TEXTURE REGIONS FROM THE SPRITE ATLAS
		// bg = getSpriteAtlas().findRegion("bg");
		// BACKGROUND
		// /////FONDOS JUEGO//////////////////////////////////////
		bg = getSpriteAtlasPause().findRegion("fondomenu");
		bg_completo = getSpriteAtlasPause().findRegion("menucompleto");
		fondojuego = getSpriteAtlasFinal01().findRegion("fondojuego");

		// //////////////////////////////////////////////////////////

		tooltip = getSpriteAtlas().findRegion("tooltip");
		timer = getSpriteAtlas().findRegion("timer");
		logo = getSpriteAtlas().findRegion("logo");

		henrickStillTR = getSpriteAtlasBC().findRegion("parado");
		henrickJumpTR = getSpriteAtlasBC().findRegion("salta");
		henrickRunTR = getSpriteAtlasBC().findRegion("corre");
		vampiro = getSpriteAtlasBC().findRegion("vampiro");

		// pumma = getSpriteAtlas().findRegion("pumma_sheet");
		snake = getSpriteAtlas().findRegion("snake");
		key = getSpriteAtlas().findRegion("key");
		dragon = getSpriteAtlas().findRegion("dragon");
		egg = getSpriteAtlas().findRegion("egg");
		door = getSpriteAtlas().findRegion("Door");
		dientes = getSpriteAtlasFinal01().findRegion("dientes");
		botellaVuelo = getSpriteAtlasFinal01().findRegion("botellavuelo");
		botellaVida = getSpriteAtlasFinal01().findRegion("botellavida");

		pause_button = getSpriteAtlasPause().findRegion("cruzno");
		transparent_credit = getSpriteAtlas().findRegion("transparent_credit");
		transparent = getSpriteAtlas().findRegion("transparent");

		// Fair Buttons Created by me at www.cooltext.com
		button_continue = getSpriteAtlas().findRegion("button_continue");
		button_continue2 = getSpriteAtlas().findRegion("button_continue2");

		button_exit = getSpriteAtlas().findRegion("button_exit");
		button_exit2 = getSpriteAtlas().findRegion("button_exit2");

		button_mainmenu = getSpriteAtlas().findRegion("button_mainmenu");
		button_mainmenu2 = getSpriteAtlas().findRegion("button_mainmenu2");
		button_on = getSpriteAtlas().findRegion("button_on");
		button_off = getSpriteAtlas().findRegion("button_off");
		default_button1 = getSpriteAtlas().findRegion("default_button1");
		default_button2 = getSpriteAtlas().findRegion("default_button2");
		table_menu = getSpriteAtlas().findRegion("table_menu");

		// startgame_button = getSpriteAtlas().findRegion("startgame_button");
		// startgame_button2 = getSpriteAtlas().findRegion("startgame_button2");
		// button_highscore = getSpriteAtlas().findRegion("button_highscore");
		// button_highscore2 = getSpriteAtlas().findRegion("button_highscore2");
		// button_credits = getSpriteAtlas().findRegion("button_credits");
		// button_credits2 = getSpriteAtlas().findRegion("button_credits2");

		// //////////////BOTONES MENU PRINCIPAL & PAUSE//////////////////
		confirmacioncompleta = getSpriteAtlasPause().findRegion(
				"confirmacioncompleta");
		cruzsi = getSpriteAtlasPause().findRegion("cruzsi");
		cruzno = getSpriteAtlasPause().findRegion("cruzno");
		jugarSI = getSpriteAtlasPause().findRegion("jugarSI");
		jugarNO = getSpriteAtlasPause().findRegion("jugarNO");
		opcionesSI = getSpriteAtlasPause().findRegion("opcionesSI");
		opcionesNO = getSpriteAtlasPause().findRegion("opcionesNO");
		continuarSI = getSpriteAtlasPause().findRegion("continuarSI");
		continuarNO = getSpriteAtlasPause().findRegion("continuarNO");
		salirSI = getSpriteAtlasPause().findRegion("salirSI");
		salirNO = getSpriteAtlasPause().findRegion("salirNO");
		conectarSI = getSpriteAtlasPause().findRegion("conectarSI");
		conectarNO = getSpriteAtlasPause().findRegion("conectarNO");
		// //////////////////////////////////////////

		// ////////////////////FONDOS VENTANAS/////////////////////
		
		opcionesfondo = getSpriteAtlasFinal01().findRegion("opcionesfondo");
		menu = getSpriteAtlasFinal01().findRegion("menu");
		ventanaconfirmacion = getSpriteAtlasFinal01().findRegion(
				"ventanaconfirmacion");
		fantasmatransparente = getSpriteAtlasFinal01().findRegion(
				"fantasmatransparente");

	
	
		// /////////////////////////////////

		// ////////////////BASE CUENTO//////////////////////////

		Fondocuento = getSpriteAtlasCuento().findRegion("Fondocuento");
		
		//////////////////////SITUACION//////////////////////
		situacion = getSpriteAtlasSituacion().findRegion("situacion");
		viAboB = getSpriteAtlasSituacion().findRegion("viAboB");
		 viBboA = getSpriteAtlasSituacion().findRegion("viBboA");
		 cementerio  = getSpriteAtlasSituacion().findRegion("cementerio");
		 
		cementerioluz = getSpriteAtlasSituacion().findRegion("cementerioluz");
		castillo= getSpriteAtlasSituacion().findRegion("castillo");
		viB= getSpriteAtlasSituacion().findRegion("viB");
		castilloluz= getSpriteAtlasSituacion().findRegion("castilloluz");
		viBboB= getSpriteAtlasSituacion().findRegion("viBboB");
		viAboA = getSpriteAtlasSituacion().findRegion("viAboA");
		viA = getSpriteAtlasSituacion().findRegion("viA");
		oscuridadA = getSpriteAtlasSituacion().findRegion("oscuridadA");
		viAboC = getSpriteAtlasSituacion().findRegion("viAboC");
		oscuridadB = getSpriteAtlasSituacion().findRegion("oscuridadB");
		
		
		

		// //////////////////////////////////////////////////////

		// ///////BOTONES OPCIONES///////////////////
		musicaSI = getSpriteAtlasFinal01().findRegion("musicaSI");
		musicaNO = getSpriteAtlasFinal01().findRegion("musicaNO");
		volverSI = getSpriteAtlasFinal01().findRegion("volverSI");
		volverNO = getSpriteAtlasFinal01().findRegion("volverNO");
		sonidoSI = getSpriteAtlasFinal01().findRegion("sonidoSI");
		sonidoNO = getSpriteAtlasFinal01().findRegion("sonidoNO");
		comenzarSI = getSpriteAtlasFinal01().findRegion("comenzarSI");
		comenzarNO = getSpriteAtlasFinal01().findRegion("comenzarNO");

		botonSI = getSpriteAtlasFinal01().findRegion("botonSI");
		botonNO = getSpriteAtlasFinal01().findRegion("botonNO");
		transformarSI = getSpriteAtlasFinal01().findRegion("transformarSI");
		transformarNO = getSpriteAtlasFinal01().findRegion("transformarNO");
		// /////////////////////////////////

		/* CABECERA */
		cabezaHenrick = getSpriteAtlasFinal01().findRegion("cabeza");
		corazon = getSpriteAtlasFinal01().findRegion("corazona");
		corazonB = getSpriteAtlasFinal01().findRegion("corazonesb");
		corazonC = getSpriteAtlasFinal01().findRegion("corazonesc");
		corazonD = getSpriteAtlasFinal01().findRegion("corazonesd");
		nivelvida11 = getSpriteAtlasFinal01().findRegion("nivelvidaa");
		nivelvida10 = getSpriteAtlasFinal01().findRegion("nivelvidab");
		nivelvida9 = getSpriteAtlasFinal01().findRegion("nivelvidac");
		nivelvida8 = getSpriteAtlasFinal01().findRegion("nivelvidad");
		nivelvida7 = getSpriteAtlasFinal01().findRegion("nivelvidae");
		nivelvida6 = getSpriteAtlasFinal01().findRegion("nivelvidaf");
		nivelvida5 = getSpriteAtlasFinal01().findRegion("nivelvidag");
		nivelvida4 = getSpriteAtlasFinal01().findRegion("nivelvidah");
		nivelvida3 = getSpriteAtlasFinal01().findRegion("nivelvidai");
		nivelvida2 = getSpriteAtlasFinal01().findRegion("nivelvidaj");
		nivelvida1 = getSpriteAtlasFinal01().findRegion("nivelvidak");
		nivelvida0 = getSpriteAtlasFinal01().findRegion("nivelvidal");

		nivelvuelo6 = getSpriteAtlasFinal01().findRegion("nivelvuelog");
		nivelvuelo5 = getSpriteAtlasFinal01().findRegion("nivelvuelof");
		nivelvuelo4 = getSpriteAtlasFinal01().findRegion("nivelvueloe");
		nivelvuelo3 = getSpriteAtlasFinal01().findRegion("nivelvuelod");
		nivelvuelo2 = getSpriteAtlasFinal01().findRegion("nivelvueloc");
		nivelvuelo1 = getSpriteAtlasFinal01().findRegion("nivelvuelob");
		nivelvuelo0 = getSpriteAtlasFinal01().findRegion("nivelvueloa");

		reloj = getSpriteAtlasFinal01().findRegion("reloj");
		cajetinVacio = getSpriteAtlasFinal01().findRegion("cajetinvacio");
		cajetinDientes = getSpriteAtlasFinal01().findRegion("cajetindientes");
		cajetinVuelo = getSpriteAtlasFinal01().findRegion("cajetinvuelo");
		cajetinSangre = getSpriteAtlasFinal01().findRegion("cajetinvida");

		congrats_screen = getSpriteAtlas().findRegion("congrats_screen");
		snake_gem = getSpriteAtlas().findRegion("snake_gem");

		health_bar = getSpriteAtlas().findRegion("health_bar");
		stone = getSpriteAtlas().findRegion("stone");

		spring1 = getSpriteAtlas().findRegion("spring1");
		spring2 = getSpriteAtlas().findRegion("spring2");
		spring3 = getSpriteAtlas().findRegion("spring3");

		world2 = getSpriteAtlas().findRegion("world2");
		snake2 = getSpriteAtlas().findRegion("snake2");
		menubox = getSpriteAtlas().findRegion("menubox");
	}

	public static void loadButtons() {

		left_button = getSpriteAtlas().findRegion("left_button");
		right_button = getSpriteAtlas().findRegion("right_button");
		jump_button = getSpriteAtlas().findRegion("jump_button");
		level_button1 = getSpriteAtlas().findRegion("level_button1");
		level_button2 = getSpriteAtlas().findRegion("level_button2");
		level_locked = getSpriteAtlas().findRegion("level_locked");
		level_star = getSpriteAtlas().findRegion("level_star");

		// cargamos la cruceta del mando!
		crucetaMandoRegion = getSpriteAtlasBC().findRegion("crucetamando");
		TextureRegion[][] crucetaMandoTRegionMap = Assets.crucetaMandoRegion
				.split(170, 170);

		crucetaMandoDefault = crucetaMandoTRegionMap[0][0];
		crucetaMandoArriba = crucetaMandoTRegionMap[0][1];
		crucetaMandoAbajo = crucetaMandoTRegionMap[0][2];
		crucetaMandoIzquierda = crucetaMandoTRegionMap[0][3];
		crucetaMandoDerecha = crucetaMandoTRegionMap[0][4];

	}

	public static void loadFonts() {
		//
		smallFont = new BitmapFont(Gdx.files.internal("data/smallFont.fnt"),
				Gdx.files.internal("data/smallFont.png"), false);

		bigFont = new BitmapFont(Gdx.files.internal("data/bigFont.fnt"),
				Gdx.files.internal("data/bigFont.png"), false);

		/*
		 * smallFont = tipoLetra = new
		 * BitmapFont(Gdx.files.internal("data/tipoletra.fnt"),
		 * Gdx.files.internal("data/tipoletra.png"), false);
		 */

	}

	public static void loadAnimations() {

		TextureRegion[][] regionsHenrick = Assets.henrickStillTR.split(60, 60); // esto
																				// son
																				// pollas
		henrickStill = new Animation(0.15f, regionsHenrick[0][0],
				regionsHenrick[0][0]);
		henrickStill.setPlayMode(Animation.LOOP_PINGPONG);

		TextureRegion[][] regionsHenrickJump = Assets.henrickJumpTR.split(60,
				60);
		henrickJump = new Animation(0.5f, regionsHenrickJump[0][0],
				regionsHenrickJump[0][1], regionsHenrickJump[0][2],
				regionsHenrickJump[0][3]);

		TextureRegion[][] regionsHenrickWalk = Assets.henrickRunTR
				.split(60, 60);
		henrickWalk = new Animation(0.15f, regionsHenrickWalk[0][0],
				regionsHenrickWalk[0][1], regionsHenrickWalk[0][2],
				regionsHenrickWalk[0][3], regionsHenrickWalk[0][4],
				regionsHenrickWalk[0][5]);
		henrickWalk.setPlayMode(Animation.LOOP_PINGPONG);

		TextureRegion[][] regionVampire = Assets.vampiro.split(100, 100);
		vampiroFly = new Animation(0.15f, regionVampire[0][0],
				regionVampire[0][1], regionVampire[0][2], regionVampire[0][3]);
		vampiroFly.setPlayMode(Animation.LOOP_PINGPONG);

		pummaIcon = regionsHenrick[0][0];

		TextureRegion[][] regions = snake.split(384 / 4, 60);

		snakeStill = new Animation(0.5f, regions[0][0], regions[0][1]);
		snakeStill.setPlayMode(Animation.LOOP_PINGPONG);

		snakeMove = new Animation(0.15f, regions[0][0], regions[0][1],
				regions[0][2], regions[0][3]);
		snakeMove.setPlayMode(Animation.LOOP_PINGPONG);

		snakeIcon = regions[0][0];

		TextureRegion[][] dragonRegions = dragon.split(384 / 4, 384 / 4);

		dragonStill = new Animation(0.3f, dragonRegions[0][0],
				dragonRegions[0][3]);
		dragonStill.setPlayMode(Animation.LOOP_PINGPONG);

		dragonFlying = new Animation(0.15f, dragonRegions[0][0],
				dragonRegions[0][1], dragonRegions[0][2], dragonRegions[0][3]);
		dragonFlying.setPlayMode(Animation.LOOP_PINGPONG);

		dragonIcon = dragonRegions[0][0];

		springActive = new Animation(0.15f, spring3, spring1, spring2);
		springActive.setPlayMode(Animation.LOOP_PINGPONG);
	}

	// public static void loadSoundsAndMusics() {

	public static void loadMusics() {
		//music = Gdx.audio.newMusic(Gdx.files.internal("data/music.mp3"));
		//music.setLooping(true);
		
		musicMenus = Gdx.audio.newMusic(Gdx.files.internal("data/music/m01_arcane-02a.wav"));
		musicMenus.setLooping(true);
		musicMenus.setVolume(1);
		
		musicJuegoSuperficie = Gdx.audio.newMusic(Gdx.files.internal("data/music/m03_ducksingel_transcendent-clam2.mp3"));
		musicJuegoSuperficie.setLooping(true);
		musicJuegoSuperficie.setVolume(0.05f);
		
		musicHistoria = Gdx.audio.newMusic(Gdx.files.internal("data/music/m02_vampires-entrance.wav"));
		musicHistoria.setLooping(true);
		musicHistoria.setVolume(1);
		
		musicGameOver = Gdx.audio.newMusic(Gdx.files.internal("data/music/m06_calpomatt_fallensoldier.wav"));
		
		// Start Playing the Music if the sound is enabled
		if (GameData.getSoundEnabled()) {
			musicMenus.play();
		}
	}

	public static void loadSounds() {

		egggrab = Gdx.audio.newSound(Gdx.files.internal("data/egggrab.ogg"));
		gemgrab = Gdx.audio.newSound(Gdx.files.internal("data/gemgrab.ogg"));
		cry = Gdx.audio.newSound(Gdx.files.internal("data/cry.ogg"));
		ow = Gdx.audio.newSound(Gdx.files.internal("data/ow.ogg"));
		success = Gdx.audio.newSound(Gdx.files.internal("data/success.ogg"));
		fall = Gdx.audio.newSound(Gdx.files.internal("data/fall.ogg"));
		jump = Gdx.audio.newSound(Gdx.files.internal("data/sound/s14_fins_jumping.wav"));
		walk = Gdx.audio.newSound(Gdx.files.internal("data/sound/s10_j1987_forestwalk.wav"));
		fly = Gdx.audio.newSound(Gdx.files.internal("data/sound/140210__autistic-lucario__flapping-sound.wav"));

	}

	public static void playSound(Sound sound) {
		if (GameData.getSoundEnabled())
			sound.play(1);
		if (GameData.getSoundEnabled2())
			sound.play(1);
	}

	public static TextureRegion getSpritesVuelo(String nVuelo) {
		TextureRegion textureToReturn = Assets.nivelvuelo6;

		if ("nivelvuelo0".equals(nVuelo)) {
			textureToReturn = Assets.nivelvuelo0;

		} else if ("nivelvuelo1".equals(nVuelo)) {
			textureToReturn = Assets.nivelvuelo1;

		} else if ("nivelvuelo2".equals(nVuelo)) {
			textureToReturn = Assets.nivelvuelo2;

		} else if ("nivelvuelo3".equals(nVuelo)) {
			textureToReturn = Assets.nivelvuelo3;

		} else if ("nivelvuelo4".equals(nVuelo)) {
			textureToReturn = Assets.nivelvuelo4;

		} else if ("nivelvuelo5".equals(nVuelo)) {
			textureToReturn = Assets.nivelvuelo5;

		}
		return textureToReturn;
	}
}
