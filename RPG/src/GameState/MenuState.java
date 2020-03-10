package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import TileMap.Background;

public class MenuState extends GameState {
	private Background bg;
	private GameStateManager gsm;
	
	private int currentChoice = 0;
	private String[] options = {
			"Start",
			"Help",
			"Quit"
	};
	
	private Color titleColor;
	private Font titleFont;
	
	private Font font;
	
	private boolean isSelected = false;
	
	
	
	public MenuState(GameStateManager gsm) {
		this.gsm = gsm;
		
		try {
			bg = new Background("/Backgrounds/menu_bg.gif",1);
			bg.setVector(-0.1, 0);
			
			titleColor = new Color(128, 0, 0);
			titleFont = new Font("Century Goth", Font.PLAIN, 28);
			font = new Font("Arial", Font.PLAIN, 12);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void select() {
		if(currentChoice == 0) {
			gsm.setState(GameStateManager.LEVEL1STATE);
		}
		if(currentChoice == 1) {
			//help
		}
		if(currentChoice == 2) {
			System.exit(0);
		}
	}
	
	public void init() {}
	public void update() {
		bg.update();
		if(isSelected) {
			select();
		}
	}
	
	public void draw(Graphics2D g) {
		//DRAW BACKGROUND
		bg.draw(g);
		
		//DRAW TITLE
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("GAY RPG !", 80, 70);
		
		//DRAW MENU OPTIONS
		g.setFont(font);
		for(int i = 0; i<options.length; i++) {
			if(i == currentChoice) {
				g.setColor(Color.BLACK);
			}
			else {
				g.setColor(Color.ORANGE);
			}
			g.drawString(options[i], 145, 140 + i *15);
		}
	}
	
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_ENTER) {
			select();
		}
		
		if(k == KeyEvent.VK_UP) {
			currentChoice--;
			if(currentChoice == -1) {
				currentChoice = options.length - 1 ;
			}
		}
		
		if(k == KeyEvent.VK_DOWN) {
			currentChoice++;
			if(currentChoice == options.length) {
				currentChoice = 0;
			}
		}
	}
	public void keyReleased(int k) {}

	public Background getBg() {
		return bg;
	}

	public void setBg(Background bg) {
		this.bg = bg;
	}

	public GameStateManager getGsm() {
		return gsm;
	}

	public void setGsm(GameStateManager gsm) {
		this.gsm = gsm;
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