package HUD;

import java.awt.Color;
import java.awt.Graphics;

import playable.Player;

public class LifeBar {
	
	public void BarRender(Player hero, Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(60, 5, 100, 15);
		
		float p = ((float) hero.getLifePoint()/(float) hero.getLifePointMax())*100 ;
		
		g.setColor(Color.RED);
		g.fillRect(60, 5, (int) p , 15);
	}

}
