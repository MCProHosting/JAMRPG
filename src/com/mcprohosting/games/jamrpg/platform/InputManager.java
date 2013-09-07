package com.mcprohosting.games.jamrpg.platform;

import com.mcprohosting.games.jamrpg.JAMRPG;

import java.util.Scanner;


public class InputManager {
	private static Scanner scanner = new Scanner(System.in);
	
	public static void handleWelcome() {
		System.out.println("Welcome to " + JAMRPG.getShortTitle() + "!");
		System.out.println("Verison " + JAMRPG.getVersion() + " created by James and Matt.");
	
	}
	
	public static String[] gatherCharInfo() {
		String inputtedName = getInput("What would you like your name to be? ");
		String inputtedClass = null;
		
		while (true) {
			inputtedClass = getInput("Welcome " + inputtedName + "! What class do you want to be? (Wizard/Warrior)");
			if (inputtedClass.equalsIgnoreCase("Wizard") || inputtedClass.equalsIgnoreCase("Warrior")) {
				String[] charInfo = {inputtedName, inputtedClass};
				
				return charInfo;
			} else {
				System.out.println("You did not enter a vaild class.");
			}
		}
	}
	
	public static void printGameOver() {
		System.out.println("****************************************");
		System.out.println("***************YOU DIED*****************");
		System.out.println("****************************************");
	}
	
	public static String getInput(String question) {
		System.out.println(question);
		String userInput = scanner.nextLine();
		
		return userInput;
	}
	
	public static void closeScanner() {
		scanner.close();
	}
}
