package map_objects;

import loot.Loot;

public class Chest extends Prop {
	
	private String dropID ;
	private int moneyDrop ;
	private int state ;
	
	public Chest(String id, String name, String sprite, int x, int y , String drop, int money){
		super(id, name, sprite, x, y);
		this.dropID = drop ;
		moneyDrop = money ;
		state = 0 ;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getDropID() {
		return dropID;
	}

	public void setDropID(String dropID) {
		this.dropID = dropID;
	}

	public int getMoneyDrop() {
		return moneyDrop;
	}

	public void setMoneyDrop(int moneyDrop) {
		this.moneyDrop = moneyDrop;
	}
}
