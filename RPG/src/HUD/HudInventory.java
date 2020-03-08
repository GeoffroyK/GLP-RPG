package HUD;

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
import loot.Loot;
import playable.Player;

public class HudInventory implements MouseListener{
	
	private Image background = null ;
	private ArrayList<Rectangle> r;
	private Point click ;
	private int searchState = 0 ;
	
	public HudInventory(Game game) {
		try {
		    background = ImageIO.read(new File("C:\\Users\\Vortex\\Documents\\Inventory\\Background.png"));
		} catch (IOException e) {}
		game.addMouseListener(this);
	}
	
	public void clickableZoneCreation(Player hero) {
		int x = 21 ;
		int y = 69 ;
		
		r = new ArrayList<Rectangle>() ;
		for(Loot l : hero.getInventory().getDrops()) {
			Rectangle rDs = new Rectangle(x, y, 20, 20) ;
			r.add(rDs);
			
			x += 40 ;
			if(x > 330) {
				x = 0 ;
				y += 26 ;
			}
		}
		
	}
	
	public void clickableZoneErase() {
		r.clear();
	}
	
	public void render(Player hero, Graphics g) {
			int x = 21 ;
			int y = 69 ;

	
			g.drawImage(background, 0, 0, null) ;
		
			for(Loot l : hero.getInventory().getDrops()) {
				Image lootSprite = null ;
				
				try {
				    lootSprite = ImageIO.read(new File(l.getSpritePath()));
				} catch (IOException e) {}
				
				g.drawImage(lootSprite, x, y, null) ;
				g.drawString("x" + Integer.toString(l.getItemCounter()), x+20, y+20);
				
				x += 40 ;
				if(x > 330) {
					x = 0 ;
					y += 26 ;
				}
				//System.out.println("LOOP");
			}
		
	}
	
	public void selection(Player hero, Point e, Rectangle w, int index, Graphics g) {
		if(w.contains(e)) {
			System.out.println(hero.getInventory().getDrops().get(index));
			searchState = 0 ;
		}
	}
	
	public void checking(Player hero, Graphics g) {
		if(searchState == 1) {
			for(Rectangle w : r) {
				selection(hero, click, w, r.indexOf(w), g) ;
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
