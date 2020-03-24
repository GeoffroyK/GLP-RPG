package spell;

import dataclasses.DataBase;
import map.Map;
import playable.Monster;
import playable.MoveTreatment;
import playable.Player;
import playable.PlayerChoice;

public class SpellTreatment {

	private static int buffTime[] = { 0, 0, 0, 0 }; // 0 = RageBuff, 1 = SpeedBuff, 2 = DodgeBuff, 3 = CritBuff
	private static int preBuff[] = new int[4]; // 0 = RageBuff, 1 = SpeedBuff, 2 = DodgeBuff, 3 = CritBuff
	private static int cooldown[] = { 0, 0, 0, 0, 0, 0 };
	
	private static int cpt = 1;

	public static void spellUsed(Spell spell, int number) {
		Player ply = PlayerChoice.selected();
		int direction = ply.getDirection();
		if (cooldown[number] == 0 && ply.getManaPoint() >= spell.getManaUsage()) {
			switch (spell.getType()) {

			case "Dmg":
				Spell tmpSpell = new Spell(spell); // Create copy of Spell => new instance
				while(DataBase.getInstances().get(tmpSpell.getId() + "#" + cpt) != null) {
					cpt++;
				}
				tmpSpell.setId(tmpSpell.getId() + "#" + cpt);
				DataBase.getInstances().put(tmpSpell.getId(), tmpSpell);
				
				switch (direction) {

				case 0: // NORD
					tmpSpell.setVelY(-5);
					tmpSpell.setVelX(0);
					break;

				case 1: // OUEST
					tmpSpell.setVelX(-5);
					tmpSpell.setVelY(0);
					break;

				case 2: // EST
					tmpSpell.setVelX(5);
					tmpSpell.setVelY(0);
					break;

				case 3: // SUD
					tmpSpell.setVelY(5);
					tmpSpell.setVelX(0);
					break;
					
				case 10: // NORD/OUEST
					tmpSpell.setVelY(-5);
					tmpSpell.setVelX(-5);
					break;

				case 20: // NORD/EST
					tmpSpell.setVelY(-5);
					tmpSpell.setVelX(5);
					break;

				case 31: // SUD/OUEST
					tmpSpell.setVelY(5);
					tmpSpell.setVelX(-5);
					break;

				case 32: // SUD/EST
					tmpSpell.setVelY(5);
					tmpSpell.setVelX(5);
					break;
				}
				
				break;

			case "Aoe":
				break;

			case "Mvt":
				switch (direction) {

				case 0: // NORD
					ply.setY(ply.getY() - spell.getDamage());
					break;

				case 1: // OUEST
					ply.setX(ply.getX() - spell.getDamage());
					break;

				case 2: // EST
					ply.setX(ply.getX() + spell.getDamage());
					break;

				case 3: // SUD
					ply.setY(ply.getY() + spell.getDamage());
					break;
					
				case 10: // NORD/OUEST
					ply.setX(ply.getX() - spell.getDamage());
					ply.setY(ply.getY() - spell.getDamage());
					break;

				case 20: // NORD/EST
					ply.setX(ply.getX() + spell.getDamage());
					ply.setY(ply.getY() - spell.getDamage());
					break;

				case 31: // SUD/OUEST
					ply.setX(ply.getX() - spell.getDamage());
					ply.setY(ply.getY() + spell.getDamage());
					break;

				case 32: // SUD/EST
					ply.setX(ply.getX() + spell.getDamage());
					ply.setY(ply.getY() + spell.getDamage());
					break;

				}

			case "HP":
				if (ply.getLifePoint() + spell.getDamage() >= ply.getLifePointMax()) {
					ply.setLifePoint(ply.getLifePointMax());
				} else {
					ply.setLifePoint(ply.getLifePoint() + spell.getDamage());
				}
				break;

			case "MP":
				if (ply.getManaPoint() + spell.getDamage() >= ply.getManaPointMax()) {
					ply.setManaPoint(ply.getManaPointMax());
				} else {
					ply.setManaPoint(ply.getManaPoint() + spell.getDamage());
				}
				break;

			case "Rage":
				preBuff[0] = ply.getAttack();
				ply.setAttack(ply.getAttack() + spell.getDamage());
				buffTime[0] = spell.getDuration();
				break;

			case "Spd":
				preBuff[1] = ply.getSpeed();
				ply.setSpeed(ply.getSpeed() + spell.getDamage());
				buffTime[1] = spell.getDuration();
				break;

			case "Dodge":
				preBuff[2] = ply.getDodgeChance();
				ply.setDodgeChance(ply.getDodgeChance() + spell.getDamage());
				buffTime[2] = spell.getDuration();
				break;

			case "Crit":
				preBuff[3] = ply.getCriticalChance();
				ply.setCriticalChance(ply.getCriticalChance() + spell.getDamage());
				buffTime[3] = spell.getDuration();
				break;

			}
			ply.setManaPoint(ply.getManaPoint() - spell.getManaUsage());
			cooldown[number] = spell.getCooldown();
		}

	}

	public static void spellTimer() {
		Player ply = PlayerChoice.selected();
		for (int i = 0; i < cooldown.length; i++) {
			if (cooldown[i] > 0) {
				cooldown[i]--;
			}
		}
		for (int i = 0; i < buffTime.length; i++) {
			if (buffTime[i] > 0) {
				buffTime[i]--;
			}
			if (buffTime[i] == 0) {
				switch (i) {

				case 0:
					ply.setAttack(preBuff[0]);
					break;

				case 1:
					ply.setSpeed(preBuff[1]);
					break;

				case 2:
					ply.setDodgeChance(preBuff[2]);
					break;

				case 3:
					ply.setCriticalChance(preBuff[3]);
					break;

				}
			}
		}
		System.out.println("\nMana left : " + ply.getManaPoint());
		System.out.println("CoolDown : Spell1 = " + cooldown[0] + " / Spell2 = " + cooldown[1] + " / Spell3 = "
				+ cooldown[2] + " / Spell4 = " + cooldown[3] + " / Spell5 = " + cooldown[4] + " / AutoAttack = "
				+ cooldown[5]);
		System.out.println("Buff : Rage = " + buffTime[0] + " / Speed = " + buffTime[1] + " / Dodge = " + buffTime[2]
				+ " / Crit = " + buffTime[3] + "\n");
	}
}