package game;

import static InputControl.InputData.getAutoAttack;
import static InputControl.InputData.getDown;
import static InputControl.InputData.getInventaire;
import static InputControl.InputData.getLeft;
import static InputControl.InputData.getRight;
import static InputControl.InputData.getSpell1;
import static InputControl.InputData.getSpell2;
import static InputControl.InputData.getSpell3;
import static InputControl.InputData.getSpell4;
import static InputControl.InputData.getSpell5;
import static InputControl.InputData.getUp;

import java.util.Scanner;

import dataclasses.DataBase;
import inventory.InventoryKey;
import map.Map;
import map_objects.Prop;
import map_objects.PropInput;
import playable.Monster;
import playable.Move;
import playable.MoveTreatment;
import playable.Player;
import playable.PlayerChoice;
import spell.SpellInput;

public class GameInput {
	
	private Scanner sc;
	private String input;
	private SpellInput si;
	private Move mi;
	private Map map;
	private Player plyr ;
	private PropInput pi;
	private boolean running = true;
	
	public GameInput() {
		map = new Map();
		si = new SpellInput(map);
		pi = new PropInput(map);
		pi.getMap().addProp((Prop) DataBase.getInstances().get("id"));
		mi = new Move(map);
		mi.getMap().addMonster((Monster) DataBase.getInstances().get("ma2"));
		plyr = PlayerChoice.selected();
	}
	
	
}

