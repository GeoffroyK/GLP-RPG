package map_objects;

import java.awt.Point;
import java.awt.Rectangle;

import dataclasses.DataBase;
import playable.PlayerChoice;

public class PropsTreatment {

	public static void check() {
		Rectangle r =  new Rectangle((int) PlayerChoice.selected().getX() - 30, (int) PlayerChoice.selected().getY() - 30, 60, 60) ;
		for(Prop p : DataBase.getPropInstance()) {
			Point center = new Point(p.getX(), p.getY()) ;
			if(r.contains(center)) {
				System.out.println("izi");
				ChestTreatment.ChestOpen((Chest) p);
			}
		}
	}
	
}
