package playable;

import dataclasses.DataBase;

public class PlayerChoice {
	
	public static Player selected() {
		Player ply = null;
		if(DataBase.getInstances().containsKey("pg1")) {
			 ply = (Player) DataBase.getInstances().get("pg1");
		}
		else if(DataBase.getInstances().containsKey("pa2")) {
			 ply = (Player) DataBase.getInstances().get("pa2");
		}
		else if(DataBase.getInstances().containsKey("ps3")) {
			 ply = (Player) DataBase.getInstances().get("ps3");
		}
		return ply;
	}
	
	public static void chooseClassPlayer(String input) {
		boolean state = true;
		while(state) {
			if(input.equals("t")) {
				
				Player ply = (Player) DataBase.getCharacters().get("pg1");
				DataBase.getInstances().put(ply.getId(), ply);
				DataBase.getCharInstances().put(ply.getId(), ply);
				System.out.println("YOU CHOSE WARRIOR");
				state = false;
			}
			else if(input.equals("y")) {
				Player ply = (Player) DataBase.getCharacters().get("pa2");
				DataBase.getInstances().put(ply.getId(), ply);
				DataBase.getCharInstances().put(ply.getId(), ply);
				System.out.println("YOU CHOSE ARCHER");
				state = false;
			}
			else if(input.equals("u")) {
				Player ply = (Player) DataBase.getCharacters().get("ps3");
				DataBase.getInstances().put(ply.getId(), ply);
				DataBase.getCharInstances().put(ply.getId(), ply);
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
	
	public static void EditClass(String input) {
		Player ply = selected();

		
		if(input.equals("t")) {
			ply = (Player) DataBase.getCharacters().get("pg1");
		}
		else if(input.equals("y")) {
			ply = (Player) DataBase.getCharacters().get("pa2");
		}
		else if(input.equals("u")) {
			ply = (Player) DataBase.getCharacters().get("ps3");
		}
	}
	
}
