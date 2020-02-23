package inventory;

import java.util.ArrayList;
import java.util.Scanner;

import loot.*;
import playable.Player;

import static loot.ConsumableTreatment.* ;
import static loot.EquipmentTreatment.* ;
import static inventory.InventoryKey.*;

public class InventoryThread {
	
	public static boolean isConsumable(Loot l) {
		if(l.getId().contains("C")) {
			return true ;
		}
		else {
			return false ;
		}
	}
	
	public static String showInv(Inventory i) {
		String line = "----------------inventoryStart-----------------\n\n" ;
		for(Loot l : i.getDrops()) {
			line += "id : " + l.getId() + " / nom : " + l.getName() + " / possedé : " + l.getItemCounter() ;
			if(!isConsumable(l)) {
				Equipment e = (Equipment) l ;
				if(e.getEquiped()) {
					line += " (Equipée) " ;
				}
			}
			line += "\n" ;
		}
		line += "\nTaille de l'inventaire : " + i.getSize() + "/" + i.getSizeMax() + "\n\n";
		line += "----------------inventoryEnd-------------------\n" ;
		return line ;
	}
	
	public static void Action (Loot lCourant, Player p){
		
		System.out.println("choisissez l'action a effectué : (a: use/equip, b: jeter, c: information)");
		
		Scanner sc  = new Scanner(System.in) ;
		String str = sc.nextLine();
		
		switch(str) {
		case "a" : 
			if(isConsumable(lCourant)) {
				ConsumableTreatment.use((Consumable) lCourant, p);
				InventoryKey.suppLoot(lCourant, p);
			}
			else {
				slotVerif((Equipment) lCourant, p);
			}
			break ;
		
		case "b" :
			InventoryKey.suppLoot(lCourant, p);
			break;
			
		case "c" :
			System.out.println(lCourant.toString());
			break;
		}
	}
	
	public static void slotVerif(Equipment e, Player p) {
		
		switch(e.getType()) {
		
		case "helmet" :
			if(p.getInventory().getHelmet() == null) {
				EquipmentTreatment.equip(e, p);
				p.getInventory().setHelmet(e);
			}
			else {
				EquipmentTreatment.unquip(p.getInventory().getHelmet(), p);
				p.getInventory().setHelmet(e);
				EquipmentTreatment.equip(e, p);
			}
			break ;
		
		case "arms" :
			if(p.getInventory().getArms() == null) {
				EquipmentTreatment.equip(e, p);
				p.getInventory().setArms(e);
			}
			else {
				EquipmentTreatment.unquip(p.getInventory().getArms(), p);
				p.getInventory().setArms(e);
				EquipmentTreatment.equip(e, p);
			}
			break;
		
		case "pants" : 
			if(p.getInventory().getPants() == null) {
				EquipmentTreatment.equip(e, p);
				p.getInventory().setPants(e);
			}
			else {
				EquipmentTreatment.unquip(p.getInventory().getPants(), p);
				p.getInventory().setPants(e);
				EquipmentTreatment.equip(e, p);
			}
			break;
			
		case "chestplate" :
			if(p.getInventory().getChestplate() == null) {
				EquipmentTreatment.equip(e, p);
				p.getInventory().setChestplate(e);
			}
			else {
				EquipmentTreatment.unquip(p.getInventory().getChestplate(), p);
				p.getInventory().setChestplate(e);
				EquipmentTreatment.equip(e, p);
			}
			break;
			
		case "weapon" :
			if(p.getInventory().getWeapon() == null) {
				EquipmentTreatment.equip(e, p);
				p.getInventory().setWeapon(e);
			}
			else {
				EquipmentTreatment.unquip(p.getInventory().getWeapon(), p);
				p.getInventory().setWeapon(e);
				EquipmentTreatment.equip(e, p);
			}
			break;
			
		default : System.err.println("This object have no good type !");	
		
		}
	}

}
