package playable;

import java.util.HashMap;
import java.util.Scanner;

import dataclasses.DataBase;
import dataclasses.GameObject;

public class PlayerChoice {
	
	public static Player selected(HashMap<String, GameObject> instances) {
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
	
	public static void chooseClassPlayer(String input) {
		boolean state = true;
		while(state) {
			if(input.equals("t")) {
				
				Player ply = (Player) DataBase.getCharacters().get("pg1");
				DataBase.getInstances().put(ply.getId(), ply);
				System.out.println("YOU CHOSE WARRIOR");
				state = false;
			}
			else if(input.equals("y")) {
				Player ply = (Player) DataBase.getCharacters().get("pa2");
				DataBase.getInstances().put(ply.getId(), ply);
				System.out.println("YOU CHOSE ARCHER");
				state = false;
			}
			else if(input.equals("u")) {
				Player ply = (Player) DataBase.getCharacters().get("ps3");
				DataBase.getInstances().put(ply.getId(), ply);
				System.out.println("YOU CHOSE MAGE");
				state = false;
			}
			else if(input.equals("e")) {
				System.out.println("CLOSING GAME");
				System.exit(0);
			}
			else {
				System.out.println("WRONG KEY");
			}
		}
		
	}
	
}
