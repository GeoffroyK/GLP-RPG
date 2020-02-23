package game;

import java.util.HashMap;
import java.util.Scanner;

import dataclasses.GameObject;
import inventory.InventoryKey;
import map.Map;
import map_objects.Prop;
import map_objects.PropInput;
import playable.Monster;
import playable.Move;
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
	
	public GameInput(HashMap<String, GameObject> instances) {
		map = new Map();
		sc = new Scanner(System.in);
		si = new SpellInput(instances, map);
		pi = new PropInput(instances, map);
		pi.getMap().addProp((Prop) instances.get("id"));
		mi = new Move(instances, map);
		mi.getMap().addMonster((Monster) instances.get("ma2"));
		plyr = PlayerChoice.selected(instances);
		scan();
	}
	
	public void scan() {
		System.out.println("MOVE : 'Z' = UP / 'S' = DOWN / 'Q' = LEFT / 'D' = RIGHT");
		System.out.println("ATTACK WITH 5 SPELLS AND 1 AUTO ATTACK : 'W,X,C,V,B' = SPELLS / 'SPACE' = AUTOATTACK");
		System.out.println("OPEN INVENTORY : 'I'");
		System.out.println("EXIT = 'E'");
		while(running) {
			input = sc.nextLine();
			
			if (input.matches("w|x|c|v|b| ")){
				si.scannerPressed(input);
			}
			else if(input.matches("z|q|s|d")) {
				mi.move(input);
			}
			else if(input.equals("i")){
				InventoryKey.choice(plyr);
			}
			else if(input.equals("a")) {
				pi.treatment();
			}
			else if(input.equals("e")) {
				System.out.println("CLOSING GAME");
				running = false;
			}
		}
		
		sc.close();
		}
}

