package map_objects;

import java.awt.Point;
import java.awt.Rectangle;

import GameState.GameStateManager;
import dataclasses.DataBase;
import playable.PlayerChoice;

public class PropsTreatment {

	public static void check() {
        Rectangle r =  new Rectangle((int) PlayerChoice.selected().getX() - 30, (int) PlayerChoice.selected().getY() - 30, 60, 60) ;
        for(Prop p : DataBase.getPropInstance()) {
            Point center = new Point(p.getX(), p.getY()) ;
            if(r.contains(center)) {
                if(p.getId().equals("c")) {
                    ChestTreatment.ChestOpen((Chest) p);
                }
                else if(p.getId().equals("st")) {
                    StairTreatment.manage();
                    GameStateManager.setState(GameStateManager.INGAMESTATE);
                }
                else {
                    GameStateManager.setState(GameStateManager.SELLERSTATE);
                }
            }
        }
    }
	
	public static int id() {
		Rectangle r =  new Rectangle((int) PlayerChoice.selected().getX() - 30, (int) PlayerChoice.selected().getY() - 30, 60, 60) ;
		for(Prop p : DataBase.getPropInstance()) {
			Point center = new Point(p.getX(), p.getY()) ;
			if(r.contains(center)) {
				return DataBase.getPropInstance().indexOf(p) ;
			}
		}
		return 0 ;
	}
	
}
