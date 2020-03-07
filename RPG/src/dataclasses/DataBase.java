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

	private Scanner sc;

	private static String[] csvGameObjectPaths = { ".\\CSV\\Consumable.csv", ".\\CSV\\Equipment.csv", ".\\CSV\\Spell.csv", "csvTile", "csvProp",
			".\\CSV\\Player.csv", ".\\CSV\\Monster.csv" };

	private boolean running = true;

	public DataBase() {

		loots = new HashMap<String, Loot>();
		spells = new HashMap<String, Spell>();
		characters = new HashMap<String, Character>();
		instances = new HashMap<String, GameObject>();
		

		try {
			DataBaseInit.loadCsvSpell(csvGameObjectPaths[2]);
			DataBaseInit.loadCsvPlayer(csvGameObjectPaths[5]);
			DataBaseInit.loadCsvMonster(csvGameObjectPaths[6]);
			DataBaseInit.loadCsvConsumable(csvGameObjectPaths[0]);
			DataBaseInit.loadCSVEquipments(csvGameObjectPaths[1]);
			//loadCsvProp(); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(this);
		initGame();
		
	/*	Player p = (Player) characters.get("pa2") ;
		InventoryKey.addLoot(equipments.get("E#001"), p);
		InventoryKey.addLoot(equipments.get("E#002"), p);
		InventoryKey.addLoot(consumables.get("C#001"), p);
		InventoryKey.addLoot(consumables.get("C#001"), p);
		p.setLifePoint(80);
		p.setLifePointMax(100);
		
		System.out.println(p);
		
		InventoryKey.choice(p);
		
		System.out.println(InventoryThread.showInv(p.getInventory()));
		System.out.println(p);
		
		/*InventoryKey.choice(p);
		
		System.out.println(InventoryThread.showInv(p.getInventory()));
		
		
		
		
		/*System.out.println(p);

		inventoryThread.equipmentChoice(equipments.get("E#001"), p);
		
		System.out.println(p);
		System.out.println(p.getInventory().getHelmet());*/
		
		

		//System.out.println(this);*/
	}
	
	public static HashMap<String, Loot> getLoots() {
		return loots;
	}

	private void initGame() {
		
		Monster ronflex = (Monster) characters.get("ma2");
		ronflex.setX(5);
		ronflex.setY(5);
		ronflex.setDirection(0);
		Monster monstre = (Monster) characters.get("mt3");
		monstre.setX(6);
		monstre.setY(5);
		monstre.setDirection(0);
		
		Prop coffre = new Prop("id","coffre",1,"null");
		coffre.setX(5);
		coffre.setY(0);
		instances.put(coffre.getId(), coffre);
	
		instances.put(ronflex.getId(),ronflex);
		sc = new Scanner(System.in);
		System.out.println("CHOOSE CLASS OF CHARACTER : 't' = WARRIOR / 'y' = ARCHER / 'u' = MAGE\n OR EXIT = 'e'");
			String input = sc.nextLine() ;
			PlayerChoice.chooseClassPlayer(input);

		InventoryKey.addLoot(loots.get("E#001"), PlayerChoice.selected());
<<<<<<< HEAD
		InventoryKey.addLoot(loots.get("E#002"), PlayerChoice.selected());
		
=======
		InventoryKey.addLoot(loots.get("E#001"), PlayerChoice.selected());
>>>>>>> refs/heads/Vorty
		//SALE ENCULE RENOMME TA METHODE RUN OU TICK PAS PTN DE GAMEINPUT
		new GameInput();
		sc.close();
		
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
		Collection<Loot> valsLoot = loots.values() ;
		Iterator<Loot> itLoot = valsLoot.iterator();
		res += "--------------------------Loot INIT-----------------------------\n" ;

		while(itLoot.hasNext()) {
			Loot loot = itLoot.next() ;
			res += loot.toString() ;
		}
		res += "--------------------------Loot END-----------------------------\n" ;
		return res;

	}

	public static HashMap<String, Spell> getSpells() {
		return spells;
	}

	public static String[] getCsvGameObjectPaths() {
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
	
	public static void main(String[] args) {
		new DataBase();
	}
}
