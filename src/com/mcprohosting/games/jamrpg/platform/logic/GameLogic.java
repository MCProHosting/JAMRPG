package com.mcprohosting.games.jamrpg.platform.logic;
import java.util.Random;

import com.mcprohosting.games.jamrpg.platform.InputManager;
import com.mcprohosting.games.jamrpg.platform.datatypes.Monster;
import com.mcprohosting.games.jamrpg.platform.datatypes.Player;
import com.mcprohosting.games.jamrpg.platform.datatypes.PlayerType;


public class GameLogic {
	private static boolean ticking = false; 
	private static Player player = null;
	
	private static void tick() {
		String action;
		
		if (WorldHandler.isMonsterAt(player.getX(), player.getY())) {
			System.out.println("There is something to kill here.");
			action = InputManager.getInput("What do you want to do? (FIGHT/w/a/s/d/Look/Stats/Exit)");
		} else {
			action = InputManager.getInput("What do you want to do? (w/a/s/d/Look/Stats/Exit)");
		}
		
		
		if (action.equalsIgnoreCase("exit")) {
			ticking = false;
		} else if (action.equalsIgnoreCase("w") || action.equalsIgnoreCase("a") || action.equalsIgnoreCase("s") || action.equalsIgnoreCase("d")) {
			ActionHandler.move(action);
			System.out.println("You move to " + player.getX()+ "x" + player.getY());
		} else if (action.equalsIgnoreCase("Fight")) {
			ActionHandler.fight(true);
		} else if (action.equalsIgnoreCase("Look")) {
			ActionHandler.look();
		} else if (action.equalsIgnoreCase("Stats")) {
			System.out.println("Name: " + player.getName() + " (Lv" + player.getLevel() + " " + player.getType() + "):");
			System.out.println("XP: " + player.getXP() + "/" + LevelHandler.getRequiredXP(player.getLevel()+1));
			System.out.println("Location: " + player.getX() + "x" + player.getY());
			System.out.println("Health: " + player.getHealth() + "/" + player.getMaxHealth());
			System.out.println("Character Damage Multiplier: " + player.getDamageMultiplier());
		}
		else {
			System.out.println("You did not enter a valid action!");
		}
	}
	
	public static void startTicking() {
		WorldHandler.spawnMonsters();
		ticking = true;
		while (ticking == true) {
			tick();
		}
	}
	
	public static void createPlayer(String[] data) {
		if (data[1].equalsIgnoreCase("Wizard")) {
			player = new Player(data[0], PlayerType.WIZARD, 0, 0, false);
			System.out.println("You will be the greatest " + player.getType() + " in the land! You have " + player.getHealth() + "HP and attack for " + player.getDamageMultiplier() + ".");
		} else if (data[1].equalsIgnoreCase("Warrior")) {
			player = new Player(data[0], PlayerType.WARRIOR, 0, 0, false);
			System.out.println("You will be the strongest " + player.getType() + " in the land! You have " + player.getHealth() + "HP and attack for " + player.getDamageMultiplier() + ".");
		}
	}
	
	public static void regenHealth() {
		Random randGenerator = new Random();
		
		if (player.getHealth() < player.getMaxHealth()) {
			boolean playerRegen = randGenerator.nextBoolean();
			
			if (playerRegen) {
				player.setHealth(player.getHealth()+1);
			}
		}
		
		for (Monster monster : WorldHandler.getMonsters()) {
			if (monster.getHealth() < monster.getMaxHealth()) {
				boolean monsterRegen = randGenerator.nextBoolean();
				
				if (monsterRegen) {
					monster.setHealth(monster.getHealth()+1);
				}
			}
		}
	}
	
	public static Player getPlayer() {
		return player;
	}
}
