package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.Collection;
import java.util.Iterator;

import HUD.* ;
import HUD.inventory.InventoryButton;
import HUD.top.HudTop;
import InputControl.InputGame;
import TileMap.*;
import dataclasses.DataBase;
import dataclasses.GameObject;
import game.Game;
import playable.Player;
import playable.PlayerChoice;

/*
 * State of the game when the player can controle the character
 */

public class InGameState implements GameState {
	
	private static TileMap tileMap;
    private HudTop bars ;
    private InventoryButton b ;
    private ActionBar a ;
	private Font f;
	private Player ply;

    private static int level ;

    public static final String LEVEL1 = "/Maps/etage1.map";
    public static final String LEVEL2 = "/Maps/etage2.map";
	public static final String LEVEL3 = "/Maps/etage3.map";


    public InGameState(Game game) {
        b = new InventoryButton(game);
        bars = new HudTop() ;
        a = new ActionBar() ;

        level = 1 ;
    }

    public void init() {
    	f = new Font("Century Goth", Font.PLAIN, 10);
        tileMap = new TileMap() ;
        tileMap.loadTiles("/Tilesets/tileset.png");

        if(level == 1) {
            tileMap.loadMap(LEVEL1);
            ply = PlayerChoice.selected();
            ply.setX(40);
            ply.setY(400);
            DataBase.getInstances().clear();
            DataBase.getCharInstances().clear();
            DataBase.getInstances().put(ply.getId(),ply);
            DataBase.getCharInstances().put(ply.getId(),ply);
            DataBase.initGame1();
        }

        if(level == 2) {
            tileMap.loadMap(LEVEL2);
            ply = PlayerChoice.selected();
            ply.setX(70);
            ply.setY(150);
            DataBase.getInstances().clear();
            DataBase.getCharInstances().clear();
            DataBase.getInstances().put(ply.getId(),ply);
            DataBase.getCharInstances().put(ply.getId(),ply);
            DataBase.initGame2();
        }

        if(level == 3) {
            tileMap.loadMap(LEVEL3);
            ply = PlayerChoice.selected();
            ply.setX(1500);
            ply.setY(600);
            DataBase.getInstances().clear();
            DataBase.getCharInstances().clear();
            DataBase.getInstances().put(ply.getId(),ply);
            DataBase.getCharInstances().put(ply.getId(),ply);
            DataBase.initGame3();
        }

        //tileMap.loadMap("/Maps/debug.map");
        tileMap.setPosition(-400, -400);
        //System.out.println(tileMap.getX());
    }
	
	public void tick() {
		InputGame.move();
		InputGame.spells();
		b.clickableAreaCreation();
		
		Iterator<GameObject> itToBeAdded = DataBase.getToBeAdded().iterator();
		while (itToBeAdded.hasNext()) {
			GameObject go = itToBeAdded.next();
			DataBase.getInstances().put(go.getId(),go);
		}
		DataBase.getToBeAdded().clear();
		
		
		Collection<GameObject> valsInstances = DataBase.getInstances().values();
		Iterator<GameObject> itInstances = valsInstances.iterator();
		while (itInstances.hasNext()) {
			GameObject go = itInstances.next();
			if(DataBase.getToBeRemoved().contains(go.getId())) {
				itInstances.remove();
				DataBase.getToBeRemoved().remove(go.getId());
			}
			go.tick();
		}
		b.checking();
	}
	

	public void render(Graphics2D g) {
		
		//CLEAR SCREEN
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		g.setFont(f);
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
	
    public static int getLevel() {
		return level;
	}

	public static void setLevel(int level) {
		InGameState.level = level;
	}
	
}
