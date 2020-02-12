package loot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class Consumable extends Loot {	
	
	private String hp;
	private String mp;
	private String vit;
	
	public Consumable(String id) {
		String currentLine;
		currentLine = consumables.get(id); 
		String fields[];
		fields = currentLine.split(";");
		this.hp = fields[0];
		this.mp = fields[1];
		this.vit = fields[2];
	}

	public Equipment getById(String id) {
		return consumables.get(id);
	}
}
