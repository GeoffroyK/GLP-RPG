package map;

import java.util.ArrayList;

import map_objects.Prop;
import playable.Monster;

public class Map {
	
	private static final int LENGTH = 100;
	private static final int WIDTH = 100;
	
	private int width;
	private int length;
	private ArrayList<Monster> monsters = new ArrayList<Monster>();
	private ArrayList<Prop> props = new ArrayList<Prop>();
		
	public Map() {
		width = WIDTH;
		length = LENGTH;
	}
	
	public void addMonster(Monster mob) {
		monsters.add(mob);
	}
	
	public void addProp(Prop prop) {
		props.add(prop);
	}
	
	public String getMonsterNameByPos(int x, int y) {
		for(Monster e : monsters) {
			if((x == e.getX())&&(y == e.getY())){
				return e.getType();
			}
		}
		return "none";
	}
	
	public boolean isOccupied(int x, int y) {
		for(Monster e : monsters) {
			if((x == e.getX())&&(y == e.getY())){
				return true;
			}
		}
		return false;
	}
	
	public boolean isProp(int x, int y) {
		for(Prop e : props) {
			if((x == e.getX())&&(y == e.getY())){
				return true;
			}
		}
		return false;
	}
	
	public int getLength() {
		return length;
	}
	
	public int getWidth() {
		return width;
	}
}
