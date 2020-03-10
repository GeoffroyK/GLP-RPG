package dataclasses;

import java.awt.Canvas;
import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import inventory.InventoryKey;
import inventory.InventoryThread;
import java.util.Scanner;

import game.GameInput;
import playable.Character;
import playable.Monster;
import playable.Player;
import playable.PlayerChoice;
import spell.Spell;
import loot.Consumable;
import loot.Equipment;
import loot.EquipmentTreatment;
import loot.Loot;
import map_objects.Prop;

import static inventory.InventoryThread.*;
import static inventory.InventoryKey.*;

public class DataBase extends Canvas {



	private static final long serialVersionUID = 1L;

	private static HashMap<String, Character> characters;
	private static HashMap<String, Spell> spells;
	private static HashMap<String, Loot> loots;
	private static HashMap<String,GameObject> instances;
	private static HashMap<String, Character> charInstances;

	private Scanner sc;

	private static String[] csvGameObjectPaths = { ".\\CSV\\Consumable.csv", ".\\CSV\\Equipment.csv", ".\\CSV\\Spell.csv", "csvTile", "csvProp",
			".\\CSV\\Player.csv", ".\\CSV\\Monster.csv" };

	private boolean running = true;

	public DataBase() {

		loots = new HashMap<String, Loot>();
		spells = new HashMap<String, Spell>();
		characters = new HashMap<String, Character>();
		instances = new HashMap<String, GameObject>();
		charInstances = new HashMap<String, Character>();

		try {
			DataBaseInit.loadCsvSpell(csvGameObjectPaths[2]);
			DataBaseInit.loadCsvPlayer(csvGameObjectPaths[5]);
			DataBaseInit.loadCsvMonster(csvGameObjectPaths[6]);
			DataBaseInit.loadCsvConsumable(csvGameObjectPaths[0]);
			DataBaseInit.loadCSVEquipments(csvGameObjectPaths[1]);
			// loadCsvProp();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(this);
		initGame();

	}

	public static HashMap<String, Loot> getLoots() {
		return loots;
	}

	private void initGame() {

		PlayerChoice.chooseClassPlayer("t");
		
		Monster ronflex = (Monster) characters.get("ma2");
		ronflex.setX(100);
		ronflex.setY(100);
		ronflex.setDirection(0);
		ronflex.defineArea();
		
		Monster monstre = (Monster) characters.get("mt3");
		monstre.setX(300);
		monstre.setY(600);
		monstre.setDirection(0);
		monstre.defineArea();
		
		Monster guerrier = (Monster) characters.get("mg1");
		guerrier.setX(500);
		guerrier.setY(30);
		guerrier.setDirection(0);
		guerrier.defineArea();

		Prop coffre = new Prop("id", "coffre", 1, "null");
		coffre.setX(5);
		coffre.setY(0);
		instances.put(coffre.getId(), coffre);

	
		instances.put(ronflex.getId(),ronflex);
		instances.put(monstre.getId(),monstre);
		instances.put(guerrier.getId(),guerrier);
		
		charInstances.put(ronflex.getId() + "#001",ronflex);
		charInstances.put(monstre.getId() + "#002",monstre);
		charInstances.put(guerrier.getId() + "#003",guerrier);
		
//		sc = new Scanner(System.in);
//		System.out.println("CHOOSE CLASS OF CHARACTER : 't' = WARRIOR / 'y' = ARCHER / 'u' = MAGE\n OR EXIT = 'e'");
//			String input = sc.nextLine() ;
//			PlayerChoice.chooseClassPlayer(input);

//		InventoryKey.addLoot(loots.get("E#001"), PlayerChoice.selected());
//		InventoryKey.addLoot(loots.get("E#002"), PlayerChoice.selected());
		//SALE ENCULE RENOMME TA METHODE RUN OU TICK PAS PTN DE GAMEINPUT
//		new GameInput();
//		sc.close();

	}

	public String toString() {

		String res = "";

		Collection<Spell> valsSpell = spells.values();
		Iterator<Spell> itSpell = valsSpell.iterator();
		res += "--------------------------SPELL INIT----------------------------\n";
		while (itSpell.hasNext()) {
			Spell spell = itSpell.next();
			res += spell.toString();
		}
		res += "--------------------------SPELL END-----------------------------\n";

		Collection<Character> valsCharacter = characters.values();
		Iterator<Character> itCharacter = valsCharacter.iterator();
		res += "--------------------------Character INIT----------------------------\n";
		while (itCharacter.hasNext()) {
			Character character = itCharacter.next();
			res += character.toString();
		}

		res += "--------------------------Character END-----------------------------\n";
		
		Collection<Loot> valsLoot = loots.values();
		Iterator<Loot> itLoot = valsLoot.iterator();
		res += "--------------------------Loot INIT-----------------------------\n";
		
		while (itLoot.hasNext()) {
			Loot loot = itLoot.next();
			res += loot.toString();
		}
		res += "--------------------------Loot END-----------------------------\n";
		return res;

	}

	public static HashMap<String, Spell> getSpells() {
		return spells;
	}

	public void setSpells(HashMap<String, Spell> spells) {
		DataBase.spells = spells;
	}

	public String[] getCsvGameObjectPaths() {

		return csvGameObjectPaths;
	}

	public boolean isRunning() {
		return running;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static HashMap<String, Character> getCharacters() {
		return characters;
	}

	public static HashMap<String, GameObject> getInstances() {
		return instances;
	}

	public Scanner getSc() {
		return sc;
	}
	

	public static HashMap<String, Character> getCharInstances() {
		return charInstances;
	}


	public static void main(String[] args) {
		new DataBase();
	}
}
