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
		} else {
			System.out.println(spell.getManaUsage() + " \\  PAS ASSEZ DE MANA");
		}

	}

}
