package com.mcprohosting.games.jamrpg.gui;

import com.mcprohosting.games.jamrpg.JAMRPG;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;

public class GUIHandler {
	public static void init() {
		try {
			AppGameContainer appgc;
			appgc = new AppGameContainer(new Game(JAMRPG.getShortTitle() + " v" + JAMRPG.getVersion()));
			appgc.setShowFPS(false);
			appgc.setDisplayMode(800, 600, false);
			appgc.start();
		} catch (SlickException e) {
			System.out.println("Error while initializing slick engine");
			e.printStackTrace();
		}
	}

	public static void setupFont() {
		try {
			final java.awt.Font javaFont = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, org.newdawn.slick.util.ResourceLoader.getResourceAsStream("/src/res/fonts/Cardinal.ttf"));
			UnicodeFont uniFont = new UnicodeFont(javaFont);
			uniFont.addAsciiGlyphs();
			uniFont.getEffects().add(new ColorEffect());
		} catch (Exception e) {
			System.out.println("Error while loading font");
			e.printStackTrace();
		}

	}
}