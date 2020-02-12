package loot;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class Equipment extends Loot {
	
	private String hpMax;
	private String mpMax;
	private String armor;
	private String dodge;
	private String strengh;
	private String dexterity;
	private String intelligence;
	private String critical;
	
	public Equipment(String id) {
		String currentLine;
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
		this.critical = fields[7];
	}
	
	public Equipment getById(String id) {
		return equipments.get(id);
	}
}