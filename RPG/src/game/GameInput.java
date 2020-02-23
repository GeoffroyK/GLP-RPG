package game;

import java.util.HashMap;
import java.util.Scanner;

import dataclasses.GameObject;
import map.Map;
import map_objects.Prop;
import map_objects.PropInput;
import map_objects.PropTreatment;
import playable.Monster;
import playable.Move;
import spell.SpellInput;

public class GameInput {
	
	private Scanner sc;
	private String input;
	private SpellInput si;
	private Move mi;
	private Map map;
	private PropInput pi;
	private boolean running = true;
	
	public GameInput(HashMap<String, GameObject> instances) {
		map = new Map();
		sc = new Scanner(System.in);
		si = new SpellInput(instances, map);
		mi = new Move(instances, map);
		mi.getMap().addMonster((Monster) instances.get("ma2"));
		scan();
	}
	
	public void scan() {
		System.out.println("MOVE : 'Z' = UP / 'S' = DOWN / 'Q' = LEFT / 'D' = RIGHT");
		System.out.println("ATTACK WITH 5 SPELLS AND 1 AUTO ATTACK : 'W,X,C,V,B' = SPELLS / 'SPACE' = AUTOATTACK");
		System.out.println("EXIT = 'E");
		while(running) {
			input = sc.nextLine();
			
			if (input.matches("w|x|c|v|b| ")){
				si.scannerPressed(input);
			}
			else if(input.matches("z|q|s|d")) {
				mi.move(input);
			}
			//Add Geo
			else if(input.equals("a")) {
				pi.propAction();
			}
			else if(input.equals("e")) {
				System.out.println("CLOSING GAME");
				running = false;
			}
		}
		
		sc.close();
	}
}
