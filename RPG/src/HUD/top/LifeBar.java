package HUD.top;

import java.awt.Color;
import java.awt.Graphics;

import playable.Player;

/*
 * Do gestion about LifeBar
 */
public class LifeBar {
	
	public void BarRender(Player hero, Graphics g) {	
		float p = ((float) hero.getLifePoint()/(float) hero.getLifePointMax())*100 ;
		
		g.setColor(Color.RED);
		g.fillRect(71, 11, (int) p , 15);
	}

}
