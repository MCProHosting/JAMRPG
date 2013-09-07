package com.mcprohosting.games.jamrpg.platform.items;

public class Sword extends Item {
	private int damageMultiplier;
	private int accuracy;
	
	public Sword(int damageMultiplier, int accuracy) {
		this.damageMultiplier = damageMultiplier;
		this.accuracy = accuracy;
	}
	
	public int getAccuracy() {
		return this.accuracy;
	}
	
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	
	public int getDamageMultiplier() {
		return this.damageMultiplier;
	}
	
	public void setDamageMultiplier(int damageMultiplier) {
		this.damageMultiplier = damageMultiplier;
	}
	
	
}
