package playable;
import java.util.HashMap;

import dataclasses.DataBase;
import dataclasses.GameObject;
import map.*;

public class Move {
	
	private Player hero;
	private Map map;
	
	public Move(Map map) {
		hero = PlayerChoice.selected(DataBase.getInstances());
		this.map = map;
	}
	
	public void move(String input) {
		
		System.out.println("Direction ?");
		switch(input) {
			case "z":
				MoveTreatment.reposition(hero, 0, 1, map);
				break;
			case "s":
				MoveTreatment.reposition(hero, 3, 1, map);
				break;
			case "q":
				MoveTreatment.reposition(hero, 1, 1, map);
				break;
			case "d":
				MoveTreatment.reposition(hero, 2, 1, map);
				break;
		}
	}
	public Map getMap() {
		return map;
	}

}
