package loot;

public class Consumable extends Loot {	
	
	private int hp;
	private int mp;
	private int vit;
	
	public Consumable(String id, double price, String name, String textBox, String spritePath, int hp, int mp, int vit, int size) {
		super(id, price, name, textBox, spritePath, size);
		this.hp = hp ;
		this.mp = mp;
		this.vit = vit ;
	}
	
	public String toString() {
		return super.toString() + "\nStat / hp : " + hp + " / mp : " + mp + " / vit : " + vit +"\n";
	}
}
