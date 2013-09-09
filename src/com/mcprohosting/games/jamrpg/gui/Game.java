package com.mcprohosting.games.jamrpg.gui;

import com.mcprohosting.games.jamrpg.gui.datatypes.GraphicsState;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.RoundedRectangle;

import java.util.ArrayList;

public class Game extends BasicGame {
	private static boolean wasLastTickLeftDown;
	private static ArrayList<RoundedRectangle> buttons = new ArrayList<RoundedRectangle>();
	//private static java.awt.Font font = new java.awt.Font("Verdana", java.awt.Font.BOLD, 20);
	//protected static UnicodeFont uFont = new UnicodeFont(font, font.getSize(), font.isBold(), font.isItalic());

	public Game(String title) {
		super(title);
	}

	public void init(GameContainer gc) throws SlickException {
		buttons.add(new RoundedRectangle(gc.getWidth()/2-50, gc.getHeight()/2-35, 125, 45, 10));
	}

	public void update(GameContainer gc, int i) throws SlickException {
		if (!wasLastTickLeftDown) {
			if (Mouse.isButtonDown(0)) {
				wasLastTickLeftDown = true;
				for (RoundedRectangle button : buttons) {
					if (Utilities.isClickOnButton(Mouse.getX(), 600-Mouse.getY(), button)) {
						GUIHandler.setGraphicsState(GraphicsState.PLAYING);
					}
				}
			}
		}

		if (!Mouse.isButtonDown(0)) {
			wasLastTickLeftDown = false;
		}
    }

	public void render(GameContainer gc, Graphics g) throws SlickException {
		//g.setFont(uFont); Y U NO WORK STUPID FONT
		if (GUIHandler.getGraphicsState().equals(GraphicsState.MENU)) {
			g.drawString("Just Another Multiplayer", gc.getWidth()/2-100, 50);
			g.drawString("RPG", gc.getWidth()/2-5, 75);

			for (RoundedRectangle button : buttons) {
				g.draw(button);
				g.fill(button);
			}
		} else if (GUIHandler.getGraphicsState().equals(GraphicsState.CHARACTERSELECTION)) {

		} else if (GUIHandler.getGraphicsState().equals(GraphicsState.PAUSED)) {

		} else if (GUIHandler.getGraphicsState().equals(GraphicsState.PLAYING)) {

		} else {
			System.out.println("Unknown graphics state " + GUIHandler.getGraphicsState());
			System.exit(-1);
		}
	}
}