package playable;

import map.Map;

public class MoveTreatment {

	public static void reposition(Player ply, int direction, int mvt, Map map) {

		switch (direction) {

		case 0:
			ply.setDirection(direction);
			if (ply.getY() - mvt >= 0) {
				if (map.isOccupied(ply.getX(), ply.getY() - mvt)) {
					System.out.println("SALUT");
					System.err.println("Case occupée ! C'est le monstre :"
							+ map.getMonsterNameByPos(ply.getX(), ply.getY() - mvt));
				} else {
					System.out.println("CA VA");
					ply.setY(ply.getY() - mvt);
					System.out.println("X : " + ply.getX() + " / Y : " + ply.getY() + " / Regard : "
							+ charDirection(direction) + " - " + ply.getDirection());
				}
			} else {
				System.out.println("BLOQUÉ PAR UN MUR");
			}
			break;

		case 3:
			ply.setDirection(direction);
			if (ply.getY() + mvt < map.getWidth()) {
				if (map.isOccupied(ply.getX(), ply.getY() + mvt)) {
					System.err.println("Case occupée ! C'est le monstre :"
							+ map.getMonsterNameByPos(ply.getX(), ply.getY() + mvt));
				} else {
					ply.setY(ply.getY() + mvt);
					System.out.println("X : " + ply.getX() + " / Y : " + ply.getY() + " / Regard : "
							+ charDirection(direction) + " - " + ply.getDirection());
				}
			} else {
				System.out.println("BLOQUÉ PAR UN MUR");
			}
			break;

		case 1:
			ply.setDirection(direction);
			if (ply.getX() - mvt >= 0) {
				System.out.println("hi");
				if (map.isOccupied(ply.getX() - mvt, ply.getY())) {
					System.err.println("Case occupée ! C'est le monstre :"
							+ map.getMonsterNameByPos(ply.getX() - mvt, ply.getY()));
				} else {
					ply.setX(ply.getX() - mvt);
					System.out.println("X : " + ply.getX() + " / Y : " + ply.getY() + " / Regard : "
							+ charDirection(direction) + " - " + ply.getDirection());
				}
			} else {
				System.out.println("BLOQUÉ PAR UN MUR");
			}
			break;

		case 2:
			ply.setDirection(direction);
			if (ply.getX() + mvt < map.getLength()) {
				if (map.isOccupied(ply.getX() + mvt, ply.getY())) {
					System.err.println("Case occupée ! C'est le monstre :"
							+ map.getMonsterNameByPos(ply.getX() + mvt, ply.getY()));
				} else {
					ply.setX(ply.getX() + mvt);
					System.out.println("X : " + ply.getX() + " / Y : " + ply.getY() + " / Regard : "
							+ charDirection(direction) + " - " + ply.getDirection());
				}
			} else {
				System.out.println("BLOQUÉ PAR UN MUR");
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
