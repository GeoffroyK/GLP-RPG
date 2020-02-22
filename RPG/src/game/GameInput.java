package game;

import java.util.HashMap;
import java.util.Scanner;

import dataclasses.GameObject;
import map.Map;
import playable.Monster;
import playable.Move;
import spell.SpellInput;

public class GameInput {
	
	private Scanner sc;
	private String input;
	private SpellInput si;
	private Move mi;
	private Map map;
	
	public GameInput(HashMap<String, GameObject> instances) {
		map = new Map();
		sc = new Scanner(System.in);
		si = new SpellInput(instances, map);
		mi = new Move(instances, map);
		mi.getMap().addMonster((Monster) instances.get("ma2"));
		scan();
	}
	
	public void scan() {
		input = sc.nextLine();
		
		if (input.matches("w|x|c|v|b| ")){
			si.scannerPressed(input);
		}
		if(input.matches("z|q|s|d")) {
			mi.move(input);
		}
	}
}
