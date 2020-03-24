package GameState;

import java.awt.Graphics2D;
import java.util.ArrayList;

import game.Game;

public class GameStateManager {
	
	private static ArrayList<GameState> gameStates;

	private static int currentState;
	
	public static final int MENUSTATE = 0;
	public static final int INGAMESTATE = 1;
	public static final int INVENTORYSTATE = 2 ;
	
	public GameStateManager(Game game) {
		gameStates = new ArrayList<GameState>();
		
		currentState = MENUSTATE;
		gameStates.add(new MenuState());
		gameStates.add(new InGameState());
		gameStates.add(new InventoryState(game));
	}
	
	public static void setState(int state) {
		currentState = state;
		gameStates.get(currentState).init();
	}
	
	public void tick() {
		gameStates.get(currentState).tick();
	}
	
	public void render(Graphics2D g) {
		gameStates.get(currentState).render(g);
	}
	
	public static int getCurrentState() {
		return currentState;
	}
	
	public static ArrayList<GameState> getGameStates() {
		return gameStates;
	}

	public void setGameStates(ArrayList<GameState> gameStates) {
		this.gameStates = gameStates;
	}

	public static int getMenustate() {
		return MENUSTATE;
	}

	public static int getInGameState() {
		return INGAMESTATE;
	}

	public static GameState getGameState() {
		return gameStates.get(INGAMESTATE);
	}
	
	public static void setCurrentState(int currentState) {
		GameStateManager.currentState = currentState;
	}

}
