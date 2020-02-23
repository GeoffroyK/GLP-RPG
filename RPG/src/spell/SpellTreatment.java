package spell;

import java.util.HashMap;

import dataclasses.DataBase;
import dataclasses.GameObject;
import map.Map;
import playable.Monster;
import playable.MoveTreatment;
import playable.Player;

public class SpellTreatment {

<<<<<<< Upstream, based on origin/master
	public static void spellUsed(Spell spell, Player ply, Map map) {
=======
	public static void spellUsed(HashMap<String, GameObject> instances, Spell spell, Player ply, Map map) {
>>>>>>> 3d06426 add cooldown
		switch (spell.getType()) {

		case "Dmg":
			int cptRange = 1;
			boolean state = true;
			switch (ply.getDirection()) {

			/* Haut */ case 0:
				while (cptRange <= spell.getRange() && state) {
					if (map.isOccupied(ply.getX(), ply.getY() - cptRange)) {
						System.out.println("MONSTER FOUND");
						String monsterId = map.getMonsterIdByPos(ply.getX(), ply.getY() - cptRange);
<<<<<<< Upstream, based on origin/master
						Monster monster = (Monster) DataBase.getInstances().get(monsterId);
						int previousMonsterHP = monster.getLifePoint();
						monster.setLifePoint(monster.getLifePoint() - spell.getDamage());
						System.out.println("Damage Dealt : " + spell.getDamage() + "\nMonsterLife : From "
								+ previousMonsterHP + " to " + monster.getLifePoint());
						if (monster.getLifePoint() <= 0) {
							map.suppMonster(monster);
							System.out.println("MONSTER IS DEAD");
=======
						Monster monster = (Monster) instances.get(monsterId);
						int previousMonsterHP = monster.getLifePoint();
						monster.setLifePoint(monster.getLifePoint() - spell.getDamage());
						System.out.println("Damage Dealt : " + spell.getDamage() + "\nMonsterLife : From "
								+ previousMonsterHP + " to " + monster.getLifePoint());
						if(monster.getLifePoint() <= 0) {
							map.suppMonster(monster);
							System.out.println("MONSTER IS DEAD");
						}
						state = false;
					}
					cptRange++;
				}
				if(state) {
					System.out.println("MONSTER NOT FOUND");
				}
				break;

				/* Gauche */ case 1:
					while (cptRange <= spell.getRange() && state) {
						if (map.isOccupied(ply.getX() - cptRange, ply.getY())) {
							System.out.println("MONSTER FOUND");
							String monsterId = map.getMonsterIdByPos(ply.getX() - cptRange, ply.getY());
							Monster monster = (Monster) instances.get(monsterId);
							int previousMonsterHP = monster.getLifePoint();
							monster.setLifePoint(monster.getLifePoint() - spell.getDamage());
							System.out.println("Damage Dealt : " + spell.getDamage() + "\nMonsterLife : From "
									+ previousMonsterHP + " to " + monster.getLifePoint());
							if(monster.getLifePoint() <= 0) {
								map.suppMonster(monster);
								System.out.println("MONSTER IS DEAD");
							}
							state = false;
>>>>>>> 3d06426 add cooldown
						}
						state = false;
					}
<<<<<<< Upstream, based on origin/master
					cptRange++;
				}
				if (state) {
					System.out.println("MONSTER NOT FOUND");
				}
				break;

			/* Gauche */ case 1:
				while (cptRange <= spell.getRange() && state) {
					if (map.isOccupied(ply.getX() - cptRange, ply.getY())) {
						System.out.println("MONSTER FOUND");
						String monsterId = map.getMonsterIdByPos(ply.getX() - cptRange, ply.getY());
						Monster monster = (Monster) DataBase.getInstances().get(monsterId);
						int previousMonsterHP = monster.getLifePoint();
						monster.setLifePoint(monster.getLifePoint() - spell.getDamage());
						System.out.println("Damage Dealt : " + spell.getDamage() + "\nMonsterLife : From "
								+ previousMonsterHP + " to " + monster.getLifePoint());
						if (monster.getLifePoint() <= 0) {
							map.suppMonster(monster);
							System.out.println("MONSTER IS DEAD");
						}
						state = false;
					}
					cptRange++;
				}
				if (state) {
					System.out.println("MONSTER NOT FOUND");
				}
				break;

			/* Droite */ case 2:
				while (cptRange <= spell.getRange() && state) {
					if (map.isOccupied(ply.getX() + cptRange, ply.getY())) {
						System.out.println("MONSTER FOUND");
						String monsterId = map.getMonsterIdByPos(ply.getX() + cptRange, ply.getY());
						Monster monster = (Monster) DataBase.getInstances().get(monsterId);
						int previousMonsterHP = monster.getLifePoint();
						monster.setLifePoint(monster.getLifePoint() - spell.getDamage());
						System.out.println("Damage Dealt : " + spell.getDamage() + "\nMonsterLife : From "
								+ previousMonsterHP + " to " + monster.getLifePoint());
						if (monster.getLifePoint() <= 0) {
							map.suppMonster(monster);
							System.out.println("MONSTER IS DEAD");
						}
						state = false;
					}
					cptRange++;
				}
				if (state) {
					System.out.println("MONSTER NOT FOUND");
				}
				break;

			/* Bas */ case 3:
				while (cptRange <= spell.getRange() && state) {
					if (map.isOccupied(ply.getX(), ply.getY() + cptRange)) {
						System.out.println("MONSTER FOUND");
						String monsterId = map.getMonsterIdByPos(ply.getX(), ply.getY() + cptRange);
						Monster monster = (Monster) DataBase.getInstances().get(monsterId);
						int previousMonsterHP = monster.getLifePoint();
						monster.setLifePoint(monster.getLifePoint() - spell.getDamage());
						System.out.println("Damage Dealt : " + spell.getDamage() + "\nMonsterLife : From "
								+ previousMonsterHP + " to " + monster.getLifePoint());
						if (monster.getLifePoint() <= 0) {
							map.suppMonster(monster);
							System.out.println("MONSTER IS DEAD");
						}
						state = false;
					}
					cptRange++;
				}
				if (state) {
					System.out.println("MONSTER NOT FOUND");
				}
				break;
=======
					if(state) {
						System.out.println("MONSTER NOT FOUND");
					}
					break;

				/* Droite */ case 2:
					while (cptRange <= spell.getRange() && state) {
						if (map.isOccupied(ply.getX() + cptRange, ply.getY())) {
							System.out.println("MONSTER FOUND");
							String monsterId = map.getMonsterIdByPos(ply.getX() + cptRange, ply.getY());
							Monster monster = (Monster) instances.get(monsterId);
							int previousMonsterHP = monster.getLifePoint();
							monster.setLifePoint(monster.getLifePoint() - spell.getDamage());
							System.out.println("Damage Dealt : " + spell.getDamage() + "\nMonsterLife : From "
									+ previousMonsterHP + " to " + monster.getLifePoint());
							if(monster.getLifePoint() <= 0) {
								map.suppMonster(monster);
								System.out.println("MONSTER IS DEAD");
							}
							state = false;
						}
						cptRange++;
					}
					if(state) {
						System.out.println("MONSTER NOT FOUND");
					}
					break;

				/* Bas */ case 3:
					while (cptRange <= spell.getRange() && state) {
						if (map.isOccupied(ply.getX() , ply.getY()+ cptRange)) {
							System.out.println("MONSTER FOUND");
							String monsterId = map.getMonsterIdByPos(ply.getX(), ply.getY() + cptRange);
							Monster monster = (Monster) instances.get(monsterId);
							int previousMonsterHP = monster.getLifePoint();
							monster.setLifePoint(monster.getLifePoint() - spell.getDamage());
							System.out.println("Damage Dealt : " + spell.getDamage() + "\nMonsterLife : From "
									+ previousMonsterHP + " to " + monster.getLifePoint());
							if(monster.getLifePoint() <= 0) {
								map.suppMonster(monster);
								System.out.println("MONSTER IS DEAD");
							}
							state = false;
						}
						cptRange++;
					}
					if(state) {
						System.out.println("MONSTER NOT FOUND");
					}
					break;
>>>>>>> 3d06426 add cooldown
			}
			break;

		case "Mvt":
			switch (ply.getDirection()) {

			/* Haut */ case 0:
				MoveTreatment.reposition(ply, 0, spell.getDamage(), map);
				break;

			/* Gauche */ case 1:
				MoveTreatment.reposition(ply, 1, spell.getDamage(), map);
				break;

			/* Droite */ case 2:
				MoveTreatment.reposition(ply, 2, spell.getDamage(), map);
				break;

			/* Bas */ case 3:
				MoveTreatment.reposition(ply, 3, spell.getDamage(), map);
				break;
			}
			break;

		case "Crit":
<<<<<<< Upstream, based on origin/master
			ply.setCriticalChance(ply.getCriticalChance() + spell.getDamage());
			System.out.println("CRIT : +" + spell.getDamage() + "%" + " --> Crit% now : " + ply.getCriticalChance());
			break;

		case "HP":
			if (ply.getLifePoint() + spell.getDamage() < ply.getLifePointMax()) {
				ply.setLifePoint(ply.getLifePoint() + spell.getDamage());
			} else {
				ply.setLifePoint(ply.getLifePointMax());
			}
			System.out.println("Heal : " + spell.getDamage() + " -->  HP now : " + ply.getLifePoint());
			break;

		case "MP":
			if (ply.getManaPoint() + spell.getDamage() < ply.getManaPointMax()) {
				ply.setManaPoint(ply.getManaPoint() + spell.getDamage());
			} else {
				ply.setManaPoint(ply.getManaPointMax());
			}
			System.out.println("MP-UP : " + spell.getDamage() + " --> MP now" + ply.getManaPoint());
			break;

		case "Rage":
			ply.setAttack(ply.getAttack() + spell.getDamage());
			System.out.println("Dmg : +" + spell.getDamage() + " --> Dmg now : " + ply.getAttack());
			break;

		case "Spd":
			ply.setAttackSpeed(ply.getAttackSpeed() + spell.getDamage());
			System.out.println("Speed : +" + spell.getDamage() + " --> Speed now : " + ply.getAttackSpeed());
			break;

		case "Dodge":
			ply.setDodgeChance(ply.getDodgeChance() + spell.getDamage());
			System.out.println("Dodge : +" + spell.getDamage() + "%" + " --> Dodge% now : " + ply.getDodgeChance());
=======
			System.out.println("CRIT : " + ply.getCriticalChance() + " --> ");
			ply.setCriticalChance(ply.getCriticalChance() + spell.getDamage());
			System.out.println(ply.getCriticalChance());
			break;

		case "HP":
			ply.setLifePoint(ply.getLifePoint() + spell.getDamage());
			System.out.println("Heal : " + spell.getDamage() + " -->  HP Left : " + ply.getLifePoint());
			break;

		case "MP":
			System.out.println("MP : " + ply.getManaPoint() + " --> ");
			ply.setManaPoint(ply.getManaPoint() + spell.getDamage());
			System.out.println(ply.getManaPoint());
			break;

		case "Rage":
			System.out.println("DMG : " + ply.getAttack() + " --> ");
			ply.setAttack(ply.getAttack() + spell.getDamage());
			System.out.println(ply.getAttack());
			break;

		case "Spd":
			System.out.println("AttackSpeed : " + ply.getAttackSpeed() + " --> ");
			ply.setAttackSpeed(ply.getAttackSpeed() + spell.getDamage());
			System.out.println(ply.getAttackSpeed());
			break;

		case "Dodge":
			System.out.println("Dodge : " + ply.getDodgeChance() + " --> ");
			ply.setDodgeChance(ply.getDodgeChance() + spell.getDamage());
			System.out.println(ply.getDodgeChance());
>>>>>>> 3d06426 add cooldown
			break;

		case "Aoe":

		}
	}
<<<<<<< Upstream, based on origin/master
}
=======
}
		



>>>>>>> 3d06426 add cooldown
