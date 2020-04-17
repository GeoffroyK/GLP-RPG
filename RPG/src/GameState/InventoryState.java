package GameState;

import java.awt.Graphics2D;

import HUD.inventory.HudInventory;
import InputControl.InputGame;
import game.Game;
import map_objects.Seller;
import playable.PlayerChoice;
/*
 * 
 * State when you open the inventory window
 */
public class InventoryState implements GameState{
	
	public HudInventory inv ;

	public InventoryState(Game game) {
		inv = new HudInventory(game);
	}

	@Override
	public void init() {
		inv.clickableAreaCreation(PlayerChoice.selected());
	}

	@Override
	public void tick() {
		InputGame.other(inv);
		inv.checking(PlayerChoice.selected());
	}

	@Override
	public void render(Graphics2D g) {
		inv.render(PlayerChoice.selected(), g);	
	}

}
