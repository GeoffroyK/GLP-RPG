package spell;

import java.util.HashMap;

import dataclasses.DataBase;
import dataclasses.GameObject;
import map.Map;
import playable.Player;
import playable.PlayerChoice;

public class SpellInput /*extends inputAdapter*/ {


	private Player ply;
	private Map map;
	
	public SpellInput(Map map) {
		ply = PlayerChoice.selected(DataBase.getInstances());
		this.map = map;
		int cooldown[] = {0,0,0,0,0,0};
	}

	/*public void scannerPressed(String input) {
		
		if (input.equals("w")) {
			SpellTreatment.spellUsed(instances,ply,0,map);
		}
		if (input.equals("x")) {
			SpellTreatment.spellUsed(instances,ply,1,map);
		}
		if (input.equals("c")) {
			SpellTreatment.spellUsed(instances,ply,2,map);
		}
		if (input.equals("v")){
			SpellTreatment.spellUsed(instances,ply,3,map);
		}
		if (input.equals("b")){
			SpellTreatment.spellUsed(instances,ply,4,map);
		}
		if (input.equals(" ")){
			SpellTreatment.spellUsed(instances,ply,5,map);
		}
	}*/
	
//	public void inputPressed(inputEvent e) {
//		int input = e.getinputCode();
//
//		if (input == inputEvent.VK_1) {
////			SpellTreatment.spellUsed(db,ply,"1");
//		}
//		if (input == inputEvent.VK_2) {
////			SpellTreatment.spellUsed(db,ply,"2");
//		}
//		if (input == inputEvent.VK_3) {
////			SpellTreatment.spellUsed(db,ply,"3");
//		}
//		if (input == inputEvent.VK_4){
////			SpellTreatment.spellUsed(db,ply,"4");
//		}
//		if (input == inputEvent.VK_5){
//			SpellTreatment.spellUsed(db,ply,"5");
//		}
//		if (input == inputEvent.VK_SPACE){
////			SpellTreatment.spellUsed(db,ply,"6");
//		}
//		
//		
//	}
}
