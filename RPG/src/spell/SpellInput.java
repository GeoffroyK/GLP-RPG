package spell;

import java.util.HashMap;

import dataclasses.GameObject;
import map.Map;
import playable.Player;
import playable.PlayerChoice;

public class SpellInput /* extends inputAdapter */ {

	private Player ply;
	private Map map;
	private HashMap<String, GameObject> instances;
	private int[] cooldown = { 0, 0, 0, 0, 0, 0 };

	public SpellInput(HashMap<String, GameObject> instances, Map map) {
		this.instances = instances;
		ply = PlayerChoice.selected(instances);
		this.map = map;
	}

	public void scannerPressed(String input) {

		if (input.equals("w")) {
			Spell spell = ply.getSpells()[0];
			System.out.println("NAME : " + spell.getName());
			if (ply.getManaPoint() > spell.getManaUsage()) {
				if (cooldown[0] == 0) {
					SpellTreatment.spellUsed(instances, spell, ply, map);
					int manaConsumed = ply.getManaPoint() - spell.getManaUsage();
					ply.setManaPoint(manaConsumed);
					System.out.println("ManaUsage : " + spell.getManaUsage() + " / ManaLeft : " + ply.getManaPoint());
					cooldown[0] = spell.getCooldown();
				} else {
					for(int i = 0; i<6; i++) {
						if(cooldown[i] > 0) {
							cooldown[i]--;
						}
					}
					System.out.println("WAIT COOLDOWN : " + cooldown[0] + " Left");

				}
			} else {
				System.out.println("PAS ASSEZ DE MANA \nManaUsage : " + spell.getManaUsage() + " / Mana actuel : " + ply.getManaPoint());
			}

		}
		if (input.equals("x")) {
			Spell spell = ply.getSpells()[1];

			System.out.println("NAME : " + spell.getName());
			if (ply.getManaPoint() > spell.getManaUsage()) {
				if (cooldown[1] == 0) {
					SpellTreatment.spellUsed(instances, spell, ply, map);
					int manaConsumed = ply.getManaPoint() - spell.getManaUsage();
					ply.setManaPoint(manaConsumed);
					System.out.println("ManaUsage : " + spell.getManaUsage() + " / ManaLeft : " + ply.getManaPoint());

					cooldown[1] = spell.getCooldown();
				} else {
					for(int i = 0; i<6; i++) {
						if(cooldown[i] > 0) {
							cooldown[i]--;
						}
					}
					System.out.println("WAIT COOLDOWN : " + cooldown[1] + " Left");

				}
			} else {
				System.out.println("PAS ASSEZ DE MANA \nManaUsage : " + spell.getManaUsage() + " / Mana actuel : " + ply.getManaPoint());
			}
		}
		if (input.equals("c")) {
			Spell spell = ply.getSpells()[2];
			System.out.println("NAME : " + spell.getName());
			if (ply.getManaPoint() > spell.getManaUsage()) {
				if (cooldown[2] == 0) {
					SpellTreatment.spellUsed(instances, spell, ply, map);
					int manaConsumed = ply.getManaPoint() - spell.getManaUsage();
					ply.setManaPoint(manaConsumed);
					System.out.println("ManaUsage : " + spell.getManaUsage() + " / ManaLeft : " + ply.getManaPoint());
					cooldown[2] = spell.getCooldown();
				} else {
					for(int i = 0; i<6; i++) {
						if(cooldown[i] > 0) {
							cooldown[i]--;
						}
					}
					System.out.println("WAIT COOLDOWN : " + cooldown[2] + " Left");
				}
			} else {
				System.out.println("PAS ASSEZ DE MANA \nManaUsage : " + spell.getManaUsage() + " / Mana actuel : " + ply.getManaPoint());
			}
		}
		if (input.equals("v")) {
			Spell spell = ply.getSpells()[3];
			System.out.println("NAME : " + spell.getName());
			if (ply.getManaPoint() > spell.getManaUsage()) {
				if (cooldown[3] == 0) {
					SpellTreatment.spellUsed(instances, spell, ply, map);
					int manaConsumed = ply.getManaPoint() - spell.getManaUsage();
					ply.setManaPoint(manaConsumed);
					System.out.println("ManaUsage : " + spell.getManaUsage() + " / ManaLeft : " + ply.getManaPoint());
					cooldown[3] = spell.getCooldown();
				} else {
					for(int i = 0; i<6; i++) {
						if(cooldown[i] > 0) {
							cooldown[i]--;
						}
					}
					System.out.println("WAIT COOLDOWN : " + cooldown[3] + " Left");
				}
				if (cooldown[3] == spell.getCooldown()) {
					cooldown[3] = 0;
				}
			} else {
				System.out.println("PAS ASSEZ DE MANA \nManaUsage : " + spell.getManaUsage() + " / Mana actuel : " + ply.getManaPoint());
			}
		}
		if (input.equals("b")) {
			Spell spell = ply.getSpells()[4];
			System.out.println("NAME : " + spell.getName());
			if (ply.getManaPoint() > spell.getManaUsage()) {
				if (cooldown[4] == 0) {
					SpellTreatment.spellUsed(instances, spell, ply, map);
					int manaConsumed = ply.getManaPoint() - spell.getManaUsage();
					ply.setManaPoint(manaConsumed);
					System.out.println("ManaUsage : " + spell.getManaUsage() + " / ManaLeft : " + ply.getManaPoint());
					cooldown[4] = spell.getCooldown();
				} else {
					for(int i = 0; i<6; i++) {
						if(cooldown[i] > 0) {
							cooldown[i]--;
						}
					}
					System.out.println("WAIT COOLDOWN : " + cooldown[4] + " Left");
				}
			} else {
				System.out.println("PAS ASSEZ DE MANA \nManaUsage : " + spell.getManaUsage() + " / Mana actuel : " + ply.getManaPoint());
			}
		}
		if (input.equals(" ")) {
			Spell spell = ply.getSpells()[5];
			System.out.println("NAME : " + spell.getName());
			if (ply.getManaPoint() > spell.getManaUsage()) {
				if (cooldown[5] == 0) {
					SpellTreatment.spellUsed(instances, spell, ply, map);
					int manaConsumed = ply.getManaPoint() - spell.getManaUsage();
					ply.setManaPoint(manaConsumed);
					System.out.println("ManaUsage : " + spell.getManaUsage() + " / ManaLeft : " + ply.getManaPoint());
					cooldown[5] = spell.getCooldown();
				} else {
					for(int i = 0; i<6; i++) {
						if(cooldown[i] > 0) {
							cooldown[i]--;
						}
					}
					System.out.println("WAIT COOLDOWN : " + cooldown[5] + " sec left");
				}
			} else {
				System.out.println("PAS ASSEZ DE MANA \nManaUsage : " + spell.getManaUsage() + " / Mana actuel : " + ply.getManaPoint());
			}
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
