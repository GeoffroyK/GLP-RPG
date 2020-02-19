package spell;

import dataclasses.DataBase;
import playable.Player;

public class SpellTreatment {
	
	public static void spellUsed(DataBase db, Player ply, String number) {
		
		String type = ply.getType();
		String key = null;
		switch(type) {
		
		case "Guerrier" : key = "sg"+ number;
		break;
		
		case "Archer" : key = "sa"+ number;
		break;
			
		case "Sorcier" : key = "ss"+ number;
		break;
		}
		Spell spell = db.getSpells().get(key);
		
		if(ply.getManaPoint() > spell.getManaUsage()) {
			int manaConsumed =ply.getManaPoint() - spell.getManaUsage();
			ply.setManaPoint(manaConsumed);
			System.out.println(spell.getManaUsage() + " //// " + ply.getManaPoint());
		}
		else {
			System.out.println(spell.getManaUsage() + " \\  PAS ASSEZ DE MANA");
		}
	
		
	}

}
