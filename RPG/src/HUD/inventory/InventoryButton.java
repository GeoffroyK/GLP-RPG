package HUD.inventory;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import GameState.GameStateManager;
import game.Game;

public class InventoryButton implements MouseListener {

	private Image background = null ;
	private Rectangle selection = null;
	
	private Point click ;
	private int searchState = 0 ;
	
	public InventoryButton(Game game) {
		try {
			background = ImageIO.read(new File("Ressources//HUD//InventoryHUD//iNVENTORY.png")) ;
		} catch (IOException e) {e.printStackTrace();}
		game.addMouseListener(this);
	}
	
	public void clickableAreaCreation() {
		selection = new Rectangle(Game.WIDTH - 40, Game.HEIGHT/2 - 40, 40, 40);
	}
	
	public void clickableZoneErase() {
		selection = null ;
	}
	
	public void checking() {
		if(searchState == 1) {
			if(selection.contains(click)) {
				if(GameStateManager.getCurrentState() != GameStateManager.INVENTORYSTATE) {
					GameStateManager.setState(GameStateManager.INVENTORYSTATE);
					clickableZoneErase();
				}
			}
		}
		searchState = 0 ;
	}
	
	public void render(Graphics2D g) {
		g.drawImage(background, Game.WIDTH - 40, Game.HEIGHT/2 - 40, null);
	}
	
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
