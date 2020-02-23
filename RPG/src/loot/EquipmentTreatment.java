package loot;

import playable.Player;

public class EquipmentTreatment {
	
	public static void equip(Equipment e, Player p) {
		p.setLifePointMax(e.getHpMax() + p.getLifePointMax());
		p.setManaPointMax(e.getMpMax() + p.getManaPointMax());
		p.setDefense(e.getArmor()+ p.getDefense());
		p.setDodgeChance(e.getDodge() + p.getDodgeChance());
		p.setStrength(e.getStrengh() + p.getStrength());
		p.setIntelligence(e.getIntelligence() + p.getIntelligence());
		p.setDexterity(e.getDexterity() + p.getDexterity());
		p.setCriticalChance(e.getCritical() + p.getCriticalChance());
		e.setEquiped(true);
	}
	
	public static void unquip(Equipment e, Player p) {
		p.setLifePointMax(p.getLifePointMax() - e.getHpMax());
		p.setManaPointMax(p.getManaPointMax() - e.getMpMax());
		p.setDefense(p.getDefense() - e.getArmor());
		p.setDodgeChance(p.getDodgeChance() - e.getDodge());
		p.setStrength(p.getStrength() - e.getStrengh());
		p.setIntelligence(p.getIntelligence() - e.getIntelligence());
		p.setDexterity(p.getDexterity() - e.getDexterity());
		p.setCriticalChance(p.getCriticalChance() - e.getCritical());
		e.setEquiped(false);	
		}

}
