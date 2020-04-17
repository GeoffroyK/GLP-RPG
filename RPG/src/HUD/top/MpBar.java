package HUD.top;

import java.awt.Color;
import java.awt.Graphics;

import playable.Player;

/*
 * Do gestion about ManaBar
 */
public class MpBar {
	
	public void BarRender(Player hero, Graphics g) {
		float p = ((float) hero.getManaPoint()/(float) hero.getManaPointMax())*100 ;
		
		g.setColor(Color.BLUE);
		g.fillRect(71, 32, (int) p , 15);
	}

}
