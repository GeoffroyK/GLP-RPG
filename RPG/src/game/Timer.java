package game;

public class Timer {

	public static double getTime() {
		return (double)System.nanoTime() / (double) 1000000000L; // nanoseconde / 1 milliard pour des secondes
	}
}
