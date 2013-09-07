package com.mcprohosting.games.jamrpg.platform.items;

public class Item {
	private int x;
	private int y;
	
	public Item() {}
	
	public Item(int x, int y) {
		this.x = x;
		this.y = y;
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
}
