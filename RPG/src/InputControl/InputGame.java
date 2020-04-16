package InputControl;

import static InputControl.InputData.*;

import GameState.GameStateManager;
import GameState.InGameState;
import GameState.MenuState;
import HUD.inventory.HudInventory;
import dataclasses.DataBase;
import inventory.InventoryKey;
import inventory.InventoryThread;
import map_objects.PropsTreatment;
import playable.Player;
import playable.PlayerChoice;
import spell.SpellTreatment;

public class InputGame {
	
	private static MenuState menuState;
	private static InGameState lvl1State;
	private static boolean pressed = true;
	
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
	        int slow = 0 ;

	        System.out.println(GameStateManager.getCurrentState());
	        menuState = (MenuState) GameStateManager.getGameStates().get(GameStateManager.getCurrentState());

	        if(getUp().isPressed() && pressed) {
	            menuState.setCurrentChoice(menuState.getCurrentChoice()-1);
	            if(menuState.getCurrentChoice() == -1) {
	                menuState.setCurrentChoice(menuState.getOptions().length -1);
	            }
	            pressed = false ;
	        }
	        if(getDown().isPressed() && pressed) {
	            menuState.setCurrentChoice(menuState.getCurrentChoice()+1);
	            if(menuState.getCurrentChoice() == menuState.getOptions().length) {
	                menuState.setCurrentChoice(0);
	            }
	            pressed = false;
	        }
	        if(!getDown().isPressed() && !getUp().isPressed()) {
	            pressed = true;
	        }
	        if(getEnter().isPressed()) {
	            menuState.setSelected(true);
	        }
	    }
	
	public static void move() {
		lvl1State = (InGameState) GameStateManager.getGameStates().get(GameStateManager.getCurrentState());
		Player ply = PlayerChoice.selected();
		if ((getDown().isPressed() && getUp().isPressed())) { // UP AND DOWN
			ply.setDirection(3);
			ply.setVelY(0);
		} else if (getUp().isPressed()) { // UP
			ply.setDirection(0);
			ply.setVelY(-2);
			lvl1State.getTileMap().setPosition((-1) * ply.getX(),(-1) * ply.getY() );
			
		} else if (getDown().isPressed()) { // DOWN
			ply.setDirection(3);
			ply.setVelY(2);
			lvl1State.getTileMap().setPosition((-1) * ply.getX(),(-1) * ply.getY() );
		} else {
			ply.setVelY(0);
		}

		if (getLeft().isPressed() && getRight().isPressed()) { // LEFT AND RIGHT
			ply.setDirection(3);
			ply.setVelX(0);
		} else if (getLeft().isPressed()) { // LEFT
			ply.setDirection(1);
			ply.setVelX(-2);
			lvl1State.getTileMap().setPosition( (-1) *ply.getX(),(-1) * ply.getY() );
		}
		else if (getRight().isPressed()) { // RIGHT
			ply.setDirection(2);
			ply.setVelX(2);
			lvl1State.getTileMap().setPosition((-1) * ply.getX(),(-1) * ply.getY() );
		}
		else {
			ply.setVelX(0);
		}
		
		// DIRECTION -----
		
		if (getLeft().isPressed() && getUp().isPressed()) { // LEFT AND UP  => NORTH/WEST
			ply.setDirection(10);
		}
		else if (getLeft().isPressed() && getDown().isPressed()) { // LEFT AND DOWN => SOUTH/WEST
			ply.setDirection(31);
		}
		else if (getUp().isPressed() && getRight().isPressed()) { // UP AND RIGHT => NORTH/EAST
			ply.setDirection(20);
		}
		else if (getDown().isPressed() && getRight().isPressed()) { // DOWN AND RIGHT => SOUTH/EAST
			ply.setDirection(32);
		}
		
		if(getInventaire().isPressed()) {
			GameStateManager.setState(GameStateManager.INVENTORYSTATE);
		}	
		
		if(getEnter().isPressed()) {
			PropsTreatment.check();
		}
	}
	
	public static void spells() {
		Player ply = PlayerChoice.selected();
		if(getSpell1().isPressed()) {
			SpellTreatment.spellUsed(ply.getSpells()[0], 0);
		}
		if(getSpell2().isPressed()) {
			SpellTreatment.spellUsed(ply.getSpells()[1], 1);
		}
		if(getSpell3().isPressed()) {
			SpellTreatment.spellUsed(ply.getSpells()[2], 2);
		}
		if(getSpell4().isPressed()) {
			SpellTreatment.spellUsed(ply.getSpells()[3], 3);
		}
		if(getSpell5().isPressed()) {
			SpellTreatment.spellUsed(ply.getSpells()[4], 4);
		}
		if(getAutoAttack().isPressed()) {
			SpellTreatment.spellUsed(ply.getSpells()[5], 5);
		}
	}
	
	public static void other(HudInventory inv) {
		if(GameStateManager.getCurrentState() != 1) {
			if(getEnter().isPressed()) {
				inv.clickableZoneErase();
				GameStateManager.setState(GameStateManager.INGAMESTATE);
			}
		}
	}

}
