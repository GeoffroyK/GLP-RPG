package HUD.inventory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.AreaAveragingScaleFilter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import javax.imageio.ImageIO;

import GameState.GameStateManager;
import dataclasses.DataBase;
import game.Game;
import inventory.InventoryKey;
import inventory.InventoryThread;
import loot.Loot;
import playable.Player;
import playable.PlayerChoice;

/*
 * Create the window of InventoryState and the clickable selection area
 */
public class HudInventory implements MouseListener{
	
	private Image background = null ;
	
	private ArrayList<Rectangle> clickableArea ;
	private ArrayList<Rectangle> ActionArea ;
	private Rectangle echap ;
	private Rectangle selected = null ;
	
	private Point click ;
	private int searchState = 0 ;
	
	public HudInventory(Game game) {
		try {
		    background = ImageIO.read(new File("Ressources//HUD//InventoryHUD//Background.png"));
		} catch (IOException e) {}
		game.addMouseListener(this);
	}
	
	
	/*
	 * Determinate all clickable area of the Inventory
	 */
	public void clickableAreaCreation(Player hero) {
		clickableActionAreaCreation();
		clickableLootAreaCreation(hero);
	}
	
	
	/*
	 * Actions that the player can do : Equip/Throww/Detail
	 */
	public void clickableActionAreaCreation() {
		ActionArea = new ArrayList<Rectangle>() ;
		Rectangle equip = new Rectangle(Game.WIDTH/2 - 238, Game.HEIGHT/2 + 112, 102, 32);
		Rectangle throwAway = new Rectangle(Game.WIDTH/2 - 122, Game.HEIGHT/2 + 112, 102, 32);
		Rectangle detail = new Rectangle(Game.WIDTH/2 - 7, Game.HEIGHT/2 + 112, 102, 32);
		echap = new Rectangle(Game.WIDTH/2 + 220, Game.HEIGHT/2 - 250, 30, 13);
		ActionArea.add(equip);
		ActionArea.add(throwAway);
		ActionArea.add(detail);
		ActionArea.add(echap);
		//System.out.println(ActionArea.indexOf(equip));
	}
	
	
	/*
	 * Enables the loot to be clickable
	 */
	public void clickableLootAreaCreation(Player hero) {
		int x = Game.WIDTH/2 - 229 ;
		int y = Game.HEIGHT/2 - 181 ;
		
		selected = null ;
		
		clickableArea = new ArrayList<Rectangle>() ;
		for(Loot l : hero.getInventory().getDrops()) {
			Rectangle rDs = new Rectangle(x, y, 39, 39) ;
			clickableArea.add(rDs);
			
			x += 60 ;
			if(x > Game.WIDTH/2 + 80) {
				x = Game.WIDTH/2 - 229 ;
				y += 56 ;
			}
		}
	}
	
	/*
	 * Delete the clickable zone when this close
	 */
	public void clickableZoneErase() {
		clickableArea.clear();
		ActionArea.clear();
		echap = null; 
	}
	
	/*
	 * Render the clickable area and images
	 */
	public void render(Player hero, Graphics g) {
			int x = Game.WIDTH/2 - 229 ;
			int y = Game.HEIGHT/2 - 181 ;

			g.setColor(Color.BLACK);
			//g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
			g.drawImage(background, Game.WIDTH/2 -250, Game.HEIGHT/2 - 250, null) ;
			
			g.setColor(Color.WHITE);
			g.drawString(Integer.toString(PlayerChoice.selected().getInventory().getGold()), Game.WIDTH/2 + 180, Game.HEIGHT/2 + 132);
		
			for(Loot l : hero.getInventory().getDrops()) {
				Image lootSprite = null ;
				
				try {
				    lootSprite = ImageIO.read(new File(l.getSpritePath()));
				} catch (IOException e) {}
				
				g.drawImage(lootSprite, x, y, null) ;
				g.drawString("x" + Integer.toString(l.getItemCounter()), x+40, y+40);
				
				x += 60 ;
				if(x > Game.WIDTH/2 + 230) {
					x = Game.WIDTH/2 - 229 ;
					y += 56 ;
				}
			}
			
			if(selected != null) {
				g.setColor(Color.RED);
				g.drawRect(selected.x, selected.y, selected.width, selected.height);
			}
			
	}
	
	/*
	 * Permite select the item
	 */
	
	public void selection(Player hero, Point e, Rectangle w, int index) {
		if(w.contains(e)) {
			selected = w ;
			searchState = 0 ;
		}
		
	}
	
	/*
	 * Do the good action and stop searchState
	 */
	
	public void action(Player hero, Point e, Rectangle a, int choice) {
		if(a.contains(e)) {
			if(selected != null) {
				InventoryThread.Action(hero.getInventory().getDrops().get(clickableArea.indexOf(selected)), choice, hero);
				clickableLootAreaCreation(hero);
				searchState=0 ;
			}
		}
	}
	
	/*
	 * Close the inventory and destroy the clicakble area
	 */
	public void echap() {
		clickableZoneErase();
		GameStateManager.setCurrentState(GameStateManager.INGAMESTATE);
		searchState = 0 ;
		
	}
	
	/*
	 * searching a click by user
	 */
	
	public void checking(Player hero) {
		if(searchState == 1) {
			for(Rectangle w : clickableArea) {
				selection(hero, click, w, clickableArea.indexOf(w)) ;
			}
			for(Rectangle a : ActionArea) {
				action(hero, click, a, ActionArea.indexOf(a));
			}
			if(echap.contains(click)) {
				echap() ;
			}
		}
		searchState = 0 ;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		click = e.getPoint() ;
		searchState = 1 ;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
