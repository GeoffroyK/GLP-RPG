package dataclasses;

import java.io.BufferedReader;
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
		loadCsvSpell();
		System.out.println(this);
	}

	private void loadCsvSpell() {
		BufferedReader br = new BufferedReader()
		
	}
	
	public static void main(String[]args) {
		 new DataBase();	
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
