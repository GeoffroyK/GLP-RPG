package HUD;

import java.awt.Color;
import java.awt.Graphics2D;
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
import playable.Player;
import playable.PlayerChoice;

/*
 * this class render the menu of character class selection
 */

public class ClassSelectionner implements MouseListener{
	
	private Image background = null ;
	
	Rectangle wizard = null ;
	Rectangle warrior = null ;
	Rectangle archer = null ;
	
	
	private Point click ;
	private int searchState = 0 ;
	
	public ClassSelectionner(Game game) {
		try {
		    background = ImageIO.read(new File("Ressources//HUD//background_heroselector.png"));
		} catch (IOException e) {}
		game.addMouseListener(this);
	}
	
	/*
	 * Enables the class to be clickable
	 */
	
	public void clickableActionAreaCreation() {
		wizard = new Rectangle(170, 132, 332, 466);
		warrior = new Rectangle(642, 132, 332, 466);
		archer = new Rectangle(1106, 132, 332, 466);
		//System.out.println(ActionArea.indexOf(equip));
	}
	
	/*
	 * Delete the clickable zone when you take a class
	 */
	
	public void erase() {
		wizard = null ;
		warrior = null ;
		archer = null ;
	}
	
	/*
	 * Permite select the class
	 */
	
	public void checking() {
		if(searchState == 1) {
			if(wizard.contains(click)) {
				PlayerChoice.chooseClassPlayer("u");
				GameStateManager.setState(GameStateManager.INGAMESTATE);
			}
			if(warrior.contains(click)) {
				PlayerChoice.chooseClassPlayer("t");
				GameStateManager.setState(GameStateManager.INGAMESTATE);
			}
			if(archer.contains(click)) {
				PlayerChoice.chooseClassPlayer("y");
				GameStateManager.setState(GameStateManager.INGAMESTATE);
			}
		}
		
		searchState = 0 ;
	}
	
	public void render(Graphics2D g) {
		g.setColor(Color.RED);
		//g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		g.drawImage(background, 0, 0, null) ;
		g.draw(wizard);
		g.draw(warrior);
		g.draw(archer);
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
