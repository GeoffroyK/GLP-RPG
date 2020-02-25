package spell;

import map.Map;
import playable.Player;
import playable.PlayerChoice;

public class SpellInput /* extends inputAdapter */ {

	private Player ply;
	private Map map;
	private int[] cooldown = { 0, 0, 0, 0, 0, 0 };
	
	public SpellInput(Map map) {
		ply = PlayerChoice.selected();
		this.map = map;
	}

	public void scannerPressed(String input) {

		switch(input) {
			
		case "w" : isUsable(0);
			break;
			
		case "x" : isUsable(1);
		break;
			
		case "c" : isUsable(2);
		break;
			
		case "v" : isUsable(3);
		break;
			
		case "b" : isUsable(4);
		break;
			
		case " " : isUsable(5);
		break;
		}
	}

	public void isUsable(int number) {
		Spell spell = ply.getSpells()[number];
		System.out.println("NAME : " + spell.getName());
		if (ply.getManaPoint() > spell.getManaUsage()) {
			if (cooldown[number] == 0) {
				SpellTreatment.spellUsed(spell, ply, map);
				int manaConsumed = ply.getManaPoint() - spell.getManaUsage();
				ply.setManaPoint(manaConsumed);
				System.out.println("ManaUsage : " + spell.getManaUsage() + " / ManaLeft : " + ply.getManaPoint());
				cooldown[number] = spell.getCooldown();
			} else {
				for(int i = 0; i<6; i++) {
					if(cooldown[i] > 0) {
						cooldown[i]--;
					}
				}
				System.out.println("WAIT COOLDOWN : " + cooldown[number] + " sec left");
			}
		} else {
			System.out.println("PAS ASSEZ DE MANA \nManaUsage : " + spell.getManaUsage() + " / Mana actuel : " + ply.getManaPoint());
		}

	}

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
