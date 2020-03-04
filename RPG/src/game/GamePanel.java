package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
	

	private static final long serialVersionUID = 1L;
	
	private static int width;
	private static int height;
	
	private Thread thread;
	private BufferedImage img;
	private Graphics2D g;
	
	private boolean running = false;
	
	public GamePanel(int width, int height) {
		GamePanel.width = width;
		GamePanel.height= height;
		setPreferredSize(new Dimension(width,height));
		setFocusable(true); // Allows JPanel to have inputs 
		requestFocus();
	}

	public void addNotify(){
		super.addNotify(); // Notify inputs
		
		if(thread == null) {
			thread = new Thread(this,"GameThread");
			thread.start();
		}
		
	}
	
	private void init() {
		running = true;
		
		img = new BufferedImage(width,height, BufferedImage.TYPE_INT_ARGB);
		g = (Graphics2D) img.getGraphics();
		
	}
	
	public void run() {
		init();
		
		final double GAME_HERTZ = 60.0;
		final double TBU = 1000000000 / GAME_HERTZ; //Time Before Update
		
		final int MUBR = 5; // Must Update before render
		
		double lastUpdateTime = System.nanoTime();
		double lastRenderTime;
		
		final double TARGET_FPS = 60;
		final double TTBR = 1000000000 / TARGET_FPS; // Total time before render
		
		int frameCount = 0;
		int lastSecondTime = (int) (lastUpdateTime / 1000000000);
		int oldFrameCount = 0;
		
		while(running) { //Loop of game
			
			double now = System.nanoTime();
			int updateCount = 0;
			while(((now - lastUpdateTime) > TBU) && (updateCount < MUBR)) { // Calculate time between now and last Update and how many loops there was, max 5 iteration
				update();
				input();
				lastUpdateTime += TBU;
				updateCount++;
			}
			
			if(now - lastUpdateTime > TBU) { 
				lastUpdateTime = now - TBU;
			}
			
			input();
			render();
			draw();
			lastRenderTime = now;
			frameCount++;
			
			int thisSecond = (int) (lastUpdateTime / 1000000000);
			if(thisSecond > lastSecondTime) {
				if(frameCount != oldFrameCount) {
					System.out.println("NEW SECOND " + thisSecond + " " + frameCount);
					oldFrameCount = frameCount;
				}
				frameCount = 0;
				lastSecondTime = thisSecond;
			}
			
			while(now - lastRenderTime < TTBR && now - lastUpdateTime < TBU) {
				Thread.yield();
				
				try {
					Thread.sleep(1);
				} catch(Exception e) {
					System.out.println("ERROR : yielding thread");
				}
				
				now = System.nanoTime();
			}
		}
	} 
	

	private void update() {

	}
	
	private void input() {
		
	}
	
	private void render() {
		if(g != null) {
			g.setColor(new Color(55,31,155));
			g.fillRect(500, 500, 32, 32);
		}

	}

	private void draw() {
		Graphics g2 = (Graphics) this.getGraphics();
		g2.drawImage(img, 0, 0, width, height, null);
		g2.dispose();
	}





	
	
	
}
