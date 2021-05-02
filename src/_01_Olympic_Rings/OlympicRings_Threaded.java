package _01_Olympic_Rings;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One
	// robot should draw one ring simultaneously with the other 4 robots.
	public static void main(String args[]) {

		Robot[] robots = new Robot[5];
		for (int i = 0; i < robots.length; i++) {
			if (i < 3) {
				robots[i] = new Robot(200 + (i * 350), 200);
			} else if (i >= 3) {
				robots[i] = new Robot(375 + ((robots.length - i - 1) * 350), 500);
			}

		}

		Thread[] threads = new Thread[5];
		for (int i = 0; i < robots.length; i++) {
			int k = i;
			threads[i] = new Thread(() -> {
				for (int j = 0; j < 130; j++) {
					robots[k].penDown();
					robots[k].move(10);
					robots[k].turn(3);
				}
			});
		}

		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
	}
}
