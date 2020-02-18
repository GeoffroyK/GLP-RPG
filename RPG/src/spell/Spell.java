package spell;

import dataclasses.GameObject;

public class Spell extends GameObject {

	private String name;
	private String effect;
	private String type;
	private int damage;
	private int manaUsage;
	private int range;
	private int duration;
	private int cooldown;
	private float lvlScaling;
	private float statScaling;

	public Spell(String id, String name, String effect, String type, int dmg, int mana, int range, int duration, int cd,
			float lvlS, float statS) {
		super(id);
		this.name = name;
		this.effect = effect;
		this.type = type;
		damage = dmg;
		manaUsage = mana;
		this.range = range;
		this.duration = duration;
		cooldown = cd;
		lvlScaling = lvlS;
		statScaling = statS;

	}

	public String toString() {
		return "-----------------------------------------------\n" + super.toString() + "\nname = " + name
				+ "\neffect = " + effect + "\ntype = " + type + "\ndamage = " + damage + "\nmanaUsage = " + manaUsage
				+ "\nrange = " + range + "\nduration = " + duration + "\ncooldown = " + cooldown + "\nlvlScaling = "
				+ lvlScaling + "\nstatScaling = " + statScaling + "\n-----------------------------------------------\n";

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public double getManaUsage() {
		return manaUsage;
	}

	public void setManaUsage(int manaUsage) {
		this.manaUsage = manaUsage;
	}

	public float getLvlScaling() {
		return lvlScaling;
	}

	public void setLvlScaling(float lvlScaling) {
		this.lvlScaling = lvlScaling;
	}

	public float getStatScaling() {
		return statScaling;
	}

	public void setStatScaling(float statScaling) {
		this.statScaling = statScaling;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getCooldown() {
		return cooldown;
	}

	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}

}
