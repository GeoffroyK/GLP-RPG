package inventory;

import java.util.ArrayList;

import loot.*;

public class inventoryThread {
	
	//public String test = "C#011" ;
	
	/*public static void main (String []args) {
		inventoryThread t = new inventoryThread();
		System.out.println(t.isConsumable("C#011"));
	}*/
	
	public boolean isConsumable(Loot l) {
		if(l.getId().contains("C")) {
			return true ;
		}
		else {
			return false ;
		}
	}
	
	public String showInv(ArrayList<Loot> a) {
		String line = " " ;
		for(Loot l : a) {
			line += l.toString();
		}
		return line ;
	}
	
	public void selection (Loot l) {
		if(isConsumable(l)) {
			//use
			//jeter
			//stat
		}
		else {
			//equip
			//jeter
			//stat
		}
	}

}
