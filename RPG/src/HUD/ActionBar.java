package HUD;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import game.Game;
import playable.PlayerChoice;
import spell.Spell;

public class ActionBar {
	private Image background = null ;
	
	public ActionBar() {
		try {
			background = ImageIO.read(new File("Ressources//HUD//InventoryHUD//SpellBar.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void render(Graphics2D g) {
		int x = Game.WIDTH/2 - 170  ;
		g.drawImage(background, Game.WIDTH/2 - 180 , Game.HEIGHT - 60, null) ;
		for(int i = 0 ; i < PlayerChoice.selected().getSpells().length; i++) {
			Image SpellSprite = null ;
			Spell tmp = PlayerChoice.selected().getSpells()[i];
			try {
				SpellSprite = ImageIO.read(new File(tmp.getIconPath()));//PlayerChoice.selected().getSpritePath())) ;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g.drawImage(SpellSprite, x, Game.HEIGHT - 50, null);
			x += 50 ;
		}
		Image SpellSprite = null ;
		try {
			SpellSprite = ImageIO.read(new File("Ressources\\HUD\\iconSpell\\life_potion.png"));//PlayerChoice.selected().getSpritePath())) ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(SpellSprite, x, Game.HEIGHT - 50, null);
		System.out.println("l");		
	}

	
}
