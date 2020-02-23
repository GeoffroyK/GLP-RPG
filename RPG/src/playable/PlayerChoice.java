package playable;

import java.util.HashMap;

import dataclasses.GameObject;

public class PlayerChoice {
	
	public static Player selected(HashMap<String, GameObject>instances) {
		Player ply = null;
		if(instances.containsKey("pg1")) {
			 ply = (Player) instances.get("pg1");
		}
		else if(instances.containsKey("pa2")) {
			 ply = (Player) instances.get("pa2");
		}
		else if(instances.containsKey("ps3")) {
			 ply = (Player) instances.get("ps3");
		}
		
		return ply;
	}
	
	
}
