package com.mcprohosting.games.jamrpg.gui;

import com.mcprohosting.games.jamrpg.JAMRPG;
import com.mcprohosting.games.jamrpg.gui.datatypes.GraphicsState;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class GUIHandler {
	private static GraphicsState graphicsState;

	public static void init() {
		try {
			setGraphicsState(GraphicsState.MENU);

			AppGameContainer appgc;
			appgc = new AppGameContainer(new Game(JAMRPG.getShortTitle() + " v" + JAMRPG.getVersion()));
			appgc.setShowFPS(true);
			appgc.setIcon("src/res/images/icon-32.png");
			appgc.setDisplayMode(800, 600, false);
			appgc.start();
		} catch (SlickException e) {
			System.out.println("Error while initializing slick engine");
			e.printStackTrace();
		}
	}

	public static GraphicsState getGraphicsState() {
		return graphicsState;
	}

	public static void setGraphicsState(GraphicsState graphicsStateIn) {
		graphicsState = graphicsStateIn;
	}
}