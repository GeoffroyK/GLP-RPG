package GameState;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class GameStateManager {
	
	private ArrayList<GameState> gameStates;

	private static int currentState;
	
	public static final int MENUSTATE = 0;
	public static final int LEVEL1STATE = 1;
	
	public GameStateManager() {
		gameStates = new ArrayList<GameState>();
		
		currentState = MENUSTATE;
		gameStates.add(new MenuState(this));
		gameStates.add(new Level1State(this));
	}
	
	public void setState(int state) {
		currentState = state;
		gameStates.get(currentState).init();
	}
	
	public void update() {
		gameStates.get(currentState).update();
	}
	
	public void draw(Graphics2D g) {
		gameStates.get(currentState).draw(g);
	}
	
	public void keyPressed(int k) {
		gameStates.get(currentState).keyPressed(k);
	}
	
	public void keyReleased(int k) {
		gameStates.get(currentState).keyReleased(k);
	}
	
	public static int getCurrentState() {
		return currentState;
	}
	
	public ArrayList<GameState> getGameStates() {
		return gameStates;
	}

	public void setGameStates(ArrayList<GameState> gameStates) {
		this.gameStates = gameStates;
	}

	public static int getMenustate() {
		return MENUSTATE;
	}

	public static int getLevel1state() {
		return LEVEL1STATE;
	}

	public static void setCurrentState(int currentState) {
		GameStateManager.currentState = currentState;
	}

}