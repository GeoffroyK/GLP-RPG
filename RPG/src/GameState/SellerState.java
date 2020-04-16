package GameState;

import java.awt.Graphics2D;

import HUD.inventory.HudInventory;
import HUD.seller.HudSeller;
import dataclasses.DataBase;
import game.Game;
import map_objects.PropsTreatment;
import map_objects.Seller;
import playable.PlayerChoice;

public class SellerState implements GameState{
	
	public HudSeller sale ;
	private int i = 0 ;
	
	public SellerState(Game game){
		sale = new HudSeller(game);
	}

	@Override
	public void init() {
		i = PropsTreatment.id() ;
		System.out.println(i);
		sale.clickableAreaCreation(PlayerChoice.selected() ,(Seller) DataBase.getPropInstance().get(i));
		// TODO Auto-generated method stub
	}

	@Override
	public void tick() {
		sale.checking(PlayerChoice.selected(), (Seller) DataBase.getPropInstance().get(i));
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		sale.render(PlayerChoice.selected(), (Seller) DataBase.getPropInstance().get(i), g);
	}
}
