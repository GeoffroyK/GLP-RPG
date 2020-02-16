package inventory;

import java.util.ArrayList;

import loot.*;

public class Inventory {
	
	private ArrayList<Loot> drops ;
	private Equipment helmet ;
	private Equipment chestplate ;
	private Equipment pants ;
	private Equipment arms ;
	private Equipment weapon ;
	private int size ;
	
	public Inventory(int size) {
		drops = new ArrayList<Loot>();
		this.size = size ;
	}
	
	public void addLoot(Loot lootDrop) {
		drops.add(lootDrop);
	}
	
	public void suppLoot(Loot lootThrow) {
		drops.remove(lootThrow) ;
	}
	
}
