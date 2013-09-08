package com.mcprohosting.games.jamrpg.gui;

import org.newdawn.slick.*;
import org.newdawn.slick.font.effects.ColorEffect;

public class Game extends BasicGame {
	public Game(String title) {
		super(title);
	}

	public void init(GameContainer gc) throws SlickException {

	}

	public void update(GameContainer gc, int i) throws SlickException {

	}

	public void render(GameContainer gc, Graphics g) throws SlickException {
		try {
			final java.awt.Font javaFont = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, org.newdawn.slick.util.ResourceLoader.getResourceAsStream("/src/res/fonts/Cardinal.ttf"));
			UnicodeFont uniFont = new UnicodeFont(javaFont);
			uniFont.addAsciiGlyphs();
			uniFont.getEffects().add(new ColorEffect());
		} catch (Exception e) {
			System.out.println("Error while loading font");
			e.printStackTrace();
		}

		//Font font = new Font(uniFont)
		g.drawString("Love you James <3", 50, 50);
	}
}