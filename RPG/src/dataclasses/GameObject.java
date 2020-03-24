package dataclasses;

import java.awt.Graphics;

import TileMap.TileMap;

public abstract class GameObject{

	private String id;
	private String spritePath;
	
	public GameObject(String id) {
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public String toString() {
		return "id = " + id + " ";
	}

	public GameObject(String id, String spritePath) {
		this.id = id ;
		this.spritePath = spritePath ;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getSpritePath() {
		return spritePath;
	}
	public void setSpritePath(String spritePath) {
		this.spritePath = spritePath;
	}
		
}
