package loot;

import dataclasses.GameObject;

public abstract class Loot extends GameObject {
	
	private double price;
	private String name ;
	private String textBox;
	private int size ;   
	private int itemCounter;
	
	public Loot(String id, double price, String name, String textBox, String spritePath, int size) {
		super(id, spritePath);
		this.price = price ;
		this.name = name ;
		this.textBox = textBox ;
		this.size = size ;
		itemCounter = 1 ;
	}
	
	public String toString() {
		return super.toString() + " nom : " + name + " / possedé : " + itemCounter + "\ntextBox : " + textBox + "\nprice : " + price + " size : " + size ;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getItemCounter() {
		return itemCounter;
	}

	public void setItemCounter(int itemCounter) {
		this.itemCounter = itemCounter;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setTextBox(String textBox) {
		this.textBox = textBox;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public double getPrice() {
		return price;
	}
	
	public String getTextBox() {
		return textBox;
	}
}