package com.mcprohosting.games.jamrpg.platform.datatypes;

import com.mcprohosting.games.jamrpg.platform.logic.LevelHandler;

public class Entity {
	private int x;
	private int y;
	private double curHealth;
	private double maxHealth;
	private double damageMultiplier;
	private int level;
	private int accuracy;
	private int xp;
	
	public Entity() {}
	
	public Entity(int x, int y, double maxHealth, double damageMultiplier, int level, int accuracy) {
		this.x = x;
		this.y = y;
		this.maxHealth = maxHealth;
		this.curHealth = this.maxHealth;
		this.damageMultiplier = damageMultiplier;
		this.level = level;
		this.accuracy = accuracy;
	}
	
	public int getX() {
		return this.x;
	}
	
	public void setX(int x) {
		this.x = x;	
	}
	
	public int getAccuracy() {
		return this.accuracy;
	}
	
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public double getHealth() {
		return this.curHealth;
	}
	
	public int getXP() {
		return this.xp;
	}
	
	public void setXP(int xp) {
		this.xp = xp;
		LevelHandler.processPlayerLevelup(this);
	}
	
	public void setHealth(double d) {
		if (d <= this.maxHealth) {
			this.curHealth = d;
		} else {
			System.out.println("Entity's health was attempted to be set to a higher value than max health.");
		}
	}
	
	public double getMaxHealth() {
		return this.maxHealth;
	}
	
	public void setMaxHealth(double maxHealth) {
		this.maxHealth = maxHealth;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public void levelUp() {
		this.level++;
		this.maxHealth = this.getMaxHealth()*1.1;
		this.curHealth = this.getMaxHealth();
		this.damageMultiplier =  this.getDamageMultiplier() * 1.1;
	}

	public double getDamageMultiplier() {
		return this.damageMultiplier;
	}
	
	public void setDamageMultiplier(double damageMultiplier) {
		this.damageMultiplier = damageMultiplier;
	}
	
	
	public String toString() {
		return "{ENTITY-(POS: " + this.x + "x" + this.y + ", HEALTH:" + this.curHealth + "/" + this.maxHealth + ")";
	}
}
