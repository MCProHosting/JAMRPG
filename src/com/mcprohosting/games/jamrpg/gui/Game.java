package com.mcprohosting.games.jamrpg.gui;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Game extends BasicGame {
	int lastMouseX;
	int lastMouseY;
    int max = 0;
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

		if (max == 0) {
			increase = true;
		} else if (max == 550) {
			increase = false;
		}

		if (increase) {
			max += i/3;
		} else {
			max -= i/3;
		}
    }

	public void render(GameContainer gc, Graphics g) throws SlickException {
		//Font font = new Font(uniFont)
		//g.drawString("Love you Matt <3", 50, 50);
        //g.drawRect(788, 0, 10, 15);

        for (int i = 0; i < max; i++) {
            g.drawArc(i, i, i, i, i % 2 * 500, i % 5 * 250);
        }
	}
}