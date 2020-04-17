package map_objects;

import java.awt.Point;
import java.awt.Rectangle;

import GameState.GameStateManager;
import dataclasses.DataBase;
import playable.PlayerChoice;

/*
 * Treatment of all props, call a certain methods depending of the props near the player. (Chest / Stair of Merchant)
 */
public class PropsTreatment {

	/*
	 * Check if there is a props near the player and do the action depending of the result
	 */
	public static void check() {
        Rectangle r =  new Rectangle((int) PlayerChoice.selected().getX() - 30, (int) PlayerChoice.selected().getY() - 30, 60, 60) ;
        if(DataBase.getPropInstance() != null) {
        	for(Prop p : DataBase.getPropInstance()) {
                Point center = new Point(p.getX(), p.getY()) ;
                if(r.contains(center)) {
                    if(p.getId().contains("c")) {
                        ChestTreatment.ChestOpen((Chest) p);
                    }
                    else if(p.getId().contains("st")) {
                        StairTreatment.manage();
                        GameStateManager.setState(GameStateManager.INGAMESTATE);
                    }
                    else {
                        GameStateManager.setState(GameStateManager.SELLERSTATE);
                    }
                }
            }
        }
    }
	
	/*
	 * Return the prop selected by the player
	 */
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
