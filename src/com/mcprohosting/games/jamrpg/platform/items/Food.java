package com.mcprohosting.games.jamrpg.platform.items;

import com.mcprohosting.games.jamrpg.platform.datatypes.FoodType;

public class Food extends Item {
	private FoodType type;
	private int restoredHealth;
	
	public Food(FoodType type, int restoredHealth) {
		this.type = type;
		this.restoredHealth = restoredHealth;
	}
	
	public FoodType getType() {
		return this.type;
	}
	
	public void setType(FoodType type) {
		this.type = type;
	}
	
	public int getRestoredHealth() {
		return this.restoredHealth;
	}
	
	public void setRestoredHealth(int restoredHealth) {
		this.restoredHealth = restoredHealth;
	}
}
