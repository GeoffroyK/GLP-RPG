package playable;

import dataclasses.DataBase;
import spell.Spell;

public class Player extends Character {
	private int experience;
	private Spell[] spells;

	public Player(String id, String type, int hp, int mp, int str, int dext, int intel, int def, int atk, int range,
			int inventory, int level, int atkSpeed, int ctkChance, int dodgeChance, int exp) {

		super(id, type, hp, mp, str, dext, intel, def, atk, range, inventory, level, atkSpeed, ctkChance, dodgeChance);
		experience = exp;
		PlayerTreatment.initSpells(this);
	}

	public String toString() {
		return  super.toString() + "\nexp = " + experience
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
