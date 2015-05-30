package com.digitalwolf.screens;

import com.digitalwolf.assets.Assets;
import com.digitalwolf.world.IWorldListener;

public class WorldListener implements IWorldListener {

	private boolean soundEnabled;

	public WorldListener(boolean soundEnabled) {
		this.soundEnabled = soundEnabled;
	}

	@Override
	public void fall() {
		if (soundEnabled)
			Assets.playSound(Assets.fall);
	}

	@Override
	public void grabgem() {
		if (soundEnabled)
		Assets.playSound(Assets.gemgrab);
	}

	@Override
	public void grabegg() {
		if (soundEnabled)
		Assets.playSound(Assets.egggrab);
	}

	@Override
	public void cry() {
		if (soundEnabled)
		Assets.playSound(Assets.cry);
	}

	@Override
	public void ow() {
		if (soundEnabled)
		Assets.playSound(Assets.ow);
	}

	@Override
	public void success() {
		if (soundEnabled)
		Assets.playSound(Assets.success);
	}

	@Override
	public void jump() {
		if (soundEnabled)
		Assets.playSound(Assets.jump);
	}

	@Override
	public void walk() {
		//TODO:Arreglar
		
		// if (world.henrick.estadoHenrick == Estado.E_VAMPIRIZED){
		// Assets.playSound(Assets.fly);
		// }else {
		// Assets.playSound(Assets.walk);
		// }
	}

}
