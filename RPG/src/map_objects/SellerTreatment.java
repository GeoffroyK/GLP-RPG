package map_objects;

import inventory.InventoryKey;
import loot.Consumable;
import loot.ConsumableTreatment;
import loot.Equipment;
import loot.Loot;
import playable.Player;
import playable.PlayerChoice;

/*
 * Merchant gestion in the game, buy loot or sell loot in exchange of money
 */
public class SellerTreatment {
	
	public static void buy(Loot l){
		if((int) l.getPrice() < PlayerChoice.selected().getInventory().getGold()) {
			PlayerChoice.selected().getInventory().setGold(PlayerChoice.selected().getInventory().getGold() - (int) l.getPrice());
			InventoryKey.addLoot(l, PlayerChoice.selected());
		}
	}
	
	
	public static void sell(Loot l) {
		PlayerChoice.selected().getInventory().setGold(PlayerChoice.selected().getInventory().getGold() + (int) l.getPrice());
		InventoryKey.suppLoot(l, PlayerChoice.selected());
	}
	
	
	/*
	 * Select actions depending of the choice of the player
	 */
	public static void Action (Loot lCourant, int choice, Player p){
		switch(choice) {
		case  0 : 
			buy(lCourant) ;
			break ;
		
		case 1 :
			sell(lCourant) ;
			break;
			
		case 2 :
			System.out.println(lCourant.toString());
			break;
		}
	}

}
