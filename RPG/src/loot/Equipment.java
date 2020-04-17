package loot;

import java.awt.Graphics;

/*
 * DataClass for equipment
 */

public class Equipment extends Loot {
	
	private int hpMax;
	private int mpMax;
	private int armor;
	private int dodge;
	private int strengh;
	private int dexterity;
	private int intelligence;
	private int critical;
	private String type ;
	private Boolean equiped ;
	
	public Equipment(String id, double price, String name, String textBox, String spritePath, int hpMax, int mpMax, int armor, int dodge, int strengh, int dexterity, int intelligence, int critical, int size, String type) {
		super(id, price, name, textBox, spritePath, size) ;
		this.hpMax = hpMax ;
		this.mpMax = mpMax ;
		this.armor = armor ;
		this.dodge = dodge ;
		this.strengh = strengh ;
		this.dexterity = dexterity ;
		this.intelligence = intelligence ;
		this.critical = critical ; 
		this.type = type ;
		equiped = false ;
	}
	
	public String toString(){
		return super.toString() + "\nStat / hp : " + hpMax + " / mp : " + mpMax + " / armor : " + armor + " / dodge : " + dodge + " / strengh : " + strengh 
				+ " / dexterity : " + dexterity + " / intelligence : " + intelligence + " / critical : " + critical + " / type : " + type + "\n" + "Equipé ? " + equiped + "\n";
	}
	
	/*String currentLine;
	currentLine = equipments.get(id); 
	String fields[];
	fields = currentLine.split(";");
	this.hpMax = fields[0];
	this.mpMax = fields[1];
	this.armor = fields[2];
	this.dodge = fields[3];
	this.strengh = fields[4];
	this.dexterity = fields[5];
	this.intelligence = fields[6];
	this.critical = fields[7];*/
	
	public int getHpMax() {
		return hpMax;
	}

	public void setHpMax(int hpMax) {
		this.hpMax = hpMax;
	}

	public int getMpMax() {
		return mpMax;
	}

	public void setMpMax(int mpMax) {
		this.mpMax = mpMax;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public int getDodge() {
		return dodge;
	}

	public void setDodge(int dodge) {
		this.dodge = dodge;
	}

	public int getStrengh() {
		return strengh;
	}

	public void setStrengh(int strengh) {
		this.strengh = strengh;
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getCritical() {
		return critical;
	}

	public void setCritical(int critical) {
		this.critical = critical;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public Boolean getEquiped() {
		return equiped;
	}

	public void setEquiped(Boolean equiped) {
		this.equiped = equiped;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
}