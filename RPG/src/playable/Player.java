package playable;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;

import GameState.GameStateManager;
import dataclasses.DataBase;
import game.Colision;
import game.Game;
import spell.Spell;

public class Player extends Character {
	private int experience;
	private Spell[] spells;

	private Colision player;
	
	private GameStateManager gsm;

	public Player(String id, String type, int hp, int mp, int str, int dext, int intel, int def, int atk, int range,
			int inventory, int level, int atkSpeed, int ctkChance, int dodgeChance, int exp, Spell spell1, Spell spell2,
			Spell spell3, Spell spell4, Spell spell5, Spell spell6) {

		super(id, type, hp, mp, str, dext, intel, def, atk, range, inventory, level, atkSpeed, ctkChance, dodgeChance);
		experience = exp;
		spells = new Spell[6];
		spells[0] = spell1;
		spells[1] = spell2;
		spells[2] = spell3;
		spells[3] = spell4;
		spells[4] = spell5;
		spells[5] = spell6;
		super.setX(200);
		super.setY(200);
		super.setDirection(0);
		super.setWidth(10);
		super.setHeight(20);

//		PlayerTreatment.initSpells(this);

	}

	public String toString() {
		return super.toString() + "\nexp = " + experience + "\nSpell1 = " + this.spells[0].getName() + "\nSpell2 = "
				+ this.spells[1].getName() + "\nSpell3 = " + this.spells[2].getName() + "\nSpell4 = "
				+ this.spells[3].getName() + "\nSpell5 = " + this.spells[4].getName() + "\nSpell6 = "
				+ this.spells[5].getName() + "\n-----------------------------------------------\n";

	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public Spell[] getSpells() {
		return spells;
	}

	public void setSpells(Spell[] spells) {
		this.spells = spells;
	}

	public void tick() {
		detection();
		this.setX(getX() + getVelX());
		this.setY(getY() + getVelY());

	}

	public void render(Graphics g) {
//		g.setColor(Color.blue);
//		g.fillRect((int) getX(), (int) getY(), getWidth(), getHeight());
		
		Image ply = null;
		try {
			ply = ImageIO.read(new File("Ressources//HUD//SpriteCharacter//New_Piskel.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(ply , (int) getX() , (int) getY(), null);

		g.setColor(Color.DARK_GRAY);
		g.drawRect((int) (getX() - 2), (int) (getY() - 2), (int) (getWidth() + 4), (int) (getHeight() + 4));
	}

	public void detection() {
		
		calculateDirection();
		player = new Colision(getX(), getY(), 32, 32);

		for (Map.Entry<String, Character> item : DataBase.getCharInstances().entrySet()) {
			String key = item.getKey();
			Character character = item.getValue();

			Colision colChar = new Colision((int) (character.getX()), (int) (character.getY()),
					character.getWidth(), character.getHeight());
			if (!(this == character)) {
				if (player.isCollide(colChar)) {
//					System.out.println("collide");
					if(getLifePoint() > 1) {
						setLifePoint(getLifePoint()-1);
					}
					
//					setVelX(0);
//					setVelY(0);
				}
			}
		}
	}

	private void calculateDirection() {
		if(getVelY() == -5) { //HAUT
			if(getVelX() == -5) { // HAUT-GAUCHE
				setDirection(3.5f);
			}
			else if(getVelY() == 5) { // HAUT-DROITE
				setDirection(0.5f);
			}
			else {
				setDirection(0);
			}
		}
		else if(getVelY() == 5) { // BAS
			if(getVelX() == -5) { // BAS-GAUCHEddzdd
				setDirection(2.5f);
			}
			else if(getVelY() == 5) { // BAS-DROITE
				setDirection(0.5f);
			}
			else {
				setDirection(0);
			}
		}
		
	}
	
	public GameStateManager getGsm() {
		return gsm;
	}

	public void setGsm(GameStateManager gsm) {
		this.gsm = gsm;
	}

}
