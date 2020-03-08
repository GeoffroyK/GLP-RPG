package GameState;

import java.awt.Color;
import java.awt.Graphics2D;

import TileMap.*;
import game.GamePanel;

public class Level1State extends GameState {
	
	private GameStateManager gsm;
	
	private TileMap tileMap;
	
	public Level1State(GameStateManager gsm) {
		this.gsm = gsm;
	}
	
	public void init() {
		tileMap = new TileMap(30);
		tileMap.loadTiles("/Tilesets/grasstileset.gif");
		tileMap.loadMap("/Maps/level1-1.map");
		tileMap.setPosition(0, 0);
	}
	public void update() {}
	
	public void draw(Graphics2D g) {
		
		//CLEAR SCREEN
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		//DRAW TILE MAP
		tileMap.draw(g);
	}
	
	public void keyPressed(int k) {}
	public void keyReleased(int k) {}
	
}
