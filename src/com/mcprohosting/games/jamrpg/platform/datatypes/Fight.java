package com.mcprohosting.games.jamrpg.platform.datatypes;

import java.util.ArrayList;

import com.mcprohosting.games.jamrpg.platform.InputManager;

public class Fight {
	private Player player;
	private Monster monster;
	private ArrayList<Attack> attacks;
	private int winExpereince;
	private boolean playersTurn;
	
	public Fight(Player player, Monster monster, boolean playersTurn) {
		this.player = player;
		this.monster = monster;
		this.winExpereince = 10 * monster.getLevel();
		this.playersTurn = playersTurn;
		this.attacks = new ArrayList<Attack>();
	}
	
	public void start() {
		while (true) {
			if (player.getHealth() > 0) {
				if (monster.getHealth() > 0) {
					processTurn();
					this.setPlayersTurn(!this.getPlayersTurn());
				} else {
					System.out.println("You succesfully killed the " + monster.getType() + " +(" + this.getWinExperience() + "xp)!");
					player.setXP(player.getXP() + this.getWinExperience());
					//WorldHandler.removeMonster(this.monster);
					break;
				}
			} else {
				InputManager.printGameOver();
				System.exit(0);
			}
		}
	}
	
	public void processTurn() {
		Attack attack;
		
		if (this.getPlayersTurn()) {
			attack = new Attack(this.player, this.monster);
			attack.process();
			
			if (attack.getMissed()) {
				System.out.println("You missed the " + this.monster.getType());
			} else {
				System.out.println("You attacked the " + this.monster.getType() + " for " + attack.getDamage() + " HP!");
			}
		} else {
			attack = new Attack(this.monster, this.player);
			attack.process();
			
			if (attack.getMissed()) {
				System.out.println("The " + this.monster.getType() + " missed you!");
			} else {
				System.out.println("The " + this.monster.getType() + " attacked you for " + attack.getDamage() + " HP!");
			}
		}
		
		this.addAttack(attack);
	}
	
	private void addAttack(Attack attack) {
		this.attacks.add(attack);
	}
	
	public boolean getPlayersTurn() {
		return this.playersTurn;
	}
	
	public void setPlayersTurn(boolean playersTurn) {
		this.playersTurn = playersTurn;
	}
	
	public int getWinExperience() {
		return this.winExpereince;
	}
	
	public void setWinExperience(int winExpereince) {
		this.winExpereince = winExpereince;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public Monster getMonster() {
		return this.monster;
	}
	
	public void setMonster(Monster monster) {
		this.monster = monster;
	}
	
	public ArrayList<Attack> getAttacks() {
		return this.attacks;
	}
}