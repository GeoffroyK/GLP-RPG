package playable;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.imageio.ImageIO;

import GameState.GameStateManager;
import GameState.InGameState;
import TileMap.Tile;
import TileMap.TileMap;
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

	private float offSetX;
	private float offSetY;

	private boolean isBlocked = false;

	private boolean alive = true;
	
	//COLLISION BOX
	protected int cwidth = 10;
	protected int cheight = 30;
	
	//COLLISION
	protected int currRow;
	protected int currCol;
	protected double xdest;
	protected double xtemp;
	private double ydest;
	protected double ytemp;
	protected boolean topLeft;
	protected boolean topRight;
	protected boolean bottomRight;
	protected boolean bottomLeft;
	
	private TileMap tileMap = InGameState.getTileMap();
	private int tileSize = 30;

	public Monster(String id, String type, int hp, int mp, int str, int dext, int intel, int def, int atk, int range,
			int inventory, int level, int atkSpeed, int ctkChance, int dodgeChance, int lootChance, int lootPrice,String spritePath) {

		super(id, type, hp, mp, str, dext, intel, def, atk, range, inventory, level, atkSpeed, ctkChance, dodgeChance,spritePath);
		this.lootChance = lootChance;
		this.lootPrice = lootPrice;

		// defineArea();
	}

	public Monster(Monster monster) {
		super(monster.getId(), monster.getType(), monster.getLifePoint(), monster.getManaPoint(), monster.getStrength(),
				monster.getDexterity(), monster.getIntelligence(), monster.getDefense(), monster.getAttack(),
				monster.getRange(), monster.getInventoryStatus(), monster.getLevel(), monster.getAttackSpeed(),
				monster.getCriticalChance(), monster.getDodgeChance(), monster.getSpritePath());
		this.lootChance = monster.lootChance;
		this.lootPrice = monster.lootPrice;
	}

	public void defineArea() {
		switch (getType()) {

		case "Guerrier":
			setWidth(32);
			setHeight(32);

			setDetectionWidth(70);
			setDetectionHeight(70);
			break;

		case "Archer":
			setWidth(20);
			setHeight(20);

			setDetectionWidth(70);
			setDetectionHeight(70);
			break;

		case "Tank":
			setWidth(20);
			setHeight(20);

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

	public void calculateOffSet() {

		float diffX = getX() - PlayerChoice.selected().getX();
		float diffY = getY() - PlayerChoice.selected().getY();

		float distance = (float) Math.sqrt((diffX * diffX) + (diffY * diffY));
		offSetX = (float) ((-1.0 / distance) * diffX);
		offSetY = (float) ((-1.0 / distance) * diffY);
	}

	public void move() {

		setVelX(offSetX);
		setVelY(offSetY);

	}

	public void detection() {
		defineArea();

		ply = PlayerChoice.selected();
		player = new Colision((int) ply.getX(), (int) ply.getY(), ply.getWidth(), ply.getHeight());
		monsterVision = new Colision(getDetectionX(), getDetectionY(), getDetectionWidth(), getDetectionHeight()); // size/2
																													// -width/2

		if (alive) {
			if (monsterVision.isCollide(player)) {
				calculateOffSet();
				monster = new Colision((int) getX() + offSetX * 2, (int) getY() + offSetY * 2, (int) (getWidth()),
						(int) (getHeight()));
				for (Map.Entry<String, Character> item : DataBase.getCharInstances().entrySet()) {
					String key = item.getKey();
					Character character = item.getValue();

					Colision colChar = new Colision((int) character.getX(), (int) character.getY(),
							character.getWidth(), character.getHeight());
					if (!(this == character)) {
						if (monster.isCollide(colChar)) {
							isBlocked = true;
							break;
						}
					}
				}

				if (!isBlocked) {
					move();
				} else {
					isBlocked = false;
					setVelX(0);
					setVelY(0);
				}
			} else {
				isBlocked = false;
				setOffSetX(0);
				setOffSetY(0);
				setVelX(0);
				setVelY(0);
			}
		}
		checkTileMapCollision();

	}
	
	public void calculateCorners(double x, double y) {
		int leftTile = (int) (x - cwidth / 2) / tileSize;
		int rightTile = (int) (x + cwidth / 2) / tileSize;
		int topTile = (int) (y - cheight / 2) / tileSize;
		int bottomTile = (int) (y + cheight / 2) / tileSize;
		
		int tl = tileMap.getType(topTile, leftTile);
		int tr = tileMap.getType(topTile, rightTile);
		int bl = tileMap.getType(bottomTile, leftTile);
		int br = tileMap.getType(bottomTile, rightTile);
		
		topLeft = tl == Tile.BLOCKED;
		topRight = tr == Tile.BLOCKED;
		bottomLeft = bl == Tile.BLOCKED;
		bottomRight = br == Tile.BLOCKED;
	}
	
	public void checkTileMapCollision() {
		monster = new Colision((int) getX() + offSetX * 2, (int) getY() + offSetY * 2, (int) (getWidth()),
				(int) (getHeight()));
		currCol = (int) monster.getX() / tileSize;
		currRow = (int) monster.getY() / tileSize;
		
		xdest = monster.getX() + getVelX();
		ydest = monster.getY() + getVelY();
		
		xtemp = monster.getX();
		ytemp = monster.getY();
		
		calculateCorners(monster.getX(), ydest);
		
		if(getVelY() < 0) {
			if(topLeft || topRight) {
				setVelY(0);
				ytemp = currRow * tileSize + cheight / 2;
			}
			
		}
		
		if(getVelY() > 0) {
			if(bottomLeft || bottomRight) {
				setVelY(0);
				ytemp = (currRow + 1) * tileSize - cheight / 2;
			}
		}
		
		calculateCorners(xdest, player.getY());
		
		if(getVelX() < 0) {
			if(topLeft || bottomLeft) {
				setVelX(0);
				xtemp = currCol * tileSize + cwidth / 2;
			}
		}
		
		if(getVelX() > 0) {
			if(topRight || bottomRight) {
				setVelX(0);
				xtemp = (currCol + 1) * tileSize - cwidth / 2;
			}
		}
	}

	public void gotHit(int damage) {
		if (getLifePoint() - damage > 0) {
			setLifePoint(getLifePoint() - damage);
			//knockback();
			//checkTileMapCollision();
		} else {
			alive = false;
			DataBase.getToBeRemoved().add(getId());
			DataBase.getCharInstances().remove(getId());
		}

	}

	public void knockback() {
		ply = PlayerChoice.selected();
		int direction = ply.getDirection();
		switch (direction) {

		case 0: // NORD
			setY(getY()-20);
			break;

		case 1: // OUEST
			setX(getX()-20);
			break;

		case 2: // EST
			setX(getX()+20);
			break;

		case 3: // SUD
			setY(getY()+20);
			break;

		case 10: // NORD/OUEST
			setX(getY()-20);
			setY(getY()-20);
			break;

		case 20: // NORD/EST
			setX(getY()+20);
			setY(getY()-20);
			break;

		case 31: // SUD/OUEST
			setX(getY()-20);
			setY(getY()+20);
			break;

		case 32: // SUD/EST
			setX(getX()+20);
			setY(getY()+20);
			break;
		}
	}

	public void setPly(Player ply) {
		this.ply = ply;
	}

	public void setMonsterVision(Colision monsterVision) {
		this.monsterVision = monsterVision;
	}

	public void setMonster(Colision monster) {
		this.monster = monster;
	}

	public void setPlayer(Colision player) {
		this.player = player;
	}

	public void setOffSetX(float offSetX) {
		this.offSetX = offSetX;
	}

	public void setOffSetY(float offSetY) {
		this.offSetY = offSetY;
	}

	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

	public void render(Graphics g) {
		if (alive) {
			Image ply = null;
			switch (getType()) {

			case "Guerrier":

				try {
					ply = ImageIO.read(new File("Ressources//HUD//SpriteCharacter//Warrior.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				g.drawImage(ply, (int) getX(), (int) getY(), null);
				break;

			case "Archer":
				try {
					ply = ImageIO.read(new File("Ressources//HUD//SpriteCharacter//Warrior.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				g.drawImage(ply, (int) getX(), (int) getY(), null);
				break;

			case "Tank":
				try {
					ply = ImageIO.read(new File("Ressources//HUD//SpriteCharacter//slimu2.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				g.drawImage(ply, (int) getX(), (int) getY(), null);
				break;
			}

//			g.setColor(Color.DARK_GRAY);
//			g.drawRect((int) (getX() + offSetX), (int) (getY() + offSetY), getWidth(), getHeight());
//
//			g.setColor(Color.green);
//			g.drawRect(getDetectionX(), getDetectionY(), getDetectionWidth(), getDetectionHeight()); // size/2 - width/2

		}
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
		return super.toString() + "\nlootChance = " + lootChance + "\nlootPrice = " + lootPrice
				+ "\n-----------------------------------------------\n";
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
