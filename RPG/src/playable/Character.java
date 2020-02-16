package playable;

import dataclasses.* ;

public abstract class Character extends GameObject {
	
	private int lifePoint ;
	private int manaPoint ;
	private int strength ;
	private int dexterity ;
	private int intelligence ;
	private int defense ;
	private int attack ;
	private int attackSpeed ;
	private String cast ;
	private int range ;
	private int level ;
	private int criticalChance ;
	private int dodgeChange ;

	public Character(String id, String spritePath, boolean priority) {
		super(id, spritePath);
	}
	

}
