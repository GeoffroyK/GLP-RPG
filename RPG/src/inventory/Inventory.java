package inventory;

import java.util.ArrayList;

import loot.Equipment;
import loot.Loot;

public class Inventory {
	
	private ArrayList<Loot> drops ;
	private Equipment helmet ;
	private Equipment chestplate ;
	private Equipment pants ;
	private Equipment arms ;
	private Equipment weapon ;
	private int gold ;
	private int size ;
	private int sizeMax ;
	
	public Inventory(int size, int sizeMax) {
		drops = new ArrayList<Loot>();
		helmet = null ;
		chestplate = null ;
		pants = null ;
		arms = null ;
		weapon = null ;
		this.size = size ;
		this.sizeMax = sizeMax ;
		gold = 0 ;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getSizeMax() {
		return sizeMax;
	}

	public void setSizeMax(int sizeMax) {
		this.sizeMax = sizeMax;
	}

	public ArrayList<Loot> getDrops() {
		return drops;
	}

	public void setDrops(ArrayList<Loot> drops) {
		this.drops = drops;
	}

	public Equipment getHelmet() {
		return helmet;
	}

	public void setHelmet(Equipment helmet) {
		this.helmet = helmet;
	}

	public Equipment getChestplate() {
		return chestplate;
	}

	public void setChestplate(Equipment chestplate) {
		this.chestplate = chestplate;
	}

	public Equipment getPants() {
		return pants;
	}

	public void setPants(Equipment pants) {
		this.pants = pants;
	}

	public Equipment getArms() {
		return arms;
	}

	public void setArms(Equipment arms) {
		this.arms = arms;
	}

	public Equipment getWeapon() {
		return weapon;
	}

	public void setWeapon(Equipment weapon) {
		this.weapon = weapon;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
}
