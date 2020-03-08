package playable;

import java.util.ArrayList;

import dataclasses.GameObject;

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
