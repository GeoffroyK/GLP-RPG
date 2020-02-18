package playable;

import spell.Spell;

public class Player extends Character {
	private int experience;
	private Spell[] spells;

	public Player(String id, String type, int hp, int mp, int str, int dext, int intel, int def, int atk, int range,
			int inventory, int level, int atkSpeed, int ctkChance, int dodgeChance, int exp) {

		super(id, type, hp, mp, str, dext, intel, def, atk, range, inventory, level, atkSpeed, ctkChance, dodgeChance);
		experience = exp;
	}

	public String toString() {
		return "-----------------------------------------------\n" + super.toString() + "\nclass = " + getType() + "\nhp = "
				+ getLifePoint() + "\nmp = " + getManaPoint() + "\nStr = " + getStrength() + "\ndext = "
				+ getDexterity() + "\nintel = " + getIntelligence() + "\ndef = " + getDefense() + "\natk = "
				+ getAttack() + "\nrange = " + getRange() + "\ninventory = " + getInventory() + "\nlevel = "
				+ getLevel() + "\natkSpeed = " + getAttackSpeed() + "\nctkChance = " + getCriticalChance()
				+ "\ndodgeChance = " + getDodgeChance() + "\nexp = " + experience
				+ "\n-----------------------------------------------\n";

	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public Spell[] getSpells() {
		return spells;
	}

	public void setSpells(Spell[] spells) {
		this.spells = spells;
	}

}
