package com.mcprohosting.games.jamrpg.platform.items;

import java.util.ArrayList;

public class Backpack {
	private int size;
	private ArrayList<Item> inventory;
	
	public Backpack(int size) {
		this.size = size;
		this.inventory = new ArrayList<Item>();
	}
	
	public Sword getStrongestWeapon() {
		int[] biggestSword = {0, 0};
		
		int i = 0;
		for (Item item : this.inventory) {
			if (item instanceof Sword) {
				Sword sword = (Sword) item;
				if (biggestSword[1] < sword.getDamageMultiplier()) {
					biggestSword[0] = i;
					biggestSword[1] = sword.getDamageMultiplier();
				}
			} else {
				System.out.println("Item is not a sword!");
			}
			
			i++;
		}
		
		return (Sword) inventory.get(biggestSword[0]);
	}
	
	public int getSize() {
		return this.size;		
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public ArrayList<Item> getInventory() {
		return this.inventory;
	}
	
	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}
	
	public boolean addItem(Item item) { 
		if (this.isFull() == true) {
			System.out.println("Your backpack is full!");
			return false;
		} else {
			this.inventory.add(item);
			return true;
		}
	}
	
	public boolean removeItem(Item item) {
		if (this.inventory.remove(item)) {
			return true;
		} else {
			System.out.println("This item does not exist!");
			return false;
		}
	}
	
	public Item getiteminSlot(int itemNumber) {
		Item item = inventory.get(itemNumber);
		if (item != null) {
			return item;
		} else {
			return null;
		}
	}
	
	public boolean isFull() {
		if (this.inventory.size() < this.size) {
			return false;
		} else {
			return true;
		}
	}
	
	public String toString() {
		return "{BACKPACK: size: "  + this.size + ", " + this.inventory + "}";
	}
}
