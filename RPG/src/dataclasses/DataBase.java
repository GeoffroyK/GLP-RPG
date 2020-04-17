package dataclasses;

import java.awt.Canvas;
import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import inventory.InventoryKey;
import inventory.InventoryThread;
import java.util.Scanner;

import playable.Character;
import playable.Monster;
import playable.Player;
import playable.PlayerChoice;
import spell.Spell;
import loot.Consumable;
import loot.Equipment;
import loot.EquipmentTreatment;
import map_objects.Chest;
import map_objects.Seller;
import map_objects.Stair;
import loot.Loot;
import map_objects.Prop;

import static inventory.InventoryThread.*;
import static inventory.InventoryKey.*;

public class DataBase extends Canvas {

	private static Player ply;

	private static final long serialVersionUID = 1L;

	private static HashMap<String, Character> characters;
	private static HashMap<String, Spell> spells;
	private static HashMap<String, Loot> loots;
	private static HashMap<String,GameObject> instances;
	private static HashMap<String, Character> charInstances;
	private static ArrayList<Prop> propInstance;
	

	private static ArrayList<String> toBeRemoved;
	private static ArrayList<GameObject> toBeAdded;

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
		propInstance = new ArrayList<Prop>() ;
		toBeRemoved = new ArrayList<String>();
		toBeAdded = new ArrayList<GameObject>();
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
		PlayerChoice.chooseClassPlayer("t");
	}

	public static HashMap<String, Loot> getLoots() {
		return loots;
	}

	public static void initGame1() {


		
		Monster ronflex = new Monster((Monster)(Monster) characters.get("ma2"));
		ronflex.setId(ronflex.getId() + "#001");
		ronflex.setX(500);
		ronflex.setY(500);
		ronflex.setDirection(0);
		ronflex.defineArea();
		
		Monster ronflex2 = new Monster((Monster)(Monster) characters.get("ma2"));
		ronflex2.setId(ronflex.getId() + "#009");
		ronflex2.setX(180);
		ronflex2.setY(180);
		ronflex2.setDirection(0);
		ronflex2.defineArea();
	
		Monster ronflex3 = new Monster((Monster)(Monster) characters.get("ma2"));
		ronflex3.setId(ronflex.getId() + "#010");
		ronflex3.setX(1300);
		ronflex3.setY(600);
		ronflex3.setDirection(0);
		ronflex3.defineArea();
		
		Monster ronflex4 = new Monster((Monster)(Monster) characters.get("ma2"));
		ronflex4.setId(ronflex.getId() + "#011");
		ronflex4.setX(1400);
		ronflex4.setY(560);
		ronflex4.setDirection(0);
		ronflex4.defineArea();
		
		Monster ronflex5 = new Monster((Monster)(Monster) characters.get("ma2"));
		ronflex5.setId(ronflex.getId() + "#012");
		ronflex5.setX(500);
		ronflex5.setY(280);
		ronflex5.setDirection(0);
		ronflex5.defineArea();
		
		Monster ronflex6 = new Monster((Monster)(Monster) characters.get("ma2"));
		ronflex6.setId(ronflex.getId() + "#013");
		ronflex6.setX(400);
		ronflex6.setY(700);
		ronflex6.setDirection(0);
		ronflex6.defineArea();
		
		Monster monstre = new Monster((Monster) characters.get("mt3"));
		monstre.setId(monstre.getId() + "#002");
		monstre.setX(680);
		monstre.setY(230);
		monstre.setDirection(0);
		monstre.defineArea();
		
		Monster monstre2 = new Monster((Monster)characters.get("mt3"));
		monstre2.setId(monstre.getId() + "#003");
		monstre2.setX(690);
		monstre2.setY(130);
		monstre2.setDirection(0);
		monstre2.defineArea();
		
		Monster monstre3 = new Monster((Monster)characters.get("mt3"));
		monstre3.setId(monstre.getId() + "#004");
		monstre3.setX(720);
		monstre3.setY(400);
		monstre3.setDirection(0);
		monstre3.defineArea();
		
		Monster monstre4 = new Monster((Monster)characters.get("mt3"));
		monstre4.setId(monstre.getId() + "#005");
		monstre4.setX(350);
		monstre4.setY(720);
		monstre4.setDirection(0);
		monstre4.defineArea();
		
		Monster monstre5 = new Monster((Monster)characters.get("mt3"));
		monstre5.setId(monstre.getId() + "#006");
		monstre5.setX(1400);
		monstre5.setY(300);
		monstre5.setDirection(0);
		monstre5.defineArea();
		
		Monster monstre6 = new Monster((Monster)characters.get("mt3"));
		monstre6.setId(monstre.getId() + "#007");
		monstre6.setX(1100);
		monstre6.setY(680);
		monstre6.setDirection(0);
		monstre6.defineArea();
		
		Monster monstre7 = new Monster((Monster) characters.get("mt3"));
		monstre7.setId(monstre.getId() + "#008");
		monstre7.setX(900);
		monstre7.setY(500);
		monstre7.setDirection(0);
		monstre7.defineArea();
		
		Monster guerrier = new Monster((Monster) characters.get("mg1"));
		guerrier.setId(guerrier.getId() + "#003");
		guerrier.setX(1100);
		guerrier.setY(500);
		guerrier.setDirection(0);
		guerrier.defineArea();
		
		Chest c = new Chest("c", "isi","Ressources//Sprite//Props//Chest.png", 100, 150, "E#001", 250) ;
		instances.put(c.getId(), c);
		propInstance.add(c) ;
		
		ArrayList<Loot> list = new ArrayList<Loot>() ;
		Collection i = DataBase.getLoots().values() ;
		Iterator<Loot> r = i.iterator() ;
		while(r.hasNext()){
			Loot l = r.next() ;
			list.add(l) ;
		}
		
		Seller s = new Seller("s", "isi", "Ressources//Sprite//Props//Seller.png", 130, 200, list);
		instances.put(s.getId(), s) ;
		propInstance.add(s) ;
		
		Stair Stair = new Stair("st", "isi", "Ressources//Sprite//Props//Escalier.png", 1300, 300, 1) ;
        instances.put(Stair.getId(), Stair) ;
        propInstance.add(Stair) ;
		

	
		instances.put(ronflex.getId(),ronflex);
		instances.put(ronflex2.getId(),ronflex2);
		instances.put(ronflex3.getId(),ronflex3);
		instances.put(ronflex4.getId(),ronflex4);
		instances.put(ronflex5.getId(),ronflex5);
		instances.put(ronflex6.getId(),ronflex6);
		instances.put(monstre.getId(),monstre);
		instances.put(monstre2.getId(),monstre2);
		instances.put(monstre3.getId(),monstre3);
		instances.put(monstre4.getId(),monstre4);
		instances.put(monstre5.getId(),monstre5);
		instances.put(monstre6.getId(),monstre6);
		instances.put(monstre7.getId(),monstre7);
		instances.put(guerrier.getId(),guerrier);

		
		charInstances.put(ronflex.getId(),ronflex);
		charInstances.put(ronflex2.getId(),ronflex2);
		charInstances.put(ronflex3.getId(),ronflex3);
		charInstances.put(ronflex4.getId(),ronflex4);
		charInstances.put(ronflex5.getId(),ronflex5);
		charInstances.put(ronflex6.getId(),ronflex6);
		charInstances.put(monstre.getId(),monstre);
		charInstances.put(monstre2.getId(),monstre2);
		charInstances.put(monstre3.getId(),monstre3);
		charInstances.put(monstre4.getId(),monstre4);
		charInstances.put(monstre5.getId(),monstre5);
		charInstances.put(monstre6.getId(),monstre6);
		charInstances.put(monstre7.getId(),monstre7);
		charInstances.put(guerrier.getId(),guerrier);


		

	}
	
	public static void initGame2() {
		Monster ronflex = new Monster((Monster)(Monster) characters.get("ma2"));
		ronflex.setId(ronflex.getId() + "#001");
		ronflex.setX(500);
		ronflex.setY(500);
		ronflex.setDirection(0);
		ronflex.defineArea();
		instances.put(ronflex.getId(),ronflex);
		charInstances.put(ronflex.getId(),ronflex);
		
		Monster ronflex1 = new Monster((Monster)(Monster) characters.get("ma2"));
		ronflex1.setId(ronflex1.getId() + "#002");
		ronflex1.setX(200);
		ronflex1.setY(300);
		ronflex1.setDirection(0);
		ronflex1.defineArea();
		instances.put(ronflex1.getId(),ronflex1);
		charInstances.put(ronflex1.getId(),ronflex1);
		
		Monster ronflex2 = new Monster((Monster)(Monster) characters.get("ma2"));
		ronflex2.setId(ronflex2.getId() + "#003");
		ronflex2.setX(900);
		ronflex2.setY(350);
		ronflex2.setDirection(0);
		ronflex2.defineArea();
		instances.put(ronflex2.getId(),ronflex2);
		charInstances.put(ronflex2.getId(),ronflex2);
		
		Monster ronflex3 = new Monster((Monster)(Monster) characters.get("ma2"));
		ronflex3.setId(ronflex3.getId() + "#004");
		ronflex3.setX(700);
		ronflex3.setY(80);
		ronflex3.setDirection(0);
		ronflex3.defineArea();
		instances.put(ronflex3.getId(),ronflex3);
		charInstances.put(ronflex3.getId(),ronflex3);
		
		Monster ronflex4 = new Monster((Monster)(Monster) characters.get("ma2"));
		ronflex4.setId(ronflex4.getId() + "#005");
		ronflex4.setX(650);
		ronflex4.setY(280);
		ronflex4.setDirection(0);
		ronflex4.defineArea();
		instances.put(ronflex4.getId(),ronflex4);
		charInstances.put(ronflex4.getId(),ronflex4);
		
		Monster ronflex5 = new Monster((Monster)(Monster) characters.get("ma2"));
		ronflex5.setId(ronflex5.getId() + "#006");
		ronflex5.setX(1400);
		ronflex5.setY(380);
		ronflex5.setDirection(0);
		ronflex5.defineArea();
		instances.put(ronflex5.getId(),ronflex5);
		charInstances.put(ronflex5.getId(),ronflex5);
		
		Monster ronflex6 = new Monster((Monster)(Monster) characters.get("ma2"));
		ronflex6.setId(ronflex6.getId() + "#007");
		ronflex6.setX(950);
		ronflex6.setY(600);
		ronflex6.setDirection(0);
		ronflex6.defineArea();
		instances.put(ronflex6.getId(),ronflex6);
		charInstances.put(ronflex6.getId(),ronflex6);
		
		Monster ronflex7 = new Monster((Monster)(Monster) characters.get("ma2"));
		ronflex7.setId(ronflex7.getId() + "#008");
		ronflex7.setX(1000);
		ronflex7.setY(600);
		ronflex7.setDirection(0);
		ronflex7.defineArea();
		instances.put(ronflex7.getId(),ronflex7);
		charInstances.put(ronflex7.getId(),ronflex7);
		
		Monster ronflex8 = new Monster((Monster)(Monster) characters.get("ma2"));
		ronflex8.setId(ronflex8.getId() + "#009");
		ronflex8.setX(1050);
		ronflex8.setY(600);
		ronflex8.setDirection(0);
		ronflex8.defineArea();
		instances.put(ronflex8.getId(),ronflex8);
		charInstances.put(ronflex8.getId(),ronflex8);
		
		Monster ronflex9 = new Monster((Monster)(Monster) characters.get("ma2"));
		ronflex9.setId(ronflex8.getId() + "#010");
		ronflex9.setX(1100);
		ronflex9.setY(600);
		ronflex9.setDirection(0);
		ronflex9.defineArea();
		instances.put(ronflex9.getId(),ronflex9);
		charInstances.put(ronflex9.getId(),ronflex9);
		
		Monster ronflex10 = new Monster((Monster)(Monster) characters.get("ma2"));
		ronflex10.setId(ronflex8.getId() + "#011");
		ronflex10.setX(1150);
		ronflex10.setY(600);
		ronflex10.setDirection(0);
		ronflex10.defineArea();
		instances.put(ronflex10.getId(),ronflex10);
		charInstances.put(ronflex10.getId(),ronflex10);
		
		Monster ronflex11 = new Monster((Monster)(Monster) characters.get("ma2"));
		ronflex11.setId(ronflex11.getId() + "#012");
		ronflex11.setX(1200);
		ronflex11.setY(600);
		ronflex11.setDirection(0);
		ronflex11.defineArea();
		instances.put(ronflex11.getId(),ronflex11);
		charInstances.put(ronflex11.getId(),ronflex11);
		

		
		Chest c2 = new Chest("c", "isi","Ressources//Sprite//Props//Chest.png", 100, 150, "E#001", 250) ;
		instances.put(c2.getId(), c2);
		propInstance.add(c2) ;
		
		Chest c1 = new Chest("c", "isi","Ressources//Sprite//Props//Chest.png", 900, 350, "E#001", 250) ;
		instances.put(c1.getId(), c1);
		propInstance.add(c1) ;
		
		ArrayList<Loot> list = new ArrayList<Loot>() ;
		Collection i = DataBase.getLoots().values() ;
		Iterator<Loot> r = i.iterator() ;
		while(r.hasNext()){
			Loot l = r.next() ;
			list.add(l) ;
		}
		
		Seller s = new Seller("s", "isi", "Ressources//Sprite//Props//Seller.png", 130, 200, list);
		instances.put(s.getId(), s) ;
		propInstance.add(s) ;
		
		Stair Stair = new Stair("st", "isi", "Ressources//Sprite//Props//Escalier.png", 1100, 380, 1) ;
        instances.put(Stair.getId(), Stair) ;
        propInstance.add(Stair) ;
	}
	
	public static void initGame3() {
		
		
		Monster boss = new Monster((Monster) characters.get("mb1"));
		boss.setId(boss.getId() + "#014");
		boss.setX(900);
		boss.setY(400);
		boss.setDirection(0);
		boss.defineArea();
		
		instances.put(boss.getId(),boss);
		
		charInstances.put(boss.getId(),boss);
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
	

	public static ArrayList<String> getToBeRemoved() {
		return toBeRemoved;
	}

	public static void setToBeRemoved(ArrayList<String> toBeRemoved) {
		DataBase.toBeRemoved = toBeRemoved;
	}

	public static ArrayList<Prop> getPropInstance() {
		return propInstance;
	}

	public static void setPropInstance(ArrayList<Prop> propInstance) {
		DataBase.propInstance = propInstance;
	}
	
	
	public static ArrayList<GameObject> getToBeAdded() {
		return toBeAdded;
	}

	public static void setToBeAdded(ArrayList<GameObject> toBeAdded) {
		DataBase.toBeAdded = toBeAdded;
	}
}
