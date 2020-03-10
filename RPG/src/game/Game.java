package game;

import static InputControl.InputData.* ;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Collection;
import java.util.Iterator;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.text.AttributedCharacterIterator;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import GameState.GameStateManager;
import GameState.Level1State;
import GameState.MenuState;
import HUD.inventory.HudInventory;
import HUD.top.HudTop;
import HUD.top.LifeBar;
import HUD.top.MpBar;
import InputControl.InputHandler;
import dataclasses.DataBase;
import dataclasses.GameObject;
import inventory.InventoryKey;
import loot.Loot;
import playable.CharactersInstances;
import playable.Monster;
import playable.Move;
import playable.Player;
import playable.PlayerChoice;
import playable.Character;
import dataclasses.DataBase;
import inventory.InventoryKey;
import playable.Player;

public class Game extends Canvas implements Runnable {

//	public class Game {
//		public static void main(String[] args) {
//			JFrame window = new JFrame("GAY RPG");
//			window.setContentPane(new GamePanel());
//			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			window.setResizable(false);
//			window.pack();
//			window.setVisible(true);
//		}
//	}
	
//	private static final long serialVersionUID = 1L;
//	private static final int WIDTH = 900;
//	private static final int HEIGHT = WIDTH / 12 * 9;

	//dimension
	public static final int WIDTH = 320;
	public static final int HEIGHT = 240;
	public static final int SCALE = 2;
	
	private static final String NAME = "GAY RPG";

	public boolean running = false;

	private JFrame frame;

	private InputHandler input;
	private DataBase db;

	//game state manager
	private GameStateManager gsm;
	
	//image
	private BufferedImage image;
	private Graphics2D g;
	
	private int state ;
	
	private MenuState menuState;
	private Level1State lvl1State;
	private HudTop hTop ;
	private HudInventory hInventory ;
	
	private Player p;
	
	
	public Game() {
//		setMinimumSize(new Dimension(WIDTH, HEIGHT));
//		setMaximumSize(new Dimension(WIDTH, HEIGHT));
//		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		
		frame = new JFrame(NAME);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		frame.add(this, BorderLayout.CENTER);
		frame.pack();

		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		setFocusable(true);
		requestFocus();

		init();
		start();
	}

	public void init() {
		input = new InputHandler(this);
		db = new DataBase();
		gsm = new GameStateManager();
		
		image = new BufferedImage (WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
		hTop = new HudTop() ;
		hInventory = new HudInventory(this) ;
	}

	public synchronized void start() {
		running = true;
		new Thread(this).start();
	}

	public synchronized void stop() {
		running = false;

	}

	public void run() {
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D / 60D;

		int ticks = 0;
		int frames = 0;

		long lastTimer = System.currentTimeMillis();
		double delta = 0;

		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / nsPerTick;
			lastTime = now;
			boolean shouldRender = true;

			while (delta >= 1) {
				ticks++;
				tick();
				delta -= 1;
				shouldRender = true;
			}

			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (shouldRender) {
				frames++;
				render();
			}

			if (System.currentTimeMillis() - lastTimer >= 1000) {
				lastTimer += 1000;
				System.out.println(ticks + " ticks / " + frames + " frames");
				frames = 0;
				ticks = 0;
			}

		}
	}

	public void tick() {
		gsm.update();
		inputlog();
		if(state == 0) {
			
			Collection<GameObject> valsInstances = DataBase.getInstances().values();
			Iterator<GameObject> itInstances = valsInstances.iterator();
			while (itInstances.hasNext()) {
				GameObject go = itInstances.next();

				go.tick();
			}
// 			Character ch1;
//			Character character;
//			if(go.getClass().getName().matches("playable.Monster|playable.Player")){
//			for (int ent1 = 0; ent1 < (DataBase.getCharInstances().size() - 1); ent1++) {
//				
//				ch1 = DataBase.getCharInstances().get(ent1);
//				Colision colCh1 = new Colision((int) ch1.getX(), (int) ch1.getY(), ch1.getWidth(), ch1.getHeight());
//				System.out.println("1 : " + ch1.getClass().getName() + " / " + (int) ch1.getX() + " / " + (int) ch1.getY()
//						+ " / " + ch1.getWidth() + " / " + ch1.getHeight());
//				
//				for (int ent2 = ent1 + 1; ent2 < DataBase.getCharInstances().size(); ent2++) {
//
//					ch2 = DataBase.getCharInstances().get(ent2);
//					Colision colCh2 = new Colision((int) ch2.getX(), (int) ch2.getY(), ch2.getWidth(), ch2.getHeight());
//					System.out.println("2 : " + ch2.getClass().getName() + " / " + (int) ch2.getX() + " / "
//							+ (int) ch2.getY() + " / " + ch2.getWidth() + " / " + ch2.getHeight());
//					
//					ch1.detection(colCh2);
//					ch2.detection(colCh1);
//					
//				}
//			}
//		}
		}
	}
	
	public void inputlog() {
		
		if (getInventaire().isPressed()) {
			System.out.println("Inventaire");
			state = 1 ;
			hInventory.clickableAreaCreation(PlayerChoice.selected());
		}
		if(getAutoAttack().isPressed()) {
			InventoryKey.addLoot(DataBase.getLoots().get("C#001"), PlayerChoice.selected());
			InventoryKey.addLoot(DataBase.getLoots().get("E#001"), PlayerChoice.selected());
		}
		if(getSpell1().isPressed()) {
			state = 0;
			hInventory.clickableZoneErase();
		}
		if(getSpell2().isPressed()) {
			PlayerChoice.selected().setLifePoint(20);
		}
		
		switch(GameStateManager.getCurrentState()) {

		case 0 : 
			menuState = (MenuState) gsm.getGameStates().get(GameStateManager.getCurrentState());
			if(getUp().isPressed()) {
				menuState.setCurrentChoice(menuState.getCurrentChoice()-1);
				if(menuState.getCurrentChoice() == -1) {
					menuState.setCurrentChoice(menuState.getOptions().length -1);
				}
			}
			if(getDown().isPressed()) {
				menuState.setCurrentChoice(menuState.getCurrentChoice()+1);
				if(menuState.getCurrentChoice() == menuState.getOptions().length) {
					menuState.setCurrentChoice(0);
				}
			}
			if(getEnter().isPressed()) {
				menuState.setSelected(true);
			}
			break;
		case 1 : 
			move();
			plyDirection();
			break;
		}
	}
	
	public void move() {
		lvl1State = (Level1State) gsm.getGameStates().get(GameStateManager.getCurrentState());
		Player ply = PlayerChoice.selected();
		if ((getDown().isPressed() && getUp().isPressed())) { // UP AND DOWN
			ply.setVelY(0);
		} else if (getUp().isPressed()) { // UP
			ply.setVelY(-1);
			lvl1State.getTileMap().setPosition((-1) * ply.getX(),(-1) * ply.getY() );
			
		} else if (getDown().isPressed()) { // DOWN
			ply.setVelY(1);
			lvl1State.getTileMap().setPosition((-1) * ply.getX(),(-1) * ply.getY() );
		} else {
			ply.setVelY(0);
		}

		if (getLeft().isPressed() && getRight().isPressed()) { // LEFT AND RIGHT
			ply.setVelX(0);
		} else if (getLeft().isPressed()) { // LEFT
			ply.setVelX(-1);
			lvl1State.getTileMap().setPosition( (-1) *ply.getX(),(-1) * ply.getY() );
		}
		else if (getRight().isPressed()) { // RIGHT
			ply.setVelX(1);
			lvl1State.getTileMap().setPosition((-1) * ply.getX(),(-1) * ply.getY() );
		}
		else {
			ply.setVelX(0);
		}
		
		
	}
	
	public void plyDirection() {
		Player ply = PlayerChoice.selected();
		if (getUp().isPressed()) { // UP
			ply.setDirection(0);
		}
		
		else if( getUp().isPressed() && getRight().isPressed()) {
			
		}
		if (getRight().isPressed()) { // RIGHT
			ply.setDirection(1);
		}	
		
		if (getDown().isPressed()) { // DOWN
			ply.setDirection(2);
		}
		
		if (getLeft().isPressed()) { // LEFT
			ply.setDirection(3);
		}
		

	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		gsm.draw(g);
		Graphics g2 = bs.getDrawGraphics();
		g2.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
		if(GameStateManager.getCurrentState() == 1) {
			if(state == 0) {

				g2.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
				
				hTop.render(PlayerChoice.selected(), g2);
			}
			
			if(state == 1) {
				hInventory.checking(PlayerChoice.selected(), g2);
				g2.setColor(Color.BLACK);
				g2.fillRect(0,0,getWidth(),getHeight());
				hInventory.render(PlayerChoice.selected(), g2);		
			}	
		}
	
		

		
		g2.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		Game ga = new Game();

	}
}
