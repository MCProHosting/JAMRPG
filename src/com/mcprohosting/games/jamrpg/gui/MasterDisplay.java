package com.mcprohosting.games.jamrpg.gui;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class MasterDisplay {
	private String title;
	private int width;
	private int height;

	public MasterDisplay(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
	}

	public void start() {
		try {
			Display.setDisplayMode(new DisplayMode(this.width, this.height));
			Display.setTitle(this.title);
			Display.create();
		} catch (LWJGLException e) {
			System.out.println("LWJGL Exception Occurred!");
			e.printStackTrace();
		}

		while (!Display.isCloseRequested()) {
			RenderEngine.render();
		}

		destroyGraphics();
	}

	private void destroyGraphics() {
		System.out.println("Destroying graphics");
		Display.destroy();
	}
}
