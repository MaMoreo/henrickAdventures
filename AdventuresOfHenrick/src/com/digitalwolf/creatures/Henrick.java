package com.digitalwolf.creatures;

import com.badlogic.gdx.math.Rectangle;
import com.digitalwolf.world.World;

public class Henrick extends Sprite {

	public float MAX_VELOCITY = 10f;
	public float JUMP_VELOCITY = 40f;
	public static float DAMPING = 0.67f;

	public boolean visible;
	public static final float width = 55 * World.WORLD_UNIT; // Para Pumma era
	public static final float height = 60 * World.WORLD_UNIT;
	public boolean hasKey;
	private int heartsHenrickHas;
	private int nivelVidaHenrickHas;
	private boolean tocado = false;
	private boolean transformandose = false;
	private float startTocadoTime = 0;
	private float startTransformacionTime = 0;
	private float startVueloTime = 0;

	// contador de la barra de vuelo
	private Integer nivelVuelo;
	//public int health; // elimimar esto ??
	public float stateTime;

	// This state will be used during the drawing to decided whether to invert
	// horizontally or not
	public boolean facesRight;
	public boolean grounded;
	// Si Henrick tiene la pocima puede transformarse en vampiro.
	public Integer pocima;

	public Estado estadoHenrick;

	public enum Estado {
		E_STILL, E_WALK, E_JUMP, E_VAMPIRIZED, E_TOCADO
	}

	/**
	 * Constructor.
	 * 
	 * @param x
	 * @param y
	 */
	public Henrick(float x, float y) {
		super(x, y);
		// state = STILL;
		estadoHenrick = Estado.E_STILL;
		stateTime = 0;

		// make this decision in game screen
		facesRight = true;
		grounded = false;
		visible = true;
		//health = 1000;
		hasKey = false;
		heartsHenrickHas = 3;
		nivelVidaHenrickHas = 11;
		nivelVuelo = 6;
		// vampirized = false;
	}

	@Override
	public void update(float deltaTime) {
		super.update(deltaTime);
		if (tocado) {
			visible = !visible;
			float currentTime = System.nanoTime();
			if ((currentTime - startTocadoTime) >= 1000000000) {
				tocado = false;
				visible = true;
			}
		} else if (transformandose) {
			float currentTime = System.nanoTime();
			if ((currentTime - startTransformacionTime) >= 1000000000) {
				transformandose = false;
			}
		}

		if (estadoHenrick.equals(Estado.E_VAMPIRIZED)) {
			
			float currentTime = System.nanoTime();
			if ((currentTime - startVueloTime) >= 1000000000) {
				
				if (nivelVuelo > 0) {
					nivelVuelo = nivelVuelo - 1;
				}else {
					estadoHenrick = Estado.E_STILL;
				}
				startVueloTime = currentTime;
			}

		}
	}

	public Rectangle getBounds() {
		return new Rectangle(position.x, position.y, width, height);
	}

	public int getHeartsHenrickHas() {
		return heartsHenrickHas;
	}

	public void setHeartsHenrickHas(int heartsHenrickHas) {
		this.heartsHenrickHas = heartsHenrickHas;
	}

	public void setStartTocadoTime(float startTocadoTime) {
		this.startTocadoTime = startTocadoTime;
	}

	public void setStartTransformacionTime(float startTransformacionTime) {
		this.startTransformacionTime = startTransformacionTime;
	}

	/**
	 * Le quita a Henrick un poco de vida.
	 * 
	 * @param vidaRestar
	 *            La cantidad de vida que se resta.
	 * @return la Vida que le queda a Henrick
	 */
	public int quitarVida(int vidaRestar) {
		tocado = true;
		this.setStartTocadoTime(System.nanoTime());
		int vida = nivelVidaHenrickHas - vidaRestar;
		// System.out.println("Henrick tiene " + vida);
		nivelVidaHenrickHas = vida;
		return vida;
	}

	public int getNivelVidaHenrickHas() {
		return nivelVidaHenrickHas;
	}

	public boolean isTocado() {
		return tocado;
	}

	public void setTocado(boolean tocado) {
		this.tocado = tocado;
	}

	public Integer getPocima() {
		return pocima;
	}

	public void setPocima(Integer numberOfPocimas) {
		this.pocima = numberOfPocimas;
	}

	public boolean isTransformandose() {
		return transformandose;
	}

	public void setTransformandose(boolean transformandose) {
		// comienza la transformacion
		long time = System.nanoTime();
		this.setStartTransformacionTime(time);

		// comienzo a restar tiempo de vuelo
		this.setStartVueloTime(time);

		// Henrick se esta transformando
		this.transformandose = transformandose;
	}

	public Integer getNivelVuelo() {
		return nivelVuelo;
	}

	public void setNivelVuelo(Integer nivelVuelo) {
		this.nivelVuelo = nivelVuelo;
	}

	public float getStartVueloTime() {
		return startVueloTime;
	}

	public void setStartVueloTime(float startVueloTime) {
		this.startVueloTime = startVueloTime;
	}
}
