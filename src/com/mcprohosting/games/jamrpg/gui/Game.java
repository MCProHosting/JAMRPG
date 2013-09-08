package com.mcprohosting.games.jamrpg.gui;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.font.effects.ColorEffect;

public class Game extends BasicGame {
	int lastMouseX;
	int lastMouseY;
    int max;
    boolean increase = true;

	public Game(String title) {
		super(title);
	}

	public void init(GameContainer gc) throws SlickException {

	}

	public void update(GameContainer gc, int i) throws SlickException {
		if (lastMouseX != Mouse.getX() || lastMouseY != Mouse.getY()) {
			System.out.println("Mouse - x: " + Mouse.getX() + " y: " + (600-Mouse.getY()));
		}

		lastMouseX = Mouse.getX();
		lastMouseY = Mouse.getY();

        if (max == 500) {
            increase = false;
        } else {
            increase = true;
        }

        if (max == 0) {
            increase = true;
        } else {
            increase = false;
        }

        if (increase) {
            max++;
        } else {
            max--;
        }
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
		g.drawString("Love you Matt <3", 50, 50);
        g.drawRect(788, 0, 10, 15);

        for (int i = 0; i < max; i++) {
            g.drawOval(i, i, i, i);
        }
	}
}