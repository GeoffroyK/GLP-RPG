package game;

import static InputControl.InputData.*;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JFrame;

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
	
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 900;
	private static final int HEIGHT = WIDTH / 12 * 9;
	private static final String NAME = "Game";

	public boolean running = false;

	private JFrame frame;

	private InputHandler input;
	private DataBase db;

	public Game() {
		setMinimumSize(new Dimension(WIDTH, HEIGHT));
		setMaximumSize(new Dimension(WIDTH, HEIGHT));
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame = new JFrame(NAME);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		frame.add(this, BorderLayout.CENTER);
		frame.pack();

		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		init();
		start();
	}

	public void init() {
		input = new InputHandler(this);
		db = new DataBase();
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
		Character ch1;
		Character ch2;
		
		inputlog();

		Collection<GameObject> valsInstances = DataBase.getInstances().values();
		Iterator<GameObject> itInstances = valsInstances.iterator();
		while (itInstances.hasNext()) {
			GameObject go = itInstances.next();
//			if(go.getClass().getName().matches("playable.Monster|playable.Player")){
//				for (int ent1 = 0; ent1 < (DataBase.getCharInstances().size() - 1); ent1++) {
//					
//					ch1 = DataBase.getCharInstances().get(ent1);
//					Colision colCh1 = new Colision((int) ch1.getX(), (int) ch1.getY(), ch1.getWidth(), ch1.getHeight());
//					System.out.println("1 : " + ch1.getClass().getName() + " / " + (int) ch1.getX() + " / " + (int) ch1.getY()
//							+ " / " + ch1.getWidth() + " / " + ch1.getHeight());
//					
//					for (int ent2 = ent1 + 1; ent2 < DataBase.getCharInstances().size(); ent2++) {
//
//						ch2 = DataBase.getCharInstances().get(ent2);
//						Colision colCh2 = new Colision((int) ch2.getX(), (int) ch2.getY(), ch2.getWidth(), ch2.getHeight());
//						System.out.println("2 : " + ch2.getClass().getName() + " / " + (int) ch2.getX() + " / "
//								+ (int) ch2.getY() + " / " + ch2.getWidth() + " / " + ch2.getHeight());
//						
//						ch1.detection(colCh2);
//						ch2.detection(colCh1);
//						
//					}
//				}
//			}

			go.tick();
		}
	}

	public void inputlog() {
		move();
		plyDirection();
	}
	
	public void move() {
		Player ply = PlayerChoice.selected();
		if ((getDown().isPressed() && getUp().isPressed())) { // UP AND DOWN
			ply.setVelY(0);
		} else if (getUp().isPressed()) { // UP
			ply.setVelY(-5);
			
		} else if (getDown().isPressed()) { // DOWN
			ply.setVelY(5);
		} else {
			ply.setVelY(0);
		}

		if (getLeft().isPressed() && getRight().isPressed()) { // LEFT AND RIGHT
			ply.setVelX(0);
		} else if (getLeft().isPressed()) { // LEFT
			ply.setVelX(-5);
		}
		else if (getRight().isPressed()) { // RIGHT
			ply.setVelX(5);
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

		Graphics g = bs.getDrawGraphics();

		g.setColor(Color.GRAY);
		g.fillRect(0, 0, getWidth(), getHeight());

		Collection<GameObject> valsInstances = DataBase.getInstances().values();
		Iterator<GameObject> itInstances = valsInstances.iterator();

		while (itInstances.hasNext()) {
			GameObject go = itInstances.next();
			go.render(g);
		}

		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		Game ga = new Game();

	}
}
