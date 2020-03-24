package GameState;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.Collection;
import java.util.Iterator;

import HUD.ActionBar;
import HUD.inventory.inventoryButton;
import HUD.top.HudTop;
import InputControl.InputGame;
import TileMap.*;
import dataclasses.DataBase;
import dataclasses.GameObject;
import game.Game;
import playable.PlayerChoice;

public class InGameState implements GameState {
	
	private static TileMap tileMap;
	private HudTop bars ;
	private inventoryButton b ;
	private ActionBar a ;
	
	public InGameState(Game game) {
		b = new inventoryButton(game);
		bars = new HudTop() ;
		a = new ActionBar() ;
	}
	
	public void init() {
		new TileMap();
		tileMap.loadTiles("/Tilesets/testtileset4.png");
		tileMap.loadMap("/Maps/underworld_sample.map");
		tileMap.setPosition(-400, -400);
		b.clickableAreaCreation();
		System.out.println(tileMap.getX());
	}
	
	public void tick() {
		InputGame.move();
		Collection<GameObject> valsInstances = DataBase.getInstances().values();
		Iterator<GameObject> itInstances = valsInstances.iterator();
		while (itInstances.hasNext()) {
			GameObject go = itInstances.next();

			go.tick();
		}
		b.checking();
	}
	
	public void render(Graphics2D g) {
		
		//CLEAR SCREEN
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		//DRAW TILE MAP
		tileMap.draw(g);
		bars.render(PlayerChoice.selected(), g);
		b.render(g);
		a.render(g) ;
		
		
		Collection<GameObject> valsInstances = DataBase.getInstances().values();
		Iterator<GameObject> itInstances = valsInstances.iterator();

		while (itInstances.hasNext()) {
			GameObject go = itInstances.next();
			go.render(g);
		}
	}
	
	public static TileMap getTileMap() {
		return tileMap;
	}

	public void setTileMap(TileMap tileMap) {
		this.tileMap = tileMap;
	}
	
}
