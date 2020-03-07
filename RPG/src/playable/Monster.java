package playable;

import java.awt.Color;
import java.awt.Graphics;

import game.Colision;

public class Monster extends Character {

	private int lootChance;
	private int lootPrice;

	private Player ply; 
	
	private Colision monster;
	private Colision player;

	public Monster(String id, String type, int hp, int mp, int str, int dext, int intel, int def, int atk, int range,
			int inventory, int level, int atkSpeed, int ctkChance, int dodgeChance, int lootChance, int lootPrice) {

		super(id, type, hp, mp, str, dext, intel, def, atk, range, inventory, level, atkSpeed, ctkChance, dodgeChance);
		this.lootChance = lootChance;
		this.lootPrice = lootPrice;
		
	}

	public String toString() {
		return super.toString() + "\nlootChance = " + lootChance + "\nlootPrice = "
				+ lootPrice + "\n-----------------------------------------------\n";
	}

	public int getLootChance() {
		return lootChance;
	}

	public void setLootChance(int lootChance) {
		this.lootChance = lootChance;
	}

	public int getLootPrice() {
		return lootPrice;
	}

	public void setLootPrice(int lootPrice) {
		this.lootPrice = lootPrice;
	}

	public void tick() {
		
		detection();
		
		this.setX(getX() + getVelX());
		this.setY(getY() + getVelY());
	}
	
	private void move() {
		
		float diffX = getX() - PlayerChoice.selected().getX();
		float diffY = getY() - PlayerChoice.selected().getY();
		
		float distance = (float) Math.sqrt((diffX * diffX) + (diffY * diffY));
		float tmpVelX = (float) ((-1.0/distance)*diffX);
		float tmpVelY = (float) ((-1.0/distance)*diffY);
		
		setVelX(tmpVelX * 3);
		setVelY(tmpVelY * 3);
		
		
	}

	private void detection() {
		ply = PlayerChoice.selected();

		player = new Colision(ply.getX(), ply.getY(), 32, 32);
		monster = new Colision(getX()-84,getY()-84,200,200); // size/2 - width/2
		
		if(monster.isCollide(player)) {
			move();
		}
		else {
			setVelX(0);
			setVelY(0);
		}
		
//		monster = new Colision(getX()-84,getY()-84,200);
//		if(monster.isCircleCollide(player)) {
//			move();
//		}
//		else {
//			setVelX(0);
//			setVelY(0);
//		}

	}

	public void render(Graphics g) {
		
		g.setColor(Color.red);
		g.fillRect((int) getX(),(int) getY(), 32, 32);
			
		g.setColor(Color.green);
		g.drawRect((int) getX() - 84,(int) getY() - 84, 200, 200);
//	
//		g.setColor(Color.green);
//		g.drawOval((int) getX() - 85,(int) getY() - 85, 200, 200);
//		
	}

}
