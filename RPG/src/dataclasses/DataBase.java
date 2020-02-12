package dataclasses;

import java.util.HashMap;

public class DataBase {
	
	private HashMap<String,Equipment>equipments;
	private HashMap<String,Consumable>consumables;
	private HashMap<String,Character>characters;
	private HashMap<String,Tile>tiles;
	private HashMap<String,Prop>props;
	
	private String[]csvGameObjectPaths = {"csvConsumable","csvEquipment","csvSpell","csvTile","csvProp","csvCharacter"}	;
	
	public DataBase() {
		loadCsv();
	}

	private void loadCsv() {
		
		
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
