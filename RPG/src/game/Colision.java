package game;

public class Colision {

	private float x;
	private float y;
	private float r;
	private int width;
	private int height;
	
	public Colision(float x, float y, int w, int h) {
		this.x = x;
		this.y = y;
		width = w;
		height = h;
	}
	
	public Colision(float x, float y, float r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}
	
	public boolean isCollide(Colision b) {
		float ax = (x + (width/2));
		float ay = (y + (height/2));
		
		float bx = (b.getX() + (b.getWidth()/2));
		float by = (b.getY() + (b.getHeight()/2));
		
		if(Math.abs(ax - bx) < (width / 2) + b.getWidth() / 2) {
			if(Math.abs(ay - by) < (height / 2) + b.getHeight() / 2) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean isCircleCollide(Colision box) {
		
		float dx = Math.max(box.getX() , Math.min(x + (r / 2), box.getX() + box.getWidth()));
		float dy = Math.max(box.getY() , Math.min(y + (r / 2), box.getX() + box.getHeight()));
		
		dx = x + (r / 2) - dx;
		dy = y + (r / 2) - dy;
		
		if(Math.sqrt(dx * dx + dy * dy ) < r / 2){
			return true;
		}
		
		return false;
		
	}
	
	
	public void setBox(float x, float y, int w, int h) {
		this.x = x;
		this.y = y;
		width = w;
		height = h;
	}
	
	public void setCircle(float x, float y, float r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}
	

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getR() {
		return r;
	}

	public void setR(float r) {
		this.r = r;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
