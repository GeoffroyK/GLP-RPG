package map_objects;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import dataclasses.GameObject;

/*
 * Data class of a prop with only its position and type
 */
public class Prop extends GameObject {
	
	private String name;
	private int x;
	private int y;
	
	public Prop(String id, String name, String spritePath, int x, int y) {
		super(id, spritePath);
		this.name = name;
		this.x = x ;
		this.y = y ;
	}

		
	//Getters
	
	public String getName() {
		return name;
	}
		
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	//Setters
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}


	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void render(Graphics g) {
		Image i = null ;
		try {
			i = ImageIO.read(new File(getSpritePath())) ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(i, getX(), getY(), null) ;
		
	}

}
