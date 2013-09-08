package com.mcprohosting.games.jamrpg.gui;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

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
			setIcon("src/res/images/icon-16.png", "src/res/images/icon-32.png");
			Display.create();
		} catch (LWJGLException e) {
			System.out.println("LWJGL Exception Occurred!");
			e.printStackTrace();
		}

		while (!Display.isCloseRequested()) {
			RenderEngine.render();
		}

		//Application is closed using x.
		destroyGraphics();
		System.exit(0);
	}

	private void setIcon(String path16, String path32) {
		ByteBuffer[] list = new ByteBuffer[2];
		try {
			list[0] = loadIcon(path16, 16, 16);
			list[1] = loadIcon(path32, 32, 32);
			Display.setIcon(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private ByteBuffer loadIcon(String filename, int width, int height) throws IOException {
		BufferedImage image = ImageIO.read(new File(filename)); // load image

		// convert image to byte array
		byte[] imageBytes = new byte[width * height * 4];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int pixel = image.getRGB(j, i);
				for (int k = 0; k < 3; k++) // red, green, blue
					imageBytes[(i*16+j)*4 + k] = (byte)(((pixel>>(2-k)*8))&255);
				imageBytes[(i*16+j)*4 + 3] = (byte)(((pixel>>(3)*8))&255); // alpha
			}
		}
		return ByteBuffer.wrap(imageBytes);
	}

	private void destroyGraphics() {
		System.out.println("Destroying graphics");
		Display.destroy();
	}
}
