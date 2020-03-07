package map_objects;

import dataclasses.DataBase;
import inventory.InventoryKey;
import map.Map;
import playable.Player;
import playable.PlayerChoice;

public class PropInput {
	private Player ply;
	private Map map;
	private Prop prop;

	public PropInput(Map map) {
		prop = (Prop) DataBase.getInstances().get("id");
		ply = PlayerChoice.selected();
		this.map = map;
	}

	public boolean isReachable() {
		if (ply.getDirection() == 0) {
			return map.isProp(ply.getX(), ply.getY() - 1);
		}

		if (ply.getDirection() == 1) {
			return map.isProp(ply.getX() - 1, ply.getY());
		}

		if (ply.getDirection() == 2) {
			return map.isProp(ply.getX() + 1, ply.getY());
		}

		if (ply.getDirection() == 3) {
			return map.isProp(ply.getX(), ply.getY() + 1);
		}
		return false;
	}

	public void treatment() {
		if (isReachable()) {
			switch (prop.getType()) {
			case 0:
				System.out.println("Bonjour je suis un marchand !");
				break;
			case 1:
				System.out.println("Bonjour je suis un coffre !");
				InventoryKey.addLoot(DataBase.getLoots().get("C#001"), ply);
				break;
			case 2:
				System.out.println("Bonjour je suis une porte !");
				break;
			}
		}
	}

	public Map getMap() {
		return map;
	}
}
