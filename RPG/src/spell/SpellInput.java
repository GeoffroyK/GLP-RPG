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

		int remaining;

		if (input.equals("w")) {
			Spell spell = ply.getSpells()[0];
			System.out.println("NAME : " + spell.getName());
			if (ply.getManaPoint() > spell.getManaUsage()) {
				if (cooldown[0] == 0) {
					SpellTreatment.spellUsed(instances, spell, ply, map);
					int manaConsumed = ply.getManaPoint() - spell.getManaUsage();
					ply.setManaPoint(manaConsumed);
					System.out.println("ManaUsage : " + spell.getManaUsage() + " / ManaLeft : " + ply.getManaPoint());
					cooldown[0]++;
				} else {
					remaining = spell.getCooldown() - cooldown[0];
					System.out.println("WAIT COOLDOWN : " + remaining + " Left");
					cooldown[0]++;
				}
				if (cooldown[0] == spell.getCooldown()) {
					cooldown[0] = 0;
				}
			} else {
				System.out.println(spell.getManaUsage() + " \\  PAS ASSEZ DE MANA : " + ply.getManaPoint());
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
					
					cooldown[1]++;
				} else {
					remaining = spell.getCooldown() - cooldown[1];
					System.out.println("WAIT COOLDOWN : " + remaining + " Left");
					cooldown[1]++;
				}
				if (cooldown[1] == spell.getCooldown()) {
					cooldown[1] = 0;
				}
				
			} else {
				System.out.println(spell.getManaUsage() + " \\  PAS ASSEZ DE MANA : " + ply.getManaPoint());
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
					cooldown[2]++;
				} else {
					remaining = spell.getCooldown() - cooldown[2];
					System.out.println("WAIT COOLDOWN : " + remaining + " Left");
					cooldown[2]++;
				}
				if (cooldown[2] == spell.getCooldown()) {
					cooldown[2] = 0;
				}
			} else {
				System.out.println(spell.getManaUsage() + " \\  PAS ASSEZ DE MANA : " + ply.getManaPoint());
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
					cooldown[3]++;
				} else {
					remaining = spell.getCooldown() - cooldown[3];
					System.out.println("WAIT COOLDOWN : " + remaining + " Left");
					cooldown[3]++;
				}
				if (cooldown[3] == spell.getCooldown()) {
					cooldown[3] = 0;
				}
			} else {
				System.out.println(spell.getManaUsage() + " \\  PAS ASSEZ DE MANA : " + ply.getManaPoint());
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
					cooldown[4]++;
				} else {
					remaining = spell.getCooldown() - cooldown[4];
					System.out.println("WAIT COOLDOWN : " + remaining + " Left");
					cooldown[4]++;
				}
				if (cooldown[4] == spell.getCooldown()) {
					cooldown[4] = 0;
				}
			} else {
				System.out.println(spell.getManaUsage() + " \\  PAS ASSEZ DE MANA : " + ply.getManaPoint());
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
					cooldown[5]++;
				} else {
					remaining = spell.getCooldown() - cooldown[5];
					System.out.println("WAIT COOLDOWN : " + remaining + " sec left");
					cooldown[5]++;
				}
				if (cooldown[5] == spell.getCooldown()) {
					cooldown[5] = 0;
				}
			} else {
				System.out.println(spell.getManaUsage() + " \\  PAS ASSEZ DE MANA : " + ply.getManaPoint());
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
