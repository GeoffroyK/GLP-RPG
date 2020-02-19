package spell;

import java.util.Scanner;

import dataclasses.DataBase;
import playable.Player;

public class SpellInput /*extends KeyAdapter*/ {

	private DataBase db;
	private Player ply;
	
	public SpellInput(DataBase db, Player ply) {
		this.db = db;
		this.ply = ply;
		scannerPressed();
	}

	@SuppressWarnings("unlikely-arg-type")
	private void scannerPressed() {
		Scanner sc = new Scanner(System.in);
		String key = sc.nextLine();
		if (key.equals("&")) {
			SpellTreatment.spellUsed(db,ply,"1");
		}
		if (key.equals("é")) {
			SpellTreatment.spellUsed(db,ply,"2");
		}
		if (key.equals('"')) {
			SpellTreatment.spellUsed(db,ply,"3");
		}
		if (key.equals("'")){
			SpellTreatment.spellUsed(db,ply,"4");
		}
		if (key.equals("(")){
			SpellTreatment.spellUsed(db,ply,"5");
		}
		if (key.equals(" ")){
			SpellTreatment.spellUsed(db,ply,"6");
		}
	}
	
//	public void keyPressed(KeyEvent e) {
//		int key = e.getKeyCode();
//
//		if (key == KeyEvent.VK_1) {
////			SpellTreatment.spellUsed(db,ply,"1");
//		}
//		if (key == KeyEvent.VK_2) {
////			SpellTreatment.spellUsed(db,ply,"2");
//		}
//		if (key == KeyEvent.VK_3) {
////			SpellTreatment.spellUsed(db,ply,"3");
//		}
//		if (key == KeyEvent.VK_4){
////			SpellTreatment.spellUsed(db,ply,"4");
//		}
//		if (key == KeyEvent.VK_5){
//			SpellTreatment.spellUsed(db,ply,"5");
//		}
//		if (key == KeyEvent.VK_SPACE){
////			SpellTreatment.spellUsed(db,ply,"6");
//		}
//		
//		
//	}
}
