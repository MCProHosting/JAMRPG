package com.mcprohosting.games.jamrpg.gui;

import com.mcprohosting.games.jamrpg.JAMRPG;

public class GUIHandler {
	public static void init() {
		MasterDisplay display = new MasterDisplay(JAMRPG.getShortTitle() + " v" + JAMRPG.getVersion(), 800, 600);
		display.start();
	}
}