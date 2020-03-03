package game;

import static org.lwjgl.glfw.GLFW.GLFW_FALSE;
import static org.lwjgl.glfw.GLFW.GLFW_RESIZABLE;
import static org.lwjgl.glfw.GLFW.GLFW_VISIBLE;
import static org.lwjgl.glfw.GLFW.glfwCreateWindow;
import static org.lwjgl.glfw.GLFW.glfwDestroyWindow;
import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.glfw.GLFW.glfwMakeContextCurrent;
import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwShowWindow;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.glfw.GLFW.glfwWindowHint;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;

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
//		initGame();
		tick() ;
	}
	
//	private void initGame() {
//		
//		Monster ronflex = (Monster) DataBase.getCharacters().get("ma2");
//		ronflex.setX(5);
//		ronflex.setY(5);
//		ronflex.setDirection(0);
//		Monster monstre = (Monster) DataBase.getCharacters().get("mt3");
//		monstre.setX(6);
//		monstre.setY(5);
//		monstre.setDirection(0);
//		DataBase.getInstances().put(ronflex.getId(),ronflex);
//		
//		Prop coffre = new Prop("id","coffre",1,"null");
//		coffre.setX(5);
//		coffre.setY(0);
//		DataBase.getInstances().put(coffre.getId(), coffre);
//
//
//		sc = new Scanner(System.in);
//		System.out.println("CHOOSE CLASS OF CHARACTER : 't' = WARRIOR / 'y' = ARCHER / 'u' = MAGE\n OR EXIT = 'e'");
//			String input = sc.nextLine() ;
//			PlayerChoice.chooseClassPlayer(input);
//
//		InventoryKey.addLoot(loots.get("E#001"), PlayerChoice.selected());
//		InventoryKey.addLoot(loots.get("E#002"), PlayerChoice.selected());
//		
//		//SALE ENCULE RENOMME TA METHODE RUN OU TICK PAS PTN DE GAMEINPUT
//		new GameInput();
//		sc.close();
//		
//	}
	
	public void tick() {
		while(running) {
			if(glfwWindowShouldClose(window)) stop() ;
			glfwPollEvents();
			render() ;
			glfwSwapBuffers(window);
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
		
	}
}
