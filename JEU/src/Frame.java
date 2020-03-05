import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.opengl.GL;

public class Frame {

	private int height = 720;
	private int width = 1280;
	private String title = "RPG";
	private long window;
	private float x = 0;
	private float y = 0;
	int d = 0;

	private boolean running = false;

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
		System.exit(0);
	}

	public void start() {
		running = true;
		tick();
	}

	public void stop() {
		running = false;
	}

	public void tick() {
		while (running) {
			if (glfwWindowShouldClose(window)) {
				stop();
			}
			glfwPollEvents();
			update();
			render();
			glfwSwapBuffers(window);
		}
		exit();
	}

	private void update() {

	}

	public void render() {

		glClear(GL_COLOR_BUFFER_BIT);

		if (glfwGetKey(window, GLFW_KEY_W) == GL_TRUE) {
			y += 0.001f;
			d = 1;
		}
		if (glfwGetKey(window, GLFW_KEY_D) == GL_TRUE) {
			x += 0.001f;
			d = 2;
		}
		if (glfwGetKey(window, GLFW_KEY_A) == GL_TRUE) {
			x -= 0.001f;
			d = 3;
		}
		if (glfwGetKey(window, GLFW_KEY_S) == GL_TRUE) {
			y -= 0.001f;
			d = 4;
		}
		if(glfwGetKey(window, GLFW_MOUSE_BUTTON_1) == GL_TRUE) {
			System.out.println("ceci est un souris listnerer");
		}
		if (glfwGetKey(window, GLFW_KEY_RIGHT) == GL_TRUE) {
			glBegin(GL_QUADS);
			glVertex2f(-0.01f, 0.01f);
			glVertex2f(0.002f, 0.01f);
			glVertex2f(0.002f, -0.01f);
			glVertex2f(-0.01f, -0.01f);
			glEnd();
		}

		glBegin(GL_QUADS);
		glVertex2f(-0.01f + x, 0.01f + y);
		glVertex2f(0.002f + x, 0.01f + y);
		glVertex2f(0.002f + x, -0.01f + y);
		glVertex2f(-0.01f + x, -0.01f + y);
		glEnd();
	}

}
