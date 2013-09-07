package com.mcprohosting.games.jamrpg.gui;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

public class RenderEngine {
	static int lastX = 0;
	static int lastY = 0;

	public static void render() {
		Display.update();

		if (lastX != Mouse.getX() || lastY != Mouse.getY()) {
			System.out.println("Y=" + Mouse.getY() + " X=" +  Mouse.getX());
		}

		lastX = Mouse.getX();
		lastY = Mouse.getY();
	}
}