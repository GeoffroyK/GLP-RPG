package GameState;

import java.awt.Graphics2D;

/*
 * Pattern of Class GameState who represente a State in game like In game in menu ect...
 */

public interface GameState {
	
	/*
	 * Init the state when you set him
	 */
	public abstract void init();
	
	/*
	 * Do the tick of your state
	 */
	public abstract void tick();
	
	/*
	 * Rend the state of your game
	 */
	public abstract void render(Graphics2D g);
}
