package map_objects;

import dataclasses.DataBase;
import inventory.InventoryKey;
import playable.Player;
import playable.PlayerChoice;

/*
 * Treatment of chest, give the loot when opened and make animation 
 */
public class ChestTreatment {

	public static void ChestOpen(Chest c) {
		if(c.getState() != 1) {
			System.out.println(DataBase.getLoots().get(c.getDropID()));
			InventoryKey.addLoot(DataBase.getLoots().get(c.getDropID()), PlayerChoice.selected());
			PlayerChoice.selected().getInventory().setGold(PlayerChoice.selected().getInventory().getGold() + c.getMoneyDrop());
			c.setSpritePath("Ressources//Sprite//Props//ChestoOpen.png");
			c.setState(1);
		}
			
	}
}
