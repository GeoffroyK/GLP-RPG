package dataclasses;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import loot.Consumable;
import loot.Equipment;

public class DataBase {
	
	private HashMap<String,Equipment>equipments;
	private HashMap<String,Consumable>consumables;
	private HashMap<String,Character>characters;
	//private HashMap<String,Tile>tiles;
	//private HashMap<String,Prop>props;
	
	private String[]csvGameObjectPaths = {"csvConsumable","csvEquipment","csvSpell","csvTile","csvProp","csvCharacter"}	;
	
	public DataBase() {
	}

	private void loadCsvConsumable() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(csvGameObjectPaths[0]));
		br.readLine() ;
		
		String line ;
		String []lootFields ;
		int []statFields =  new int[3];
		
		Consumable newConsumable ;
		
		while((line = br.readLine()) != null) {
			lootFields = line.split(";");
			
			double price = Double.parseDouble(lootFields[1]) ;
			statFields[0] = Integer.parseInt(lootFields[4]);
			statFields[1] = Integer.parseInt(lootFields[5]);
			statFields[2] = Integer.parseInt(lootFields[6]);
			
			newConsumable = new Consumable(lootFields[0], price, lootFields[2], lootFields[3], statFields[0], statFields[1], statFields[2]);
			
			consumables.put(newConsumable.getId(), newConsumable);
		}
		
	}

	public HashMap<String, Equipment> getEquipments() {
		return equipments;
	}

	public void setEquipments(HashMap<String, Equipment> equipments) {
		this.equipments = equipments;
	}

	public HashMap<String, Consumable> getConsumables() {
		return consumables;
	}

	public void setConsumables(HashMap<String, Consumable> consumables) {
		this.consumables = consumables;
	}

	public HashMap<String, Character> getCharacters() {
		return characters;
	}

	public void setCharacters(HashMap<String, Character> characters) {
		this.characters = characters;
	}

	public HashMap<String, Tile> getTiles() {
		return tiles;
	}

	public void setTiles(HashMap<String, Tile> tiles) {
		this.tiles = tiles;
	}

	public HashMap<String, Prop> getProps() {
		return props;
	}

	public void setProps(HashMap<String, Prop> props) {
		this.props = props;
	}

	public String[] getCsvGameObjectPaths() {
		return csvGameObjectPaths;
	}

	public void setCsvGameObjectPaths(String[] csvGameObjectPaths) {
		this.csvGameObjectPaths = csvGameObjectPaths;
	}
	
}
