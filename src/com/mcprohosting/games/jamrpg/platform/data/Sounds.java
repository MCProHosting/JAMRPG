package com.mcprohosting.games.jamrpg.platform.data;

import com.mcprohosting.games.jamrpg.platform.SoundManager;

public class Sounds {
	public static int MUSIC_INTRO;

	public static void init() {
		SoundManager soundManager = new SoundManager();
		soundManager.initalize(8);

		MUSIC_INTRO = soundManager.addSound("com/mcprohosting/games/jamrpg/platform/data/MUSIC_MENU.wav");
		soundManager.playSound(MUSIC_INTRO);
	}
}