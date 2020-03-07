package HUD;

import java.awt.Color;
import java.awt.Graphics;

import playable.Player;

public class MpBar {
	
	public void BarRender(Player hero, Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(60, 26, 100, 15);
		
		float p = ((float) hero.getManaPoint()/(float) hero.getManaPointMax())*100 ;
		
		g.setColor(Color.BLUE);
		g.fillRect(60, 26, (int) p , 15);
	}

}
