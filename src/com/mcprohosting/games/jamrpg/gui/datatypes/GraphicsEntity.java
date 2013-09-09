package com.mcprohosting.games.jamrpg.gui.datatypes;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.util.HashMap;

public class GraphicsEntity {
	private int x;
	private int y;
	private HashMap<String, Image> images;

	public GraphicsEntity(int x, int y, String... images) {
		this.x = x;
		this.y = y;

		for (String image : images) {
			addImage(image);
		}
	}

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public HashMap<String, Image> getImages() {
		return this.images;
	}

	public void addImage(String imagePath) {
		try {
			images.put(imagePath, new Image(imagePath));
		} catch (SlickException e) {
			System.out.println("Error occurred while loading image " + imagePath);
			e.printStackTrace();
			System.exit(-1);
		}
	}
}
