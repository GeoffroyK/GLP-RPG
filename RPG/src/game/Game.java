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
import GameState.InGameState;
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
		gsm = new GameStateManager(this);
		
		image = new BufferedImage (WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
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
		gsm.tick();
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		gsm.render(g);
		Graphics g2 = bs.getDrawGraphics();
		g2.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
		g2.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		Game ga = new Game();

	}
}
