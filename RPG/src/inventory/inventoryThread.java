package inventory;

import java.util.ArrayList;

import loot.*;
import playable.Character;

public class inventoryThread {
	
	//public String test = "C#011" ;
	
	/*public static void main (String []args) {
		inventoryThread t = new inventoryThread();
		System.out.println(t.isConsumable("E#011"));
	}*/
	
	public boolean isConsumable(Loot l) {
		if(l.getId().contains("C")) {
			return true ;
		}
		else {
			return false ;
		}
	}
	
	/*public String showInv(ArrayList<Loot> a) {
		String line ;
		
	}*/
	
	public void equip(Equipment e, Character c) {
		
		
	}

}
