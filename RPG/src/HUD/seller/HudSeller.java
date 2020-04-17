package HUD.seller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import GameState.GameStateManager;
import game.Game;
import inventory.InventoryThread;
import loot.Loot;
import map_objects.Seller;
import map_objects.SellerTreatment;
import playable.Player;
import playable.PlayerChoice;

public class HudSeller implements MouseListener{
	private Image background = null ;
	
	private ArrayList<Rectangle> clickableArea ;
	private ArrayList<Rectangle> ActionArea ;
	private Rectangle echap ;
	private Rectangle selected = null ;
	
	private Point click ;
	private int searchState = 0 ;
	
	public HudSeller(Game game) {
		try {
		    background = ImageIO.read(new File("Ressources//HUD//SellerHUD//Background.png"));
		} catch (IOException e) {}
		game.addMouseListener(this);
	}
	
	public void clickableAreaCreation(Player hero, Seller saleMan) {
		clickableActionAreaCreation();
		clickableLootAreaCreation(hero, saleMan);
	}
	
	public void clickableActionAreaCreation() {
		ActionArea = new ArrayList<Rectangle>() ;
		Rectangle buy = new Rectangle(Game.WIDTH/2 - 238, Game.HEIGHT/2 + 112, 102, 32);
		Rectangle sell = new Rectangle(Game.WIDTH/2 - 122, Game.HEIGHT/2 + 112, 102, 32);
		Rectangle detail = new Rectangle(Game.WIDTH/2 - 7, Game.HEIGHT/2 + 112, 102, 32);
		echap = new Rectangle(Game.WIDTH/2 + 220, Game.HEIGHT/2 - 250, 30, 13);
		ActionArea.add(buy);
		ActionArea.add(sell);
		ActionArea.add(detail);
		ActionArea.add(echap);
		//System.out.println(ActionArea.indexOf(equip));
	}
	
	public void clickableLootAreaCreation(Player hero, Seller saleMan) {
		int x = Game.WIDTH/2 - 229 ;
		int y = Game.HEIGHT/2 - 181 ;
		
		selected = null ;
		
		clickableArea = new ArrayList<Rectangle>() ;
		for(Loot l : saleMan.getArticle()) {
			Rectangle rDs = new Rectangle(x, y, 39, 39) ;
			clickableArea.add(rDs);
			
			x += 60 ;
			if(x > Game.WIDTH/2 + 80) {
				x = Game.WIDTH/2 - 229 ;
				y += 56 ;
			}
		}
		
		x = Game.WIDTH/2 - 229 ;
		y = Game.HEIGHT/2 + 5 ;
		
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
	
	public void clickableZoneErase() {
		clickableArea.clear();
		ActionArea.clear();
		echap = null; 
	}
	
	public void render(Player hero, Seller saleMan, Graphics g) {
		int x = Game.WIDTH/2 - 229 ;
		int y = Game.HEIGHT/2 - 181 ;

		g.setColor(Color.BLACK);
		//g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		g.drawImage(background, Game.WIDTH/2 -250, Game.HEIGHT/2 - 250, null) ;
		
		g.setColor(Color.WHITE);
		g.drawString(Integer.toString(PlayerChoice.selected().getInventory().getGold()), Game.WIDTH/2 + 180, Game.HEIGHT/2 + 132);
		
		for(Loot l : saleMan.getArticle()) {
			Image lootSprite = null ;
			
			try {
			    lootSprite = ImageIO.read(new File(l.getSpritePath()));
			} catch (IOException e) {}
			
			g.drawImage(lootSprite, x, y, null) ;
			
			x += 60 ;
			if(x > Game.WIDTH/2 + 80) {
				x = Game.WIDTH/2 - 229 ;
				y += 56 ;
			}
		}
		
		x = Game.WIDTH/2 - 229 ;
		y = Game.HEIGHT/2 + 5 ;
	
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
	
	public void selection(Point e, Rectangle w, int index) {
		if(w.contains(e)) {
			selected = w ;
			searchState = 0 ;
		}
		
	}
	
	public void action(Player hero, Seller saleMan, Point e, Rectangle a, int choice) {
		if(a.contains(e)) {
			if(selected != null) {
				if(choice == 1) {
					if(clickableArea.indexOf(selected) - saleMan.getArticle().size() >= 0)
					SellerTreatment.Action(hero.getInventory().getDrops().get(clickableArea.indexOf(selected) - saleMan.getArticle().size()), choice, hero);
				}
				else {
					if(clickableArea.indexOf(selected) < saleMan.getArticle().size()){
						SellerTreatment.Action(saleMan.getArticle().get(clickableArea.indexOf(selected)), choice, hero);
					}	
				}
				clickableLootAreaCreation(hero, saleMan);
				searchState=0 ;
			}
		}
	}
	
	public void echap() {
		clickableZoneErase();
		GameStateManager.setCurrentState(GameStateManager.INGAMESTATE);
		searchState = 0 ;
	}
	
	
	public void checking(Player hero, Seller saleMan) {
		if(searchState == 1) {
			for(Rectangle w : clickableArea) {
				selection(click, w, clickableArea.indexOf(w)) ;
			}
			for(Rectangle a : ActionArea) {
				action(hero, saleMan ,click, a, ActionArea.indexOf(a));
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
