package com.mcprohosting.games.jamrpg.platform.logic;
import java.util.Random;

import com.mcprohosting.games.jamrpg.platform.datatypes.Fight;
import com.mcprohosting.games.jamrpg.platform.datatypes.Monster;
import com.mcprohosting.games.jamrpg.platform.datatypes.Player;


public class ActionHandler {
	
	public static void fight(boolean playerInitiated) {
		Player player = GameLogic.getPlayer();
		
		if (WorldHandler.isMonsterAt(player.getX(), player.getY())) {
			Fight fight = new Fight(player, WorldHandler.getMonsterAt(player.getX(), player.getY()), playerInitiated);
			fight.start();
		} else {
			System.out.println("There is nothing to fight here.");
		}
	}

	
	public static boolean move(String direction) {
		Player player = GameLogic.getPlayer();
		
		if (direction.equalsIgnoreCase("a")) {
			player.setX(player.getX()-1);
		} else if (direction.equalsIgnoreCase("d")) {
			player.setX(player.getX()+1);
		} else if (direction.equalsIgnoreCase("w")) {
			player.setY(player.getY()+1);
		} else if (direction.equalsIgnoreCase("s")) {
			player.setY(player.getY()-1);
		} else {
			System.out.println("You did not enter a valid direction!");
			return false;
		}
		
		if (WorldHandler.isMonsterAt(player.getX(), player.getY())) {
			Random randomGenerator = new Random();
			boolean attacks = randomGenerator.nextBoolean();
			if (attacks) {
				System.out.println("It challenges you.");
				fight(false);
			}
		}
		
		GameLogic.regenHealth();
		WorldHandler.updateMonsters();
		
		return true;
	}
	
	public static void look() {
		int results = 0;
		
		for (Monster monster : WorldHandler.getMonsters()) {
			if (GameLogic.getPlayer().getX() >= monster.getX()-5 && GameLogic.getPlayer().getX() <= monster.getX()+5) {
				if (GameLogic.getPlayer().getY() >= monster.getY()-5 && GameLogic.getPlayer().getY() <= monster.getY()+5) {
					System.out.println("You see a " + monster.getType() + " lev(" + monster.getLevel() + ") in the distance. (" + monster.getX() + "x" + monster.getY() + ")");
					results++;
				}
			}
		}
		
		if (results == 0) {
			System.out.println("The land is barren!");
		}
	}
}
