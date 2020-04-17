package playable;

import java.util.ArrayList;

import dataclasses.GameObject;

/*
 * Management of all Character Instances of the game, add or delete in a Hashmap
 */
public class CharactersInstances {

	private static ArrayList<GameObject> charactersInstances = new ArrayList<GameObject>();
	
	public static void addCharactersInstances(GameObject c) {
		charactersInstances.add(c);
	}
	
	public static void removeCharactersInstances(GameObject c) {
		charactersInstances.remove(c);
	}
	public static ArrayList<GameObject> getCharactersInstances() {
		return charactersInstances;
	}
	
	
}
