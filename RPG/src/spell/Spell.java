package spell;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;

import dataclasses.DataBase;
import dataclasses.GameObject;
import game.Colision;
import playable.Character;
import playable.Monster;
import playable.Player;
import playable.PlayerChoice;

public class Spell extends GameObject {

	private String name;
	private String effect;
	private String type;
	private int damage;
	private int manaUsage;
	private int range;
	private int duration;
	private int cooldown;
	private float lvlScaling;
	private float statScaling;
	
	private String iconPath;
	
	private boolean launched = false;
	private boolean buffed = false;
	
	private float x;
	private float y;
	
	private float xMaxPos;
	private float xMaxNeg;
	private float yMaxPos;
	private float yMaxNeg;
	
	private float VelX;
	private float VelY;
	
	private int width = 10;
	private int height = 10;
	
	private int direction;
	private Player ply;

	public Spell(String id, String name, String effect, String type, int dmg, int mana, int range, int duration, int cd,
			float lvlS, float statS, String spritePath,String iconPath) {
		super(id,spritePath);
		this.name = name;
		this.effect = effect;
		this.type = type;
		damage = dmg;
		manaUsage = mana;
		this.range = range;
		this.duration = duration;
		cooldown = cd;
		lvlScaling = lvlS;
		statScaling = statS;
		this.iconPath = iconPath;
		

	}
	
	public Spell(Spell spell) {
		super(spell.getId(),spell.getSpritePath());
		ply = PlayerChoice.selected();
		this.name = spell.name;
		this.effect = spell.effect;
		this.type = spell.type;
		damage = spell.damage;
		manaUsage = spell.manaUsage;
		this.range = spell.range;
		this.duration = spell.duration;
		cooldown = spell.cooldown;
		lvlScaling = spell.lvlScaling;
		statScaling = spell.statScaling;
		
		setX(ply.getX() + (ply.getWidth() / 2));
		setY(ply.getY() + (ply.getHeight() / 2));
		
		xMaxPos = x + range;
		xMaxNeg = x - range;
		
		yMaxPos = y + range;
		yMaxNeg = y - range;
		
		launched = true;
		
		direction = ply.getDirection();
	}

	public void tick() {
		mobDetection();
		isOutRange();
		this.setX(getX() + getVelX());
		this.setY(getY() + getVelY());
	}

	public void render(Graphics g) {
		if(launched) {
			Image sprite = null;
			String spritePath = null;;
			switch (direction) {

			case 0: // NORD
				spritePath = getSpritePath()+"N.png";
				break;

			case 1: // OUEST
				spritePath = getSpritePath()+"O.png";
				break;

			case 2: // EST
				spritePath = getSpritePath()+"E.png";
				break;

			case 3: // SUD
				spritePath = getSpritePath()+"S.png";
				break;
				
			case 10: // NORD/OUEST
				spritePath = getSpritePath()+"NO.png";
				break;

			case 20: // NORD/EST
				spritePath = getSpritePath()+"NE.png";
				break;

			case 31: // SUD/OUEST
				spritePath = getSpritePath()+"SO.png";
				break;

			case 32: // SUD/EST
				spritePath = getSpritePath()+"SE.png";
				break;

			}
			try {
				sprite = ImageIO.read(new File(spritePath));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			g.drawImage(sprite , (int) getX() , (int) getY(), null);
//			g.setColor(Color.DARK_GRAY);
//			g.drawRect((int) getX(), (int) getY(), (int) getWidth(), (int)getHeight());
		}
		else if(buffed) {
			
		}
	}
	
	private void isOutRange() {
		if(x > xMaxPos || x < xMaxNeg || y > yMaxPos || y < yMaxNeg) {
			launched = false;
			setVelX(0);
			setVelY(0);
			DataBase.getToBeRemoved().add(getId());
		}
	}
	
	private void mobDetection() {
		
		Colision spell = new Colision(getX(), getY(), getWidth(), getHeight());

		for (Map.Entry<String, Character> item : DataBase.getCharInstances().entrySet()) {
			String key = item.getKey();
			Character character = item.getValue();

			Colision colChar = new Colision((int) (character.getX()), (int) (character.getY()),
					character.getWidth(), character.getHeight());
			if (!(ply == character)) {
				if (spell.isCollide(colChar)) {
					launched = false;
					setVelX(0);
					setVelY(0);
					
					Monster tmp = (Monster) character;
					tmp.gotHit(getDamage());
					DataBase.getToBeRemoved().add(getId());
					break;
				}
			}
		}
		
	}

	public String toString() {
		return "-----------------------------------------------\n" + super.toString() + "\nname = " + name
				+ "\neffect = " + effect + "\ntype = " + type + "\ndamage = " + damage + "\nmanaUsage = " + manaUsage
				+ "\nrange = " + range + "\nduration = " + duration + "\ncooldown = " + cooldown + "\nlvlScaling = "
				+ lvlScaling + "\nstatScaling = " + statScaling + "\n-----------------------------------------------\n";

	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public boolean isLaunched() {
		return launched;
	}

	public void setLaunched(boolean launched) {
		this.launched = launched;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getVelX() {
		return VelX;
	}

	public void setVelX(float velX) {
		VelX = velX;
	}

	public float getVelY() {
		return VelY;
	}

	public void setVelY(float velY) {
		VelY = velY;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getManaUsage() {
		return manaUsage;
	}

	public void setManaUsage(int manaUsage) {
		this.manaUsage = manaUsage;
	}

	public float getLvlScaling() {
		return lvlScaling;
	}

	public void setLvlScaling(float lvlScaling) {
		this.lvlScaling = lvlScaling;
	}

	public float getStatScaling() {
		return statScaling;
	}

	public void setStatScaling(float statScaling) {
		this.statScaling = statScaling;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getCooldown() {
		return cooldown;
	}

	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}
	
	public String getIconPath() {
		return iconPath;
	}

	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}


}
