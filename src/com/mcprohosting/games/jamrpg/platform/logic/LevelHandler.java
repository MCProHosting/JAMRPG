package com.mcprohosting.games.jamrpg.platform.logic;

import com.mcprohosting.games.jamrpg.platform.datatypes.Entity;


public class LevelHandler {
	public static int getRequiredXP(int level) {
		return 25 * level * level - 25 * level;
	}
	
	public static void processPlayerLevelup(Entity entity) {
		if (entity.getXP() >= getRequiredXP(entity.getLevel()+1)) {
			entity.levelUp();
			System.out.println("You have leveled up! Current level: " + entity.getLevel() + " Type stats for more info!");
		}
	}
}
