package game;

import static InputControl.InputData.* ;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.BufferStrategy;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.text.AttributedCharacterIterator;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import HUD.inventory.HudInventory;
import HUD.top.HudTop;
import HUD.top.LifeBar;
import HUD.top.MpBar;
import InputControl.InputHandler;
import dataclasses.DataBase;
import inventory.InventoryKey;
import playable.Player;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 248;
	private static final int HEIGHT = 200;
	private static final int SCALE = 3;
	private static final String NAME = "Game";
	
	public boolean running = false;
	
	private JFrame frame;
	
	private int state ;
	
	private InputHandler input;
	private HudTop hTop ;
	private HudInventory hInventory ;
	
	private Player p;
	
	
	public Game() {
		setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
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
		input = new InputHandler(this) ;
		hTop = new HudTop() ;
		hInventory = new HudInventory(this) ;
		
		p = (Player) DataBase.getCharacters().get("pg1") ;
		DataBase.getInstances().put(p.getId(), p) ;
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
		double nsPerTick =  1000000000D/60D;
		
		int ticks = 0;
		int frames = 0;
		
		long lastTimer = System.currentTimeMillis();
		double delta = 0;
		
		while(running) {	
			long now = System.nanoTime();
			delta += (now - lastTime) / nsPerTick;
			lastTime = now;
			boolean shouldRender = true;
			
			while (delta >= 1) {
				ticks ++;
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
			
			if(shouldRender){
				frames++;
				render();
			}
			
			if(System.currentTimeMillis() - lastTimer >= 1000) {
				lastTimer += 1000;
				System.out.println(ticks+" ticks / "+frames+" frames");
				frames = 0;
				ticks = 0;
			}
			
		}
	}
	
	public void tick() {
		inputLog();
	}
	
	private void inputLog() {
		if (getUp().isPressed()) {
			System.out.println("Up");
			p.setLifePoint(50);
		}
		if (getLeft().isPressed()) {
			System.out.println("Left");
			InventoryKey.addLoot(DataBase.getLoots().get("C#001"), p);
		}
		if (getDown().isPressed()) {
			System.out.println("Down");
			InventoryKey.addLoot(DataBase.getLoots().get("E#001"), p);
		}
		if (getRight().isPressed()) {
			System.out.println("Right");
			state = 0 ;
			hInventory.clickableZoneErase();
		}
		if (getInventaire().isPressed()) {
			System.out.println("Inventaire");
			state = 1 ;
			hInventory.clickableAreaCreation(p);
		}
		if (getAutoAttack().isPressed()) {
			System.out.println("AutoAttack");
		}
		if (getSpell1().isPressed()) {
			System.out.println("Spell1");
		}
		if (getSpell2().isPressed()) {
			System.out.println("Spell2");
		}
		if (getSpell3().isPressed()) {
			System.out.println("Spell3");
		}
		if (getSpell4().isPressed()) {
			System.out.println("Spell4");
		}
		if (getSpell5().isPressed()) {
			System.out.println("Spell5");
		}
	}
	
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		if(state == 0) {
			g.setColor(Color.GRAY);
			g.fillRect(0,0,getWidth(),getHeight());
			
			hTop.render(p, g);
		}
		
		if(state == 1) {
			hInventory.checking(p, g);
			g.setColor(Color.BLACK);
			g.fillRect(0,0,getWidth(),getHeight());
			hInventory.render(p, g);		
		}
		
		g.dispose();
		bs.show();
	}
	


	public static void main(String[]args) {
		new DataBase() ;
		Game ga = new Game();	
	
	}
}
