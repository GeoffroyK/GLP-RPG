package spell;

import map.Map;
import playable.MoveTreatment;
import playable.Player;

public class SpellTreatment {

	public static void spellUsed(Player ply, int number, Map map) {

		Spell spell = ply.getSpells()[number];
		System.out.println("NAME : " +spell.getName());
		if (ply.getManaPoint() > spell.getManaUsage()) {
			int manaConsumed = ply.getManaPoint() - spell.getManaUsage();
			ply.setManaPoint(manaConsumed);
			System.out.println("ManaUsage : " + spell.getManaUsage() + " / ManaLeft : " + ply.getManaPoint());

			switch (spell.getType()) {

			case "Dmg":
				System.out.println("HP : " + ply.getLifePoint() + " --> ");
				ply.setLifePoint(ply.getLifePoint() - spell.getDamage());
				System.out.println(ply.getLifePoint());
				break;

			case "Mvt":
				switch (ply.getDirection()) {

				/* Haut */ case 0:
					MoveTreatment.reposition(ply, 0, spell.getDamage(), map);
					break;

				/* Gauche */ case 1:
					MoveTreatment.reposition(ply, 1, spell.getDamage(), map);
					break;

				/* Droite */ case 2:
					MoveTreatment.reposition(ply, 2, spell.getDamage(), map);
					break;

				/* Bas */ case 3:
					MoveTreatment.reposition(ply, 3, spell.getDamage(), map);
					break;
				}
				break;

			case "Crit":
				System.out.println("CRIT : " + ply.getCriticalChance() + " --> ");
				ply.setCriticalChance(ply.getCriticalChance() + spell.getDamage());
				System.out.println(ply.getCriticalChance());
				break;

			case "HP":
				ply.setLifePoint(ply.getLifePoint() + spell.getDamage());
				System.out.println("Heal : " + spell.getDamage() + " -->  HP Left : " + ply.getLifePoint());
				break;

			case "MP":
				System.out.println("MP : " + ply.getManaPoint() + " --> ");
				ply.setManaPoint(ply.getManaPoint() + spell.getDamage());
				System.out.println(ply.getManaPoint());
				break;

			case "Rage":
				System.out.println("DMG : " + ply.getAttack() + " --> ");
				ply.setAttack(ply.getAttack() + spell.getDamage());
				System.out.println(ply.getAttack());
				break;

			case "Spd":
				System.out.println("AttackSpeed : " + ply.getAttackSpeed() + " --> ");
				ply.setAttackSpeed(ply.getAttackSpeed() + spell.getDamage());
				System.out.println(ply.getAttackSpeed());
				break;

			case "Dodge":
				System.out.println("Dodge : " + ply.getDodgeChance() + " --> ");
				ply.setDodgeChance(ply.getDodgeChance() + spell.getDamage());
				System.out.println(ply.getDodgeChance());
				break;

			case "Aoe":

			}
		} else {
			System.out.println(spell.getManaUsage() + " \\  PAS ASSEZ DE MANA : " + ply.getManaPoint());
		}

	}

}
