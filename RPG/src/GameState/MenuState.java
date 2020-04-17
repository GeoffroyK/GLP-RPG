package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import InputControl.InputGame;
import TileMap.Background;
import game.Game;

public class MenuState implements GameState {
	private Background bg;
	
	private int currentChoice = 0;
	private String[] options = {
			"Start",
			"Load",
			"Quit"
	};
	
	private Color titleColor;
	private Font titleFont;
	
	private Font font;
	
	private boolean isSelected = false;
	
	
	
	public MenuState() {	
		try {
			bg = new Background("/Backgrounds/menu_bg.png",1);
			bg.setVector(-0.1, 0);
			
			titleColor = new Color(128, 0, 0);
			titleFont = new Font("Century Goth", Font.PLAIN, 100);
			font = new Font("Arial", Font.PLAIN, 80);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void select() {
		if(currentChoice == 0) {
			GameStateManager.setState(GameStateManager.SELECTIONSTATE);
		}
		if(currentChoice == 1) {
			//help
		}
		if(currentChoice == 2) {
			System.exit(0);
		}
	}
	
	public void init() {
		
	}
	
	public void tick() {
		bg.update();
		InputGame.menu();
		if(isSelected) {
			select();
		}
	}
	
	public void render(Graphics2D g) {
		//DRAW BACKGROUND
		bg.draw(g);
		
		//DRAW TITLE
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("GLP RPG !", Game.WIDTH/2 - 250, Game.HEIGHT/2 - 120);
		
		//DRAW MENU OPTIONS
		g.setFont(font);
		for(int i = 0; i<options.length; i++) {
			if(i == currentChoice) {
				g.setColor(Color.BLACK);
			}
			else {
				g.setColor(Color.ORANGE);
			}
			g.drawString(options[i], Game.WIDTH/2 - 100, Game.HEIGHT/2 + i *80);
		}
	}

	public Background getBg() {
		return bg;
	}

	public void setBg(Background bg) {
		this.bg = bg;
	}

	public int getCurrentChoice() {
		return currentChoice;
	}

	public void setCurrentChoice(int currentChoice) {
		this.currentChoice = currentChoice;
	}

	public String[] getOptions() {
		return options;
	}

	public void setOptions(String[] options) {
		this.options = options;
	}

	public Color getTitleColor() {
		return titleColor;
	}

	public void setTitleColor(Color titleColor) {
		this.titleColor = titleColor;
	}

	public Font getTitleFont() {
		return titleFont;
	}

	public void setTitleFont(Font titleFont) {
		this.titleFont = titleFont;
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
	
	
	
}
