package playable;

import dataclasses.GameObject;

public class Spell extends GameObject{
	
	private String name;
	private String effect;
	private String type;
	private double damage;
	private double manaUsage;
	private float lvlScaling;
	private float statScaling;
	private int range;
	private int duration;
	private int cooldown;	
	public Spell() {
		super();
		
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
	public void setDamage(double damage) {
		this.damage = damage;
	}
	public double getManaUsage() {
		return manaUsage;
	}
	public void setManaUsage(double manaUsage) {
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
