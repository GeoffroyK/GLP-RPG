package loot;

public class Equipment extends Loot {
	
	private int hpMax;
	private int mpMax;
	private int armor;
	private int dodge;
	private int strengh;
	private int dexterity;
	private int intelligence;
	private int critical;
	
	public Equipment(String id, double price, String name, String textBox, String spritePath, int hpMax, int mpMax, int armor, int dodge, int strengh, int dexterity, int intelligence, int critical) {
		super(id, price, name, textBox, spritePath) ;
		this.hpMax = hpMax ;
		this.mpMax = mpMax ;
		this.armor = armor ;
		this.dodge = dodge ;
		this.strengh = strengh ;
		this.dexterity = dexterity ;
		this.intelligence = intelligence ;
		this.critical = critical ;
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
}