package com.mcprohosting.games.jamrpg.gui;

import org.newdawn.slick.geom.RoundedRectangle;

public class Utilities {
	public static boolean isClickOnButton(int mouseX, int mouseY, RoundedRectangle button) {

		if (mouseX < button.getX()+button.getWidth() && mouseX > button.getX() && mouseY < button.getY()+button.getHeight() && mouseY > button.getY()) {
			return true;
		} else {
			return false;
		}
	}
}