package map_objects;

import dataclasses.GameObject;

public class Prop extends GameObject {
	
	private String name;
	private int type;
	private int x;
	private int y;
	private int direction;
	
	public Prop(String id, String name, int type, String spritePath) {
		super(id);
		this.name = name;
		this.type = type;
	}

		
	//Getters
	
	public String getName() {
		return name;
	}
		
	public int getType() {
		return type;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	//Setters
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}

}
