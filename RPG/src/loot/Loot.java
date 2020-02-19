package loot;

import dataclasses.GameObject;
import game.GameLauncher;

public abstract class Loot extends GameObject {
	
	private double price;
	private String name ;
	private String textBox;
	private int size ;
	
	public Loot(String id, double price, String name, String textBox, String spritePath, int size) {
		super(id, spritePath);
		this.price = price ;
		this.name = name ;
		this.textBox = textBox ;
		this.size = size ;
	}
	
	public String toString() {
		return super.toString() + " nom : " + name + "\ntextBox : " + textBox + "\nprice : " + price ;
	}

	public double getPrice() {
		return price;
	}
	
	public String getTextBox() {
		return textBox;
	}
}