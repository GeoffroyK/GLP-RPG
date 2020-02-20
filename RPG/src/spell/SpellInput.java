package spell;

import java.util.Scanner;

import playable.Player;

public class SpellInput /*extends KeyAdapter*/ {


	private Player ply;
	private boolean running = true;
	
	public SpellInput(Player ply) {
		this.ply = ply;
		scannerPressed();
	}

	private void scannerPressed() {
		Scanner sc = new Scanner(System.in);
		
		while(running) {
			String key = sc.nextLine();
			if (key.equals("&")) {
				SpellTreatment.spellUsed(ply,0);
			}
			if (key.equals("é")) {
				SpellTreatment.spellUsed(ply,1);
			}
			if (key.equals('"')) {
				SpellTreatment.spellUsed(ply,2);
			}
			if (key.equals("'")){
				SpellTreatment.spellUsed(ply,3);
			}
			if (key.equals("(")){
				SpellTreatment.spellUsed(ply,4);
			}
			if (key.equals(" ")){
				SpellTreatment.spellUsed(ply,5);
			}
			if (key.equals("q")){
				sc.close();
				running = false;
			}
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
