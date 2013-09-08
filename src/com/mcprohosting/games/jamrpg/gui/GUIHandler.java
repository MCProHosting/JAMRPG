package com.mcprohosting.games.jamrpg.gui;

import com.mcprohosting.games.jamrpg.JAMRPG;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class GUIHandler {
	public static void init() {
		try {
			AppGameContainer appgc;
			appgc = new AppGameContainer(new Game(JAMRPG.getShortTitle() + " v" + JAMRPG.getVersion()));
			appgc.setDisplayMode(800, 600, false);
			appgc.start();
		} catch (SlickException e) {
			System.out.println("Error while initializing slick engine");
			e.printStackTrace();
		}
	}
}