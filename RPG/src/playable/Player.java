package playable;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Map;

import dataclasses.DataBase;
import game.Colision;
import spell.Spell;

public class Player extends Character {
	private int experience;
	private Spell[] spells;

	private Colision player;

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
		super.setX(0);
		super.setY(0);
		super.setDirection(0);
		super.setWidth(32);
		super.setHeight(32);

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
		g.setColor(Color.blue);
		g.fillRect((int) getX(), (int) getY(), 32, 32);

		g.setColor(Color.DARK_GRAY);
		g.drawRect((int) (getX() - 2), (int) (getY() - 2), (int) (32 + 4), (int) (32 + 4));
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
					System.out.println("collide");
					setVelX(0);
					setVelY(0);
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

}
