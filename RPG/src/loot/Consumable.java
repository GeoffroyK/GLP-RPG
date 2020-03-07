package loot;

import java.awt.Graphics;

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

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public int getVit() {
		return vit;
	}

	public void setVit(int vit) {
		this.vit = vit;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
}
