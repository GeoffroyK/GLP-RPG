package HUD.inventory;

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
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import javax.imageio.ImageIO;

import dataclasses.DataBase;
import game.Game;
import inventory.InventoryKey;
import inventory.InventoryThread;
import loot.Loot;
import playable.Player;

public class HudInventory implements MouseListener{
	
	private Image background = null ;
	
	private ArrayList<Rectangle> clickableArea ;
	private ArrayList<Rectangle> ActionArea ;
	private Rectangle selected = null ;
	
	private Point click ;
	private int searchState = 0 ;
	
	public HudInventory(Game game) {
		try {
		    background = ImageIO.read(new File("Ressources//HUD//InventoryHUD//Background.png"));
		} catch (IOException e) {}
		game.addMouseListener(this);
	}
	
	public void clickableAreaCreation(Player hero) {
		clickableActionAreaCreation();
		clickableLootAreaCreation(hero);
	}
	
	public void clickableActionAreaCreation() {
		ActionArea = new ArrayList<Rectangle>() ;
		Rectangle equip = new Rectangle(Game.WIDTH/2 - 238, Game.HEIGHT/2 + 112, 102, 32);
		Rectangle throwAway = new Rectangle(Game.WIDTH/2 - 122, Game.HEIGHT/2 + 112, 102, 32);
		Rectangle detail = new Rectangle(Game.WIDTH/2 - 7, Game.HEIGHT/2 + 112, 102, 32);
		ActionArea.add(equip);
		ActionArea.add(throwAway);
		ActionArea.add(detail);
		System.out.println(ActionArea.indexOf(equip));
	}
	
	public void clickableLootAreaCreation(Player hero) {
		int x = Game.WIDTH/2 - 229 ;
		int y = Game.HEIGHT/2 - 181 ;
		
		selected = null ;
		
		clickableArea = new ArrayList<Rectangle>() ;
		for(Loot l : hero.getInventory().getDrops()) {
			Rectangle rDs = new Rectangle(x, y, 19, 19) ;
			clickableArea.add(rDs);
			
			x += 40 ;
			if(x > Game.WIDTH/2 + 80) {
				x = Game.WIDTH/2 - 229 ;
				y += 26 ;
			}
		}
	}
	
	public void clickableZoneErase() {
		clickableArea.clear();
		ActionArea.clear();
	}
	
	public void render(Player hero, Graphics g) {
			int x = Game.WIDTH/2 - 229 ;
			int y = Game.HEIGHT/2 - 181 ;

			g.setColor(Color.BLACK);
			//g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
			g.drawImage(background, Game.WIDTH/2 -250, Game.HEIGHT/2 - 250, null) ;
		
			for(Loot l : hero.getInventory().getDrops()) {
				Image lootSprite = null ;
				
				try {
				    lootSprite = ImageIO.read(new File(l.getSpritePath()));
				} catch (IOException e) {}
				
				g.drawImage(lootSprite, x, y, null) ;
				g.drawString("x" + Integer.toString(l.getItemCounter()), x+20, y+20);
				
				x += 40 ;
				if(x > Game.WIDTH/2 + 80) {
					x = Game.WIDTH/2 - 229 ;
					y += 26 ;
				}
			}
			
			if(selected != null) {
				g.setColor(Color.RED);
				g.drawRect(selected.x, selected.y, selected.width, selected.height);
			}
			
		
	}
	
	public void selection(Player hero, Point e, Rectangle w, int index) {
		if(w.contains(e)) {
			selected = w ;
			searchState = 0 ;
		}
		
	}
	
	public void action(Player hero, Point e, Rectangle a, int choice) {
		if(a.contains(e)) {
			if(selected != null) {
				InventoryThread.Action(hero.getInventory().getDrops().get(clickableArea.indexOf(selected)), choice, hero);
				clickableLootAreaCreation(hero);
				searchState=0 ;
			}
		}
	}
	
	public void checking(Player hero) {
		if(searchState == 1) {
			for(Rectangle w : clickableArea) {
				selection(hero, click, w, clickableArea.indexOf(w)) ;
			}
			for(Rectangle a : ActionArea) {
				action(hero, click, a, ActionArea.indexOf(a));
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
