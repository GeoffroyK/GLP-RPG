package GameState;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.Collection;
import java.util.Iterator;

import TileMap.*;
import dataclasses.DataBase;
import dataclasses.GameObject;
import game.GamePanel;

public class Level1State extends GameState {
	
	private GameStateManager gsm;
	
	private TileMap tileMap;
	
	public Level1State(GameStateManager gsm) {
		this.gsm = gsm;
	}
	
	public void init() {
		tileMap = new TileMap(30);
		tileMap.loadTiles("/Tilesets/testtileset2.png");
		tileMap.loadMap("/Maps/sublime_map.map");
		tileMap.setPosition(-400, -400);
		System.out.println(tileMap.getX());
	
	}
	public void update() {}
	
	public void draw(Graphics2D g) {
		
		//CLEAR SCREEN
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		//DRAW TILE MAP
		tileMap.draw(g);
		
		Collection<GameObject> valsInstances = DataBase.getInstances().values();
		Iterator<GameObject> itInstances = valsInstances.iterator();

		while (itInstances.hasNext()) {
			GameObject go = itInstances.next();
			go.render(g);
		}
	}
	
	public void keyPressed(int k) {
		
		if(k == KeyEvent.VK_DOWN) {
			tileMap.setPosition(tileMap.getX(), tileMap.getY() - 20);
		}
		
		if(k == KeyEvent.VK_UP) {
			tileMap.setPosition(tileMap.getX(), tileMap.getY() + 20);
		}
		
		if(k == KeyEvent.VK_LEFT) {
			tileMap.setPosition(tileMap.getX() + 20, tileMap.getY());
		}
		
		if(k == KeyEvent.VK_RIGHT) {
			tileMap.setPosition(tileMap.getX() - 20, tileMap.getY());
		}
	}
	public void keyReleased(int k) {}
	
	public GameStateManager getGsm() {
		return gsm;
	}

	public void setGsm(GameStateManager gsm) {
		this.gsm = gsm;
	}

	public TileMap getTileMap() {
		return tileMap;
	}

	public void setTileMap(TileMap tileMap) {
		this.tileMap = tileMap;
	}
	
}
