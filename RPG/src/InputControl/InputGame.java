package InputControl;

import static InputControl.InputData.*;

import GameState.GameStateManager;
import GameState.InGameState;
import GameState.MenuState;
import HUD.inventory.HudInventory;
import playable.Player;
import playable.PlayerChoice;

public class InputGame {
	
	private static MenuState menuState;
	private static InGameState lvl1State;
	
/*	public void inputLog(GameStateManager gsm) {
		switch(GameStateManager.getCurrentState()) {
		
		case GameStateManager.MENUSTATE :
			menu(gsm) ;
		
		case GameStateManager.INGAMESTATE :
			move(gsm) ;
			break;
			
		}	
	}*/
	
	public static void menu() {
		System.out.println(GameStateManager.getCurrentState());
		menuState = (MenuState) GameStateManager.getGameStates().get(GameStateManager.getCurrentState());
		if(getUp().isPressed()) {
			menuState.setCurrentChoice(menuState.getCurrentChoice()-1);
			if(menuState.getCurrentChoice() == -1) {
				menuState.setCurrentChoice(menuState.getOptions().length -1);
			}
		}
		if(getDown().isPressed()) {
			menuState.setCurrentChoice(menuState.getCurrentChoice()+1);
			if(menuState.getCurrentChoice() == menuState.getOptions().length) {
				menuState.setCurrentChoice(0);
			}
		}
		if(getEnter().isPressed()) {
			menuState.setSelected(true);
		}
	}
	
	public static void move() {
		lvl1State = (InGameState) GameStateManager.getGameStates().get(GameStateManager.getCurrentState());
		Player ply = PlayerChoice.selected();
		if ((getDown().isPressed() && getUp().isPressed())) { // UP AND DOWN
			ply.setVelY(0);
		} else if (getUp().isPressed()) { // UP
			ply.setVelY(-5);
			lvl1State.getTileMap().setPosition((-1) * ply.getX(),(-1) * ply.getY() );
			
		} else if (getDown().isPressed()) { // DOWN
			ply.setVelY(5);
			lvl1State.getTileMap().setPosition((-1) * ply.getX(),(-1) * ply.getY() );
		} else {
			ply.setVelY(0);
		}

		if (getLeft().isPressed() && getRight().isPressed()) { // LEFT AND RIGHT
			ply.setVelX(0);
		} else if (getLeft().isPressed()) { // LEFT
			ply.setVelX(-5);
			lvl1State.getTileMap().setPosition( (-1) *ply.getX(),(-1) * ply.getY() );
		}
		else if (getRight().isPressed()) { // RIGHT
			ply.setVelX(5);
			lvl1State.getTileMap().setPosition((-1) * ply.getX(),(-1) * ply.getY() );
		}
		else {
			ply.setVelX(0);
		}
		
		if(getInventaire().isPressed()) {
			GameStateManager.setState(GameStateManager.INVENTORYSTATE);
		}	
	}
	
	public static void other(HudInventory inv) {
		if(GameStateManager.getCurrentState() != 1) {
			if(getSpell1().isPressed()) {
				inv.clickableZoneErase();
				GameStateManager.setCurrentState(GameStateManager.INGAMESTATE);
			}
		}
	}

}
