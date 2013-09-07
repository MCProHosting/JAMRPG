package com.mcprohosting.games.jamrpg.platform.logic;
import java.util.ArrayList;
import java.util.Random;

import com.mcprohosting.games.jamrpg.platform.datatypes.Monster;
import com.mcprohosting.games.jamrpg.platform.datatypes.MonsterType;


public class WorldHandler {
	private static ArrayList<Monster> monsters = new ArrayList<Monster>();
	 
	public static boolean isMonsterAt(int x, int y) {
		if (getMonsterAt(x, y) != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public static Monster getMonsterAt(int x, int y) {
		for (Monster monster : monsters) {
			if (monster.getX() == x && monster.getY() == y) {
				return monster;
			} 
		}
		
		return null;
	}
	
	public static void spawnMonsters() {
		Random randomGenerator = new Random();
		for (int i = 0; i < 50; i++) {
			int x;
			int y;
			
			while (true) { //Ensures that monster is not generated on top of another one and other rules.
				x = randomGenerator.nextInt(50);
				boolean invertX = randomGenerator.nextBoolean();
				y = randomGenerator.nextInt(50);
				boolean invertY = randomGenerator.nextBoolean();
				
				if (invertX) {
					x = -x;
				}
				
				if (invertY) {
					y = -y;
				}
				
				if (!isMonsterAt(x, y) && (x != 0 && y != 0)) {
					break;
				}
			}

			int typeRandom = randomGenerator.nextInt(4); 
			MonsterType type = null;
			
			if (typeRandom == 0) {
				type = MonsterType.GOBLIN;
			} else if (typeRandom == 1) {
				type = MonsterType.RAT;
			} else if (typeRandom == 2) {
				type = MonsterType.SPIDER;
			} else if (typeRandom == 3) {
				type = MonsterType.ZOMBIE;
			}
			
			int level = ((Math.abs(x) + Math.abs(y))/10) + randomGenerator.nextInt((Math.abs(x) + Math.abs(y)))/2;
			if (Math.abs(x) + Math.abs(y) < 20) { //No too hard enemies in starting area.
				level = 1;
			}
			
			Monster monster = new Monster(type, x, y, level);
			monsters.add(monster);
		}
	}
	
	public static void updateMonsters() {
		Random randGenerator = new Random();
		
		for (Monster monster : monsters) {
			while (true) {
				boolean move = randGenerator.nextInt(5)==-1; //DISABLES MOVEMENT FIX LATER ROAR
				
				if (move) {
					int finalX = monster.getX();
					int finalY = monster.getY();
					
					int xIncrease = randGenerator.nextInt(2);
					boolean invertX = randGenerator.nextBoolean();
					
					if (xIncrease == 0) {
						int yIncrease = randGenerator.nextInt(2);
						boolean invertY = randGenerator.nextBoolean();
						
						if (invertY) {
							yIncrease = -yIncrease;
						}
						
						finalY = monster.getY() + yIncrease;
						monster.setY(monster.getY() + yIncrease);
					} else {
						if (invertX) {
							xIncrease = -xIncrease;
						}
						
						finalX = monster.getX() + xIncrease;
					}
					
					if (!isMonsterAt(finalX, finalY)) {
						monster.setX(monster.getX() + xIncrease);
						
						break;
					}
				} else {
					break;
				}
			}
		}
	}
	
	public static boolean removeMonster(Monster monster) {
		int i = 0;
		for (Monster currentMonster : monsters) {
			if (currentMonster.equals(monster)) {
				monsters.remove(i);
				
				return true;
			}
			
			i++;
		}
		
		return false;
  	}
	
	public static ArrayList<Monster> getMonsters() {
		return monsters;
	}
}
