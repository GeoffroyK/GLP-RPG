package dataclasses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import playable.Monster;
import playable.Player;
import playable.Spell;

public class DataBase {

//	private HashMap<String,Equipment>equipments;
//	private HashMap<String,Consumable>consumables;
	private HashMap<String, Player> players;
	private HashMap<String, Monster> monsters;
//	private HashMap<String,Tile>tiles;
//	private HashMap<String,Prop>props;
	private HashMap<String, Spell> spells;

	private String[] csvGameObjectPaths = { "csvConsumable", "csvEquipment", ".\\CSV\\Spell.csv", "csvTile", "csvProp",
			".\\CSV\\Player.csv", ".\\CSV\\Monster.csv" };

	public DataBase() {
		spells = new HashMap<String, Spell>();
		players = new HashMap<String, Player>();
		monsters = new HashMap<String, Monster>();
		try {
			loadCsvSpell();
			loadCsvPlayer();
			loadCsvMonster();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(this);
	}

	public void loadCsvSpell() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(csvGameObjectPaths[2]));
		br.readLine();

		String line;
		String[] spellFields;
		int[] spellIntCSV = new int[5];
		float[] spellFloatCSV = new float[2];

		while ((line = br.readLine()) != null) {
			spellFields = line.split(",");

			spellIntCSV[0] = Integer.parseInt(spellFields[4]);
			spellIntCSV[1] = Integer.parseInt(spellFields[5]);
			spellIntCSV[2] = Integer.parseInt(spellFields[6]);
			spellIntCSV[3] = Integer.parseInt(spellFields[7]);
			spellIntCSV[4] = Integer.parseInt(spellFields[8]);
			spellFloatCSV[0] = Float.parseFloat(spellFields[9]);
			spellFloatCSV[1] = Float.parseFloat(spellFields[10]);
			Spell tmp = new Spell(spellFields[0], spellFields[1], spellFields[2], spellFields[3], spellIntCSV[0],
					spellIntCSV[1], spellIntCSV[2], spellIntCSV[3], spellIntCSV[4], spellFloatCSV[0], spellFloatCSV[1]);
			spells.put(tmp.getId(), tmp);
		}

		br.close();

	}

	private void loadCsvPlayer() throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(csvGameObjectPaths[5]));
		br.readLine();

		String line;
		String[] playerFields;
		int[] playerIntCSV = new int[14];

		while ((line = br.readLine()) != null) {
			playerFields = line.split(",");
			for (int i = 0; i < 14; i++) {
				playerIntCSV[i] = Integer.parseInt(playerFields[i + 2]);
			}
			Player tmp = new Player(playerFields[0], playerFields[1], playerIntCSV[0], playerIntCSV[1], playerIntCSV[2],
					playerIntCSV[3], playerIntCSV[4], playerIntCSV[5], playerIntCSV[6], playerIntCSV[7],
					playerIntCSV[8], playerIntCSV[9], playerIntCSV[10], playerIntCSV[11], playerIntCSV[12],
					playerIntCSV[13]);
			players.put(tmp.getId(), tmp);
		}

		br.close();

	}

	private void loadCsvMonster() throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(csvGameObjectPaths[6]));
		br.readLine();

		String line;
		String[] monsterFields;
		int[] monsterIntCSV = new int[15];

		while ((line = br.readLine()) != null) {
			monsterFields = line.split(",");
			for (int i = 0; i < 14; i++) {
				monsterIntCSV[i] = Integer.parseInt(monsterFields[i + 2]);
			}
			Monster tmp = new Monster(monsterFields[0], monsterFields[1], monsterIntCSV[0], monsterIntCSV[1], monsterIntCSV[2],
					monsterIntCSV[3], monsterIntCSV[4], monsterIntCSV[5], monsterIntCSV[6], monsterIntCSV[7],
					monsterIntCSV[8], monsterIntCSV[9], monsterIntCSV[10], monsterIntCSV[11], monsterIntCSV[12],
					monsterIntCSV[13],monsterIntCSV[14]);
			monsters.put(tmp.getId(), tmp);
		}

		br.close();

	}

	public String toString() {

		Collection<Spell> valsSpell = spells.values();
		Iterator<Spell> itSpell = valsSpell.iterator();
		String res = "";
		res += "--------------------------SPELL INIT----------------------------\n";
		while (itSpell.hasNext()) {
			Spell spell = itSpell.next();
			res += spell.toString();
		}
		res += "--------------------------SPELL END-----------------------------\n";

		res += "--------------------------PLAYER INIT---------------------------\n";
		Collection<Player> valsPlayer = players.values();
		Iterator<Player> itPlayer = valsPlayer.iterator();
		while (itPlayer.hasNext()) {
			Player player = itPlayer.next();
			res += player.toString();
		}
		res += "--------------------------PLAYER END-----------------------------\n";

		res += "--------------------------MONSTER INIT---------------------------\n";
		Collection<Monster> valsMonster = monsters.values();
		Iterator<Monster> itMonster = valsMonster.iterator();
		while (itMonster.hasNext()) {
			Monster monster = itMonster.next();
			res += monster.toString();
		}
		res += "--------------------------MONSTER END-----------------------------\n";
		return res;
	}

	public static void main(String[] args) {
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
