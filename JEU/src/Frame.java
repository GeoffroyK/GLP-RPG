import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.opengl.GL;


public class Frame {
	
	private int height = 750;
	private int width = 825 ;
	private String title = "pute";
	private long window ;
	private float x = 0 ;
	
	private boolean running = false ;
	
	public Frame() {
		
	}
	
	public void create() {
		if(!glfwInit()) {
			System.out.println("prout");
		}
		
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
		glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);
		window = glfwCreateWindow(width, height, title, 0, 0) ;
		
		if(window == 0) {
			System.out.println("dd");
		}
		
		glfwShowWindow(window);
		glfwMakeContextCurrent(window);
		GL.createCapabilities();
	}
	
	public void exit() {
		glfwDestroyWindow(window);
		System.exit(0) ;
	}
	
	public void tick() {
		while(running) {
			if(glfwWindowShouldClose(window)) stop() ;
			glfwPollEvents();
			render() ;
			glfwSwapBuffers(window);
		}
		exit() ;
	}
	
	public void start() {
		running = true ;
		tick() ;
	}
	
	public void stop() {
		running = false ;
	}
	
	public void render() {
		
		glClear(GL_COLOR_BUFFER_BIT);
		
		if(glfwGetKey(window, GLFW_KEY_W) == GL_TRUE) {
			x += 0.001f ;
		}
		
		glBegin(GL_QUADS);
		glVertex2f(-0.5f+ x, 0.5f);
		glVertex2f(0.5f+ x, 0.5f);
		glVertex2f(0.5f+ x, -0.5f);
		glVertex2f(-0.5f + x, -0.5f);
		glEnd();
	}
	
}
