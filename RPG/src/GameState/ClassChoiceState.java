package GameState;

import java.awt.Graphics2D;

import HUD.ClassSelectionner;
import game.Game;

/*
 *State when you choice your class
 */

public class ClassChoiceState implements GameState {

	public ClassSelectionner c ;
	
	public ClassChoiceState(Game game) {
		// TODO Auto-generated constructor stub
		c = new ClassSelectionner(game);
	}
	@Override
	public void init() {
		c.clickableActionAreaCreation();		// TODO Auto-generated method stub	
	}

	@Override
	public void tick() {
		c.checking();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics2D g) {
		c.render(g);
		// TODO Auto-generated method stub
		
	}

}
