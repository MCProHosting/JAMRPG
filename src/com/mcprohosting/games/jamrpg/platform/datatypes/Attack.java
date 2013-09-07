package com.mcprohosting.games.jamrpg.platform.datatypes;

import java.util.Random;

import com.mcprohosting.games.jamrpg.platform.items.Sword;

public class Attack {
	private Entity attacker;
	private Sword attackerSword;
	private Entity attacked;
	private double damage;
	private boolean missed;
	
	public Attack(Entity attacker, Entity attacked) {
		this.attacker = attacker;
		this.attacked = attacked;
		
		if (attacker instanceof Player) {
			this.attackerSword = ((Player) attacker).getBackpack().getStrongestWeapon();
		} else if (attacker instanceof Monster) {
			this.attackerSword = ((Monster) attacker).getBackpack().getStrongestWeapon();
		}
	}
	
	public void process() {
		if (!isMiss(this.attacker, this.attackerSword)) {
			this.damage = this.attackerSword.getDamageMultiplier() * this.attacker.getDamageMultiplier();
			this.attacked.setHealth(this.attacked.getHealth() - damage);
		} else {
			this.missed = true;
		}
	}
	
	private boolean isMiss(Entity entity, Sword sword) {
		Random randGen = new Random();
		int missProb = (100-entity.getAccuracy()) + (100-sword.getAccuracy());
		
		return (randGen.nextInt(missProb) == 0);
	}
	
	public Entity getAttacker() {
		return this.attacker;
	}
	
	public void setAttacker(Entity attacker) {
		this.attacker = attacker;
	}
	
	public Entity getAttacked() {
		return this.attacked;
	}
	
	public void setAttacked(Entity attacked) {
		this.attacked = attacked;
	}
	
	public boolean getMissed() {
		return this.missed;
	}
	
	public void setMissed(boolean missed) {
		this.missed = missed;
	}
		
	public double getDamage() {
		return this.damage;
	}
	
	public void setDamage(double damage) {
		this.damage = damage;
	}
}
