package playable;

import map.Map;

public class MoveTreatment {

	public static void reposition(Player ply, int direction, int mvt, Map map) {
		switch (direction) {

		case 0:
			ply.setDirection(direction);
			if (ply.getY() - mvt >= 0) {
				if (map.isOccupied((int)ply.getX(), (int)ply.getY() - mvt)) {
					System.out.println("Case occup�e ! C'est le monstre :"
							+ map.getMonsterNameByPos((int)ply.getX(),(int) ply.getY() - mvt));
				}
				else if (map.isProp((int)ply.getX(),(int) ply.getY() - mvt)) {
					System.out.println("Case occup�e par un prop");
				}
				else {
					ply.setY(ply.getY() - mvt);
					System.out.println("X : " + (int)ply.getX() + " / Y : " + (int)ply.getY() + " / Regard : "
							+ charDirection(direction) + " - " + ply.getDirection());
				}
			} else {
				System.out.println("BLOQU� PAR UN MUR");
				ply.setY(0);
				System.out.println("X : " +(int) ply.getX() + " / Y : " +(int) ply.getY() + " / Regard : "
						+ charDirection(direction) + " - " + ply.getDirection());
			}
			break;

		case 3:
			ply.setDirection(direction);
			if (ply.getY() + mvt <= map.getWidth()) {
				if (map.isOccupied((int)ply.getX(),(int) ply.getY() + mvt)) {
					System.out.println("Case occup�e ! C'est le monstre :"
							+ map.getMonsterNameByPos((int)ply.getX(),(int) ply.getY() + mvt));
				} 
				else if (map.isProp((int)ply.getX(),(int) ply.getY() + mvt)) {
					System.out.println("Case occup�e par un prop");
				}
				else {
					ply.setY(ply.getY() + mvt);
					System.out.println("X : " + ply.getX() + " / Y : " + ply.getY() + " / Regard : "
							+ charDirection(direction) + " - " + ply.getDirection());
				}
			} else {
				System.out.println("BLOQU� PAR UN MUR");
				ply.setY(map.getWidth());
				System.out.println("X : " + ply.getX() + " / Y : " + ply.getY() + " / Regard : "
						+ charDirection(direction) + " - " + ply.getDirection());
			}
			break;

		case 1:
			ply.setDirection(direction);
			if (ply.getX() - mvt >= 0) {
				System.out.println("hi");
				if (map.isOccupied((int)ply.getX() - mvt, (int)ply.getY())) {
					System.out.println("Case occup�e ! C'est le monstre :"
							+ map.getMonsterNameByPos((int)ply.getX() - mvt, (int)ply.getY()));
				} 
				else if (map.isProp((int)ply.getX() - mvt, (int)ply.getY())) {
					System.out.println("Case occup�e c'est un prop");
				}
				else {
					ply.setX(ply.getX() - mvt);
					System.out.println("X : " + ply.getX() + " / Y : " + ply.getY() + " / Regard : "
							+ charDirection(direction) + " - " + ply.getDirection());
				}
			} else {
				System.out.println("BLOQU� PAR UN MUR");
				ply.setX(0);
				System.out.println("X : " + ply.getX() + " / Y : " + ply.getY() + " / Regard : "
						+ charDirection(direction) + " - " + ply.getDirection());
			}
			break;

		case 2:
			ply.setDirection(direction);
			if (ply.getX() + mvt <= map.getLength()) {
				if (map.isOccupied((int)ply.getX() + mvt, (int)ply.getY())) {
					System.out.println("Case occup�e ! C'est le monstre : "
							+ map.getMonsterNameByPos((int)ply.getX() + mvt,(int) ply.getY()));
				}
				else if (map.isProp((int)ply.getX() + mvt,(int) ply.getY())) { 
					System.out.println("Case occup�e c'est un prop");
				}
				else {
					ply.setX(ply.getX() + mvt);
					System.out.println("X : " + ply.getX() + " / Y : " + ply.getY() + " / Regard : "
							+ charDirection(direction) + " - " + ply.getDirection());
				}
			} else {
				System.out.println("BLOQU� PAR UN MUR");
				ply.setX(map.getLength());
				System.out.println("X : " + ply.getX() + " / Y : " + ply.getY() + " / Regard : "
						+ charDirection(direction) + " - " + ply.getDirection());
			}
			break;
		}

	}

	public static String charDirection(int direction) {
		switch (direction) {

		case 0:
			return "Haut";

		case 1:
			return "Gauche";

		case 2:
			return "Droite";

		case 3:
			return "Bas";

		default:
			return null;

		}
	}
}
