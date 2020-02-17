package dataclasses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import playable.Spell;

public class DataBase {
	
//	private HashMap<String,Equipment>equipments;
//	private HashMap<String,Consumable>consumables;
//	private HashMap<String,Character>characters;
//	private HashMap<String,Tile>tiles;
//	private HashMap<String,Prop>props;
	private HashMap<String,Spell>spells;
	
	private String[]csvGameObjectPaths = {"csvConsumable","csvEquipment","csvSpell","csvTile","csvProp","csvCharacter"}	;
	
	public DataBase() {
		try {
			loadCsvSpell();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		//System.out.println(this);
	}

	public void loadCsvSpell() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Hang Alexandre\\git\\GLP-RPG\\RPG\\CSV\\Spell.csv"));
		br.readLine();
		
		String line;
		String[]spellFields ;
		int[] spellIntCSV = new int[5];
		float[] spellFloatCSV = new float[2];
		

		
		while((line = br.readLine()) != null) {
			spellFields = line.split(",");
			
			spellIntCSV[0] = Integer.parseInt(spellFields[4]);
			spellIntCSV[1] = Integer.parseInt(spellFields[5]);
			spellIntCSV[2] = Integer.parseInt(spellFields[6]);
			spellIntCSV[3] = Integer.parseInt(spellFields[7]);
			spellIntCSV[4] = Integer.parseInt(spellFields[8]);
			spellFloatCSV[0] = Float.parseFloat(spellFields[9]);
			spellFloatCSV[1] = Float.parseFloat(spellFields[10]);
			Spell tmp = new Spell(spellFields[0],spellFields[1],spellFields[2],spellFields[3],spellIntCSV[0],spellIntCSV[1],spellIntCSV[2],spellIntCSV[3],spellIntCSV[4],spellFloatCSV[0],spellFloatCSV[1]);
			//System.out.println(tmp);
			spells.put(tmp.getId(),tmp);
		}
		
		br.close();
		
	}
	
	public String toString() {
		
		Collection<Spell> vals = spells.values();
		Iterator<Spell> it = vals.iterator();
		String res="";
		while(it.hasNext()) {
			Spell spell = it.next();
			res += spell.toString();
		}
		return res;
	}
	
	public static void main(String[]args) {
		 new DataBase();	
	}

//	public HashMap<String, Equipment> getEquipments() {
//		return equipments;
//	}
//
//	public void setEquipments(HashMap<String, Equipment> equipments) {
//		this.equipments = equipments;
//	}
//
//	public HashMap<String, Consumable> getConsumables() {
//		return consumables;
//	}
//
//	public void setConsumables(HashMap<String, Consumable> consumables) {
//		this.consumables = consumables;
//	}
//
//	public HashMap<String, Character> getCharacters() {
//		return characters;
//	}
//
//	public void setCharacters(HashMap<String, Character> characters) {
//		this.characters = characters;
//	}
//
//	public HashMap<String, Tile> getTiles() {
//		return tiles;
//	}
//
//	public void setTiles(HashMap<String, Tile> tiles) {
//		this.tiles = tiles;
//	}
//
//	public HashMap<String, Prop> getProps() {
//		return props;
//	}
//
//	public void setProps(HashMap<String, Prop> props) {
//		this.props = props;
//	}

	public String[] getCsvGameObjectPaths() {
		return csvGameObjectPaths;
	}

	public void setCsvGameObjectPaths(String[] csvGameObjectPaths) {
		this.csvGameObjectPaths = csvGameObjectPaths;
	}
	
}
