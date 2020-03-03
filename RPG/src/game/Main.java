package game;

import static org.lwjgl.glfw.GLFW.GLFW_FALSE;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_A;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_D;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_RIGHT;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_S;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_W;
import static org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_1;
import static org.lwjgl.glfw.GLFW.GLFW_RESIZABLE;
import static org.lwjgl.glfw.GLFW.GLFW_VISIBLE;
import static org.lwjgl.glfw.GLFW.glfwCreateWindow;
import static org.lwjgl.glfw.GLFW.glfwDestroyWindow;
import static org.lwjgl.glfw.GLFW.glfwGetKey;
import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.glfw.GLFW.glfwMakeContextCurrent;
import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwShowWindow;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.glfw.GLFW.glfwWindowHint;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_TRUE;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

import java.util.Scanner;

import org.lwjgl.opengl.GL;

import dataclasses.DataBase;
import inventory.InventoryKey;
import map_objects.Prop;
import playable.Monster;
import playable.PlayerChoice;

public class Main {

	private int height = 720;
	private int width = 1280 ;
	private String title = "RPG";
	private long window ;
	private float x = 0 ;
	private float y = 0 ;
	int direction = 0 ;
	
	private boolean running = false;
	
	public Main() {
		createWindow();
		start();
	}
	
	public void createWindow() {
		if(!glfwInit()) {
			System.err.println("Echec de l'initialisation");
		}
		
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
		glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);
		window = glfwCreateWindow(width, height, title, 0, 0) ;
		
		if(window == 0) {
			System.out.println("Echec de la création de la fenetre");
		}
		
		glfwShowWindow(window);
		glfwMakeContextCurrent(window);
		GL.createCapabilities();
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
			if(glfwWindowShouldClose(window)) stop() ;
			
			double time_2 = Timer.getTime(); // Actual time in each loop
			double passed= time_2 - time; // Time that has passed btw last loop
			unprocessed += passed; // Time where game isn't processed yet
			
			frame_time += passed;
			
			time = time_2;
			
			while(unprocessed >= frame_cap) { 
				unprocessed -= frame_cap;
				can_render=true;
				glfwPollEvents();
				
				if(frame_time >= 1.0) {
					frame_time = 0;
					System.out.println("FPS : " + frames );
					frames = 0;
				}
			}
			if(can_render) {
				render() ;
				glfwSwapBuffers(window);
				frames++;
			}
		}
		exit() ;
	}

	public void stop() {
		running = false ;
	}
	
	public void exit() {
		glfwDestroyWindow(window);
		System.exit(0) ;
	}
	
	public void render() {
		
		glClear(GL_COLOR_BUFFER_BIT);
		
		if(glfwGetKey(window, GLFW_KEY_W) == GL_TRUE) {
			y += 0.001f ;
			direction = 1 ;
		}
		if(glfwGetKey(window, GLFW_KEY_D)== GL_TRUE) {
			x += 0.001f ;
			direction = 2 ;
		}
		if(glfwGetKey(window, GLFW_KEY_A) == GL_TRUE) {
			x -= 0.001f ;
			direction = 3 ;
		}
		if(glfwGetKey(window, GLFW_KEY_S) == GL_TRUE) {
			y -= 0.001f ;
			direction = 4 ;
		}
		if(glfwGetKey(window, GLFW_MOUSE_BUTTON_1) == GL_TRUE) {
			System.out.println("ceci est un souris listnerer");
		}
		if(glfwGetKey(window, GLFW_KEY_RIGHT) == GL_TRUE) {
			glBegin(GL_QUADS);
			glVertex2f(-0.01f, 0.01f);
			glVertex2f(0.002f, 0.01f);
			glVertex2f(0.002f, -0.01f);
			glVertex2f(-0.01f, -0.01f);
			glEnd();	
		}
		
		glBegin(GL_QUADS);
		glVertex2f(-0.01f+ x, 0.01f + y);
		glVertex2f(0.002f+ x, 0.01f + y);
		glVertex2f(0.002f+ x, -0.01f + y);
		glVertex2f(-0.01f + x, -0.01f +y);
		glEnd();
	}
	
}
