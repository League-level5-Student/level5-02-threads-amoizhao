package _01_Olympic_Rings;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One robot should draw one ring simultaneously with the other 4 robots.
	public static void main(String args[]) {

	Robot[] robots = new Robot[5];
	for(int i = 0; i<robots.length; i++) {
		if(i<3) {
			robots[i] = new Robot(200+(i*350), 200);
		} else if(i>=3) {
			robots[i] = new Robot(375+((robots.length-i-1)*350), 500);
		}
	
	}
	
	for(int i = 0; i<robots.length; i++) {
		Thread r1 = new Thread(()-> {
			robots[i].move(10);
		});
	}
	}
}

