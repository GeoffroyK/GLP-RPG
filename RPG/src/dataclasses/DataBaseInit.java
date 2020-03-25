package dataclasses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import loot.Consumable;
import loot.Equipment;
import playable.Monster;
import playable.Player;
import spell.Spell;

public class DataBaseInit {

	public static void loadCsvSpell(String csvPath) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(csvPath));
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
					spellIntCSV[1], spellIntCSV[2], spellIntCSV[3], spellIntCSV[4], spellFloatCSV[0], spellFloatCSV[1],
					spellFields[11], spellFields[12]);
			DataBase.getSpells().put(tmp.getId(), tmp);
		}

		br.close();
	}

	public static void loadCsvConsumable(String csvPath) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(csvPath));
		br.readLine();

		String line;
		String[] lootFields;
		int[] statFields = new int[4];

		Consumable newConsumable;

		while ((line = br.readLine()) != null) {
			lootFields = line.split(";");

			double price = Double.parseDouble(lootFields[1]);
			statFields[0] = Integer.parseInt(lootFields[5]);
			statFields[1] = Integer.parseInt(lootFields[6]);
			statFields[2] = Integer.parseInt(lootFields[7]);
			statFields[3] = Integer.parseInt(lootFields[8]);

			newConsumable = new Consumable(lootFields[0], price, lootFields[2], lootFields[3], lootFields[4],
					statFields[0], statFields[1], statFields[2], statFields[3]);
			// System.out.println(newConsumable);
			DataBase.getLoots().put(newConsumable.getId(), newConsumable);
		}

		br.close();
	}

	public static void loadCSVEquipments(String csvPath) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(csvPath));
		br.readLine();

		String line;
		String[] lootFields;
		int[] statFields = new int[9];

		Equipment newEquipment;

		while ((line = br.readLine()) != null) {
			lootFields = line.split(";");

			double price = Double.parseDouble(lootFields[1]);

			for (int i = 0; i < statFields.length; i++) {
				statFields[i] = Integer.parseInt(lootFields[i + 5]);
			}

			newEquipment = new Equipment(lootFields[0], price, lootFields[2], lootFields[3], lootFields[4],
					statFields[0], statFields[1], statFields[2], statFields[3], statFields[4], statFields[5],
					statFields[6], statFields[7], statFields[8], lootFields[14]);
			// System.out.println(newEquipment);
			DataBase.getLoots().put(newEquipment.getId(), newEquipment);
		}
		br.close();
	}

	public static void loadCsvPlayer(String csvPath) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(csvPath));
		br.readLine();

		String line;
		String[] playerFields;
		int[] playerIntCSV = new int[14];
		Spell[] playerSpells = new Spell[6];

		while ((line = br.readLine()) != null) { // INIT ALL INTEGERS OF PLAYERS
			playerFields = line.split(",");
			for (int i = 0; i < 14; i++) {
				playerIntCSV[i] = Integer.parseInt(playerFields[i + 2]);
			}

			switch (playerFields[1]) { // INIT PLAYER SPELLS DEPENDING ON PLAYER'S TYPE

			case "Guerrier":
				for (int i = 1; i <= 6; i++) {
					String key = "sg" + i;
					playerSpells[i - 1] = DataBase.getSpells().get(key);
				}
				break;

			case "Archer":
				for (int i = 1; i <= 6; i++) {
					String key = "sa" + i;
					playerSpells[i - 1] = DataBase.getSpells().get(key);
				}
				break;

			case "Sorcier":
				for (int i = 1; i <= 6; i++) {
					String key = "ss" + i;
					playerSpells[i - 1] = DataBase.getSpells().get(key);
				}
				break;
			}

			Player tmp = new Player(playerFields[0], playerFields[1], playerIntCSV[0], playerIntCSV[1], playerIntCSV[2],
					playerIntCSV[3], playerIntCSV[4], playerIntCSV[5], playerIntCSV[6], playerIntCSV[7],
					playerIntCSV[8], playerIntCSV[9], playerIntCSV[10], playerIntCSV[11], playerIntCSV[12],
					playerIntCSV[13], playerSpells[0], playerSpells[1], playerSpells[2], playerSpells[3],
					playerSpells[4], playerSpells[5], playerFields[16]);

			DataBase.getCharacters().put(tmp.getId(), tmp);

		}

		br.close();

	}

	public static void loadCsvMonster(String csvPath) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(csvPath));
		br.readLine();

		String line;
		String[] monsterFields;
		int[] monsterIntCSV = new int[15];

		while ((line = br.readLine()) != null) {
			monsterFields = line.split(",");
			for (int i = 0; i < 14; i++) {
				monsterIntCSV[i] = Integer.parseInt(monsterFields[i + 2]);
			}
			Monster tmp = new Monster(monsterFields[0], monsterFields[1], monsterIntCSV[0], monsterIntCSV[1],
					monsterIntCSV[2], monsterIntCSV[3], monsterIntCSV[4], monsterIntCSV[5], monsterIntCSV[6],
					monsterIntCSV[7], monsterIntCSV[8], monsterIntCSV[9], monsterIntCSV[10], monsterIntCSV[11],
					monsterIntCSV[12], monsterIntCSV[13], monsterIntCSV[14], null);
			DataBase.getCharacters().put(tmp.getId(), tmp);
		}

		br.close();

	}

	/*
	 * public void loadCsvProp() throws IOException { BufferedReader br = new
	 * BufferedReader(new FileReader(csvGameObjectPaths[4])); br.readLine();
	 * 
	 * String line; String[] propFields; int[] propIntCSV = new int[1]; String[]
	 * propStringCSV = new String[2];
	 * 
	 * while ((line = br.readLine()) != null) { propFields = line.split(",");
	 * propIntCSV[0] = Integer.parseInt(propFields[2]); propStringCSV[0] =
	 * propFields[0]; propStringCSV[1] = propFields[1]; propStringCSV[2] =
	 * propFields[3]; Prop tmp = new Prop(propStringCSV[0], propStringCSV[1],
	 * propIntCSV[0], propStringCSV[2]); props.put(tmp.getId(), tmp); }
	 * 
	 * br.close(); } <<<<<<< HEAD
	 */
}
