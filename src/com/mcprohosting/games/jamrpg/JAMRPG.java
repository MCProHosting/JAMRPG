package com.mcprohosting.games.jamrpg;

import com.mcprohosting.games.jamrpg.gui.GUIHandler;
import com.mcprohosting.games.jamrpg.platform.data.Sounds;

public class JAMRPG {
	private static double version = 0.3;
	private static String shortTitle = "JAMRPG";
	private static String longTitle = "Just Another Multiplayer RPG";

	public static void main(String[] args) {
		Utilities.hookShutdown();
		Utilities.initializeJavaFX();
		Sounds.init();
		GUIHandler.init();

		/*InputManager.handleWelcome();
		GameLogic.createPlayer(InputManager.gatherCharInfo());
		GameLogic.startTicking();
		*/
	}

	public static double getVersion() {
		return version;
	}

	public static String getShortTitle() {
		return shortTitle;
	}

	public static String getLongTitle() {
		return longTitle;
	}
}