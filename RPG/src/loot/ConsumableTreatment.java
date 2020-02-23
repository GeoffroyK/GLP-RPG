package loot;

import playable.Player;

public class ConsumableTreatment {
	
	public static void use(Consumable c, Player p) {
		if((c.getHp() + p.getLifePoint()) < p.getLifePointMax()) {
			p.setLifePoint(c.getHp() + p.getLifePoint());
		}
		else {
			p.setLifePoint(p.getLifePointMax());
		}
		
		if((c.getMp() + p.getManaPoint()) < p.getManaPointMax()) {
			p.setManaPoint(c.getMp() + p.getManaPoint());
		}
		else {
			p.setManaPoint(p.getManaPointMax());
		}
		
		p.setSpeed(c.getVit() + p.getSpeed());
	}

}
