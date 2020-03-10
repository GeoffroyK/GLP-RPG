package TileMap;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import game.*;
import TileMap.Tile;
import javax.imageio.ImageIO;

public class TileMap {	
	//position
	private double x = 0;
	private double y = 0;
	
	//bounds
	private int xmin = 0;
	private int ymin = 0;
	private int xmax = 600;
	private int ymax = 600;
	
	private double tween;
	
	//map
	private int[][] rcMap;
	private int tileSize;
	private int numRows;
	private int numCols;
	private int width;
	private int height;
	
	//tileset
	private BufferedImage tileset;
	private int numTilesAccross;
	private Tile[][] tiles;
	
	//drawing
	private int rowOffset;
	private int colOffset;
	private int numRowsToDraw;
	private int numColsToDraw;
	
	
	public TileMap(int tileSize) {
		this.tileSize = tileSize;
		numRowsToDraw = GamePanel.HEIGHT / tileSize + 2;
		numColsToDraw = GamePanel.WIDTH / tileSize + 2;
		tween = 0.07;
	}
	
	public void loadTiles(String s) {
		
		try {
			tileset = ImageIO.read(getClass().getResourceAsStream(s));
			numTilesAccross = tileset.getWidth() / tileSize;
			tiles = new Tile[2][numTilesAccross];
			
			BufferedImage subimage;
			for(int col = 0; col < numTilesAccross; col++) {
				subimage = tileset.getSubimage(col * tileSize, 0, tileSize, tileSize);
				tiles[0][col] = new Tile(subimage, Tile.NORMAL);
				subimage = tileset.getSubimage(col * tileSize, tileSize, tileSize, tileSize);
				tiles[1][col] = new Tile(subimage, Tile.BLOCKED);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void loadMap(String s) {
		try {
			InputStream in = getClass().getResourceAsStream(s);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			numCols = Integer.parseInt(br.readLine());
			numRows = Integer.parseInt(br.readLine());
			rcMap = new int[numRows] [numCols];
			width = numCols * tileSize;
			height = numRows * tileSize;
			
			String delims = "\\s+";
			for(int row = 0; row < numRows; row++) {
				String line = br.readLine();
				String[] fields = line.split(delims);
				for(int col = 0; col < numCols; col++) {
					rcMap[row][col] = Integer.parseInt(fields[col]);
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getType(int row, int col) {
		int rc = rcMap[row][col];
		int r = rc / numTilesAccross;
		int c = rc % numTilesAccross;
		return tiles[r][c].getType();
	}
	
	public void setPosition(double x, double y) {
		this.x += ((x - this.x) * tween);
		this.y += ((y - this.y) * tween);
		
		//fixBounds();
		
		colOffset = (int) - this.x / tileSize;
		rowOffset = (int) - this.y / tileSize;
	}
	

	private void fixBounds() {
		if(x < xmin) x = xmin;
		if(y < ymin) y = ymin;
		if(x > xmax) x = xmax;
		if(y > ymax) y = ymax;
	}
	
	public void draw(Graphics2D g) {
		for(int row = rowOffset; row < rowOffset + numRowsToDraw; row++) {
			if(row >= numRows) {
				break;
			}
			for(int col = colOffset; col < colOffset + numColsToDraw; col++) {
				if(col >= numCols) {
					break;
				}
				if(rcMap[row][col] == 0) {
					continue;
				}
				
				int rc = rcMap[row][col];
				int r = rc / numTilesAccross;
				int c = rc % numTilesAccross;
				
				g.drawImage(tiles[r][c].getImage(), (int)x + col * tileSize, (int)y + row * tileSize, null);
			}
		}
	}
	
	
	public int getTileSize() {
		return tileSize;
	}
	
	public int getX() {
		return (int) x;
	}
	
	public int getY() {
		return (int) y;
	}
	
	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}