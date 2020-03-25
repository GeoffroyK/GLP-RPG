package HUD.top;

import java.awt.Color;
import java.awt.Graphics;

import playable.Player;

public class ExpBar {
	public void BarRender(Player hero, Graphics g) {
		/*g.setColor(Color.GRAY);
		g.fillRect(60, 47, 100, 15);*/
		
		float p = ((float) hero.getExperience()/(float) hero.getExpMax())*100 ;
		
		g.setColor(Color.GREEN);
		g.fillRect(71, 53, (int) p , 15);
	}

}
