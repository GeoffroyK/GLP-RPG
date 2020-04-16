package HUD.top;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import playable.Player;
import playable.PlayerChoice;

public class HudTop {
	
	private Image background = null ;
	
	private LifeBar lifeBar ;
	private MpBar mpBar ;
	private ExpBar expBar ;
	private Player ply;
	private String key;
	
	public HudTop () {
		ply = PlayerChoice.selected();
		switch(ply.getType()) {
		
		case "Sorcier" :
			key = "Ressources//HUD//HUDtop//BarresMage.png";
			break;
		
		case "Archer" :
			key = "Ressources//HUD//HUDtop//BarresArcher.png";
			break;
			
		case "Guerrier" :
			key = "Ressources//HUD//HUDtop//BarresGuerrier.png";
			break;
		}
		try {
			System.out.println(ply.getType());
		    background = ImageIO.read(new File(key));
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
