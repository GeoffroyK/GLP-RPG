package HUD;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import playable.Player;

public class HudTop {
	
	private Image background = null ;
	
	private LifeBar lifeBar ;
	private MpBar mpBar ;
	private ExpBar expBar ;
	
	public HudTop () {
		try {
		    background = ImageIO.read(new File("C:\\Users\\Vortex\\Documents\\TestBardevie.png"));
		} catch (IOException e) {}
		
		lifeBar = new LifeBar() ;
		mpBar =  new MpBar() ;
		expBar = new ExpBar();
	}
	
	public void render(Player hero, Graphics g) {
		g.drawImage(background, 0, 0, null);
		
		lifeBar.BarRender(hero, g);
		mpBar.BarRender(hero, g);
		expBar.BarRender(hero, g);
	}
	
	

}
