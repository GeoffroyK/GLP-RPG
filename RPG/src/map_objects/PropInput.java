package map_objects;

import map.Map;
import playable.Player;


public class PropInput {
	private Player ply;
	private Map map;
	private PropTreatment pt;
	private Prop p;
	
	public PropInput(Prop p) {
		this.p = p;
	}
	
	public boolean isReachable() {
		if(ply.getDirection() == 0) {
			return map.isProp(ply.getX(), ply.getY() - 1);
		}
		
		if(ply.getDirection() == 1) {
			return map.isProp(ply.getX() - 1, ply.getY());
		}
		
		if(ply.getDirection() == 2) {
			return map.isProp(ply.getX() + 1, ply.getY());
		}
		
		if(ply.getDirection() == 3) {
			return map.isProp(ply.getX(), ply.getY() + 1);
		}
		return false;
	}
	
	public void propAction() {
		if(isReachable()) {
			pt.interaction(p.getType());
		}
	}
}
