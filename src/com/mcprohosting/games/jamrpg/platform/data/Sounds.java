package com.mcprohosting.games.jamrpg.platform.data;

import com.mcprohosting.games.jamrpg.platform.SoundManager;

import java.io.File;

public class Sounds {
	public static String MUSIC_INTRO;

	public static void init() {
		File file = new File("src/res/sounds/MUSIC_MENU.mp3");
		try{
			MUSIC_INTRO = file.toURI().toURL().toExternalForm();
		} catch (Exception e) {
			e.printStackTrace();
		}

		SoundManager.playSoundInThread(MUSIC_INTRO);
	}
}