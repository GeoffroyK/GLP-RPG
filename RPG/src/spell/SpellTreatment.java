package spell;

import playable.Player;

public class SpellTreatment {

	public static void spellUsed(Player ply, int number) {

		Spell spell = ply.getSpells()[number];
		System.out.println(spell.getName());
		if (ply.getManaPoint() > spell.getManaUsage()) {
			int manaConsumed = ply.getManaPoint() - spell.getManaUsage();
			ply.setManaPoint(manaConsumed);
			System.out.println(spell.getManaUsage() + " //// " + ply.getManaPoint());

			switch (spell.getType()) {

			case "Dmg":
				System.out.println("HP : " + ply.getLifePoint() + " --> ");
				ply.setLifePoint(ply.getLifePoint() - spell.getDamage());
				System.out.println(ply.getLifePoint());
				break;

			case "Mvt":
				System.out.println(" UP MVT SPEED :  +" + spell.getDamage());
				break;

			case "Crit":
				System.out.println("CRIT : " +ply.getCriticalChance() + " --> ");
				ply.setCriticalChance(ply.getCriticalChance() + spell.getDamage());
				System.out.println(ply.getCriticalChance());
				break;

			case "HP":
				System.out.println("HP : " +ply.getLifePoint() + " --> ");
				ply.setLifePoint(ply.getLifePoint() + spell.getDamage());
				System.out.println(ply.getLifePoint());
				break;

			case "MP":
				System.out.println("MP : " +ply.getManaPoint() + " --> ");
				ply.setManaPoint(ply.getManaPoint() + spell.getDamage());
				System.out.println(ply.getManaPoint());
				break;

			case "Rage":
				System.out.println("DMG : " +ply.getAttack() + " --> ");
				ply.setAttack(ply.getAttack() + spell.getDamage());
				System.out.println(ply.getAttack());
				break;

			case "Spd":
				System.out.println("AttackSpeed : " +ply.getAttackSpeed() + " --> ");
				ply.setAttackSpeed(ply.getAttackSpeed() + spell.getDamage());
				System.out.println(ply.getAttackSpeed());
				break;
				
			case "Dodge":
				System.out.println("Dodge : " +ply.getDodgeChance() + " --> ");
				ply.setDodgeChance(ply.getDodgeChance() + spell.getDamage());
				System.out.println(ply.getDodgeChance());
				break;
			
			case "Aoe" : 
				

			}
		} else {
			System.out.println(spell.getManaUsage() + " \\  PAS ASSEZ DE MANA : " + ply.getManaPoint());
		}

	}

}
