package playable;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import dataclasses.DataBase;
import dataclasses.GameObject;
import game.Colision;

public class Monster extends Character {

	private int lootChance;
	private int lootPrice;

	private Player ply; 
	
	private Colision monsterVision;
	private Colision monster;
	private Colision player;
	
	private int detectionWidth;
	private int detectionHeight;
	
	private int detectionX;
	private int detectionY;

	public Monster(String id, String type, int hp, int mp, int str, int dext, int intel, int def, int atk, int range,
			int inventory, int level, int atkSpeed, int ctkChance, int dodgeChance, int lootChance, int lootPrice) {

		super(id, type, hp, mp, str, dext, intel, def, atk, range, inventory, level, atkSpeed, ctkChance, dodgeChance);
		this.lootChance = lootChance;
		this.lootPrice = lootPrice;
		
		//defineArea();
	}
	
	public void defineArea() {
		switch(getType()) {
		
		case "Guerrier" : 		
			setWidth(32);
			setHeight(32);
			
			setDetectionWidth(150);
			setDetectionHeight(150);
			break;
			
		case "Archer" :
			setWidth(20);
			setHeight(20);
			
			setDetectionWidth(400);
			setDetectionHeight(400);
			break;

		case "Tank" : 
			setWidth(50);
			setHeight(50);
			
			setDetectionWidth(200);
			setDetectionHeight(200);
			break;
		}
		
		setDetectionX((int) (getX() - ((getDetectionWidth() / 2) - (getWidth() / 2)))); // size/2 - width/2
		setDetectionY((int) (getY() - ((getDetectionHeight() / 2) - (getHeight() / 2)))); // size/2 - width/2
	}
	
	public void tick() {
		
		detection();
		
		this.setX(getX() + getVelX());
		this.setY(getY() + getVelY());
	}
	
	public void move() {
		
		float diffX = getX() - PlayerChoice.selected().getX();
		float diffY = getY() - PlayerChoice.selected().getY();
		
		float distance = (float) Math.sqrt((diffX * diffX) + (diffY * diffY));
		float tmpVelX = (float) ((-1.0/distance)*diffX);
		float tmpVelY = (float) ((-1.0/distance)*diffY);
		
		setVelX(tmpVelX * 3);
		setVelY(tmpVelY * 3);
		
		
	}

	public void detection() {
		defineArea();
		
		ply = PlayerChoice.selected();
		player = new Colision ((int) ply.getX(),(int) ply.getY(), ply.getWidth(), ply.getHeight());
		monster = new Colision((int) getX(),(int) getY(), getWidth(), getHeight());
		monsterVision = new Colision(getDetectionX(),getDetectionY(), getDetectionWidth(), getDetectionHeight()); // size/2 - width/2

		if(monsterVision.isCollide(player)) {
			for (Map.Entry<String, Character> item : DataBase.getCharInstances().entrySet()) {
			    String key = item.getKey();
			    Character character = item.getValue();
			    
			    Colision colChar = new Colision((int) character.getX(),(int) character.getY(), character.getWidth(), character.getHeight());
			    if(!(this == character)) {
			    	System.out.println(character.getType());
					if(!monster.isCollide(colChar)) {
						move();
					}
					else {
						setVelX(0);
						setVelY(0);
					}
					
			    }
			}
		
		}
		else {
			setVelX(0);
			setVelY(0);
		}

//		defineArea();
//		ply = PlayerChoice.selected();
//
//		player = new Colision(ply.getX(), ply.getY(), 32, 32);
//		monster = new Colision((int) getX(),(int) getY(), getWidth(), getHeight());
//		monsterVision = new Colision(getDetectionX(),getDetectionY(), getDetectionWidth(), getDetectionHeight()); // size/2 - width/2
//		
//		if(monsterVision.isCollide(player)) {
//			if(!monster.isCollide(player)) {
//				move();
//			}
//			else {
//				setVelX(0);
//				setVelY(0);
//			}
//		}
//		else {
//			setVelX(0);
//			setVelY(0);
//		}
		
		
		
//		monster = new Colision(getX()-84,getY()-84,200);
//		if(monster.mobDetectionCircle(player)) {
//			System.out.println("detected");
////			move();
//		}
//		else {
//			setVelX(0);
//			setVelY(0);
//		}

	}

	public void render(Graphics g) {
		 
		switch(getType()) {
		
		case "Guerrier" : 		
			g.setColor(Color.red);
			break;
			
		case "Archer" :
			g.setColor(Color.yellow);
			break;

		case "Tank" : 
			g.setColor(Color.black);
			break;
		}
		g.fillRect((int) getX(),(int) getY(), getWidth(), getHeight());
		
		g.setColor(Color.green);
		g.drawRect(getDetectionX(),getDetectionY(), getDetectionWidth(), getDetectionHeight());  // size/2 - width/2
		
//		g.setColor(Color.green);
//		g.drawOval((int) getX() - 85,(int) getY() - 85, 200, 200);
		
	}
	
	public int getDetectionX() {
		return detectionX;
	}

	public void setDetectionX(int detectionX) {
		this.detectionX = detectionX;
	}

	public int getDetectionY() {
		return detectionY;
	}

	public void setDetectionY(int detectionY) {
		this.detectionY = detectionY;
	}

	public int getDetectionWidth() {
		return detectionWidth;
	}

	public void setDetectionWidth(int detectionWidth) {
		this.detectionWidth = detectionWidth;
	}

	public int getDetectionHeight() {
		return detectionHeight;
	}

	public void setDetectionHeight(int detectionHeight) {
		this.detectionHeight = detectionHeight;
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



}
