package game;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_TRUE;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

import java.util.Scanner;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import dataclasses.DataBase;
import inventory.InventoryKey;
import map_objects.Prop;
import playable.Monster;
import playable.PlayerChoice;

public class Main {

	private int height = 980;
	private int width = 1440 ;
	
	private String title = "RPG";
	
	DisplayMode mode = new DisplayMode(width, height) ;
	
	private boolean running = false;
	
	public Main() {
		createWindow();
		start();
	}
	
	public void createWindow() {
		try {
			Display.setDisplayMode(mode);
			Display.setResizable(true);
			Display.setFullscreen(false);
			Display.setTitle(title);
			Display.create();
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void start() {
		running = true ;
		tick() ;
	}
	 
	
	public void tick() {
		
		boolean can_render = false;
		
		double frame_time = 0;
		int frames = 0;
		
		double frame_cap = 1.0 / 60.0; // 60 frames/sec
		double time = Timer.getTime();
		double unprocessed = 0;
		
		while(running) {
			if(Display.isCloseRequested()) stop() ;
			
		/*	double time_2 = Timer.getTime(); // Actual time in each loop
			double passed= time_2 - time; // Time that has passed btw last loop
			unprocessed += passed; // Time where game isn't processed yet
			
			frame_time += passed;
			
			time = time_2;
			
			while(unprocessed >= frame_cap) { 
				unprocessed -= frame_cap;
				can_render=true;
				
				
				if(frame_time >= 1.0) {
					frame_time = 0;
					System.out.println("FPS : " + frames );
					frames = 0;
				}
			}
			if(can_render) {*/
			Display.update();
				render() ;
				frames++;
			//}
		}
		exit() ;
	}

	public void stop() {
		running = false ;
	}
	
	public void exit() {
		Display.destroy();
		System.exit(0) ;
	}
	
	public void render() {
		
		glClear(GL_COLOR_BUFFER_BIT);
	}
	
}
