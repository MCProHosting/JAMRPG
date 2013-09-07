package com.mcprohosting.games.jamrpg.platform.datatypes;

import com.mcprohosting.games.jamrpg.platform.items.Backpack;
import com.mcprohosting.games.jamrpg.platform.items.Sword;

public class Monster extends Entity {
	private MonsterType type;
	private Backpack backpack;
	
	public Monster(MonsterType type, int x, int y, int level) {
		this.type = type;
		this.setX(x);
		this.setY(y);
		this.setLevel(level);
		
		if (this.type == MonsterType.GOBLIN) {
			this.setMaxHealth(15);
			this.setDamageMultiplier(2);
			this.setAccuracy(90);
		} else if (this.type == MonsterType.RAT) {
			this.setMaxHealth(5);
			this.setDamageMultiplier(1);
			this.setAccuracy(70);
		} else if (this.type == MonsterType.SPIDER) {
			this.setMaxHealth(8);
			this.setDamageMultiplier(5);
			this.setAccuracy(90);
		} else if (this.type == MonsterType.ZOMBIE) {
			this.setMaxHealth(10);
			this.setDamageMultiplier(5);
			this.setAccuracy(65);
		}
		
		this.backpack = new Backpack(10);
		this.backpack.addItem(new Sword(1, 100));
		this.setHealth(this.getMaxHealth());
	}
	
	public Backpack getBackpack() {
		return this.backpack;
	}
	
	public void setBackpack(Backpack backpack) {
		this.backpack = backpack;
	}
	
	public MonsterType getType() {
		return this.type;
	}
	
	public void setType(MonsterType type) {
		this.type = type;
	}
}
