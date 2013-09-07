package com.mcprohosting.games.jamrpg.platform.datatypes;

import com.mcprohosting.games.jamrpg.platform.items.Backpack;
import com.mcprohosting.games.jamrpg.platform.items.Sword;

public class Player extends Entity{
	private String name;
	private PlayerType type;
	private boolean isNPC;
	private Backpack backpack;
	
	public Player(String name, PlayerType type, int x, int y, boolean isNPC) {
		this.name = name;
		this.isNPC = isNPC;
		this.setX(x);
		this.setY(y);
		this.type = type;
		
		if (this.type == PlayerType.WARRIOR){
			this.setDamageMultiplier(5);
			this.setMaxHealth(15);
			this.setAccuracy(80);
		} else if (this.type == PlayerType.WIZARD) {
			this.setDamageMultiplier(8);
			this.setMaxHealth(6);
			this.setAccuracy(70);
		}
		
		
		this.setHealth(this.getMaxHealth());
		this.backpack = new Backpack(6);
		this.backpack.addItem(new Sword(1, 70));
	}

	public PlayerType getType() {
		return this.type;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean getIsNPC() {
		return this.isNPC;
	}
	
	public Backpack getBackpack() {
		return this.backpack;
	}
	
	public void setBackPack(Backpack backpack) {
		this.backpack = backpack;
	}
	
	@Override
	public String toString() {
		return "{PLAYER-(NAME:" + this.getName() + ", TYPE:" + this.getType() + ", POS: " + this.getX() + "x" + this.getY() + ", HEALTH:" + this.getHealth() + "/" + this.getMaxHealth() + ")";
	}
}
