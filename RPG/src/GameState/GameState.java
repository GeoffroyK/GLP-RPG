package GameState;

import java.awt.Graphics2D;

public interface GameState {

	public abstract void init();
	public abstract void tick();
	public abstract void render(Graphics2D g);
}
