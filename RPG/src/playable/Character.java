package playable;

import dataclasses.*;
import game.Colision;
import inventory.Inventory;

public abstract class Character extends GameObject {

	//Map Position
	
	private float x;
	private float y;
	
	private float VelX;
	private float VelY;
	// 0=north, 1=west, 2=east, 3=south
	// 10 = NW, 20 = NE, 32 = SE, 31 = SW
	private int direction;
	
	private int width;
	private int height;

	//Caracteristics
	private String type;
	private int lifePoint;
	private int lifePointMax ;
	private int manaPoint;
	private int manaPointMax ;
	private int strength;
	private int dexterity;
	private int intelligence;
	private int defense;
	private int attack;
	private int range;
	private int inventoryStatus;
	private int level;
	private int attackSpeed;
	private int criticalChance;
	private int dodgeChance;
	private int speed;
	private Inventory inventory ;
	
	public Character(String id, String type, int hp, int mp, int str, int dext, int intel, int def, int atk, int range,
			int inventory, int level, int atkSpeed, int ctkChance, int dodgeChance,String spritePath) {

		super(id,spritePath);
		lifePointMax = hp ;
		lifePoint = lifePointMax ;
		manaPointMax = mp;
		manaPoint = manaPointMax ; 
		strength = str;
		dexterity = dext;
		intelligence = intel;
		defense = def;
		attack = atk;
		this.type = type;
		this.range = range;
		this.inventoryStatus = inventory;
		this.level = level;
		this.attackSpeed = atkSpeed;
		criticalChance = ctkChance;
		this.dodgeChance = dodgeChance;
		this.inventory = new Inventory(0, 150) ;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public int getLifePointMax() {
		return lifePointMax;
	}

	public void setLifePointMax(int lifePointMax) {
		this.lifePointMax = lifePointMax;
	}

	public int getManaPointMax() {
		return manaPointMax;
	}

	public void setManaPointMax(int manaPointMax) {
		this.manaPointMax = manaPointMax;
	}

	
	public String toString() {
		return "-----------------------------------------------\n" +super.toString()+ "\nclass = " + getType() + "\nhp = "
				+ getLifePoint() + "\nmp = " + getManaPoint() + "\nStr = " + getStrength() + "\ndext = "
				+ getDexterity() + "\nintel = " + getIntelligence() + "\ndef = " + getDefense() + "\natk = "
				+ getAttack() + "\nrange = " + getRange() + "\ninventory = " + getInventoryStatus() + "\nlevel = "
				+ getLevel() + "\natkSpeed = " + getAttackSpeed() + "\nctkChance = " + getCriticalChance()
				+ "\ndodgeChance = " + getDodgeChance();
	}

	public float getVelX() {
		return VelX;
	}

	public void setVelX(float velX) {
		VelX = velX;
	}

	public float getVelY() {
		return VelY;
	}

	public void setVelY(float velY) {
		VelY = velY;
	}

	public int getLifePoint() {
		return lifePoint;
	}

	public void setLifePoint(int lifePoint) {
		this.lifePoint = lifePoint;
	}

	public int getManaPoint() {
		return manaPoint;
	}

	public void setManaPoint(int manaPoint) {
		this.manaPoint = manaPoint;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getInventoryStatus() {
		return inventoryStatus;
	}

	public void setInventoryStatus(int inventoryStatus) {
		this.inventoryStatus = inventoryStatus;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getAttackSpeed() {
		return attackSpeed;
	}

	public void setAttackSpeed(int attackSpeed) {
		this.attackSpeed = attackSpeed;
	}

	public int getCriticalChance() {
		return criticalChance;
	}

	public void setCriticalChance(int criticalChance) {
		this.criticalChance = criticalChance;
	}

	public int getDodgeChance() {
		return dodgeChance;
	}

	public void setDodgeChance(int dodgeChance) {
		this.dodgeChance = dodgeChance;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setX(float x) {
		this.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public int getDirection() {
		return direction;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	

}