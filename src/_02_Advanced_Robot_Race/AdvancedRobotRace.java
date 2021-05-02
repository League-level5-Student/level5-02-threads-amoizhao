package _02_Advanced_Robot_Race;

import java.util.Random;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	// Re-do the robot race recipe from level 3 module 0.
	// This time, use threads to make all of the robots go at the same time.
	public static void main(String[] args) {
		Robot bots[] = new Robot[5];
		int x = 400;
		for (int i = 0; i < bots.length; i++) {
			bots[i] = new Robot();
			bots[i].setY(700);
			bots[i].setX(x);
			x += 200;
			bots[i].setSpeed(30);
		}

		boolean ifWin = false;
		Thread[] threads = new Thread[5];
		Random number = new Random();

		while (ifWin == false) {
			for (int i = 0; i < bots.length; i++) {
				int k = i;
				threads[i] = new Thread(() -> {
					for (int j = 0; j < 130; j++) {
						bots[k].move(number.nextInt(10));
					}
				});

				if (bots[i].getX() <= 500 && bots[i].getX() > 450 && bots[i].getY() < 500 && bots[i].getY() > 450) {
					ifWin = true;
					JOptionPane.showMessageDialog(null, "Winner!");
					break;
				} else {
					ifWin = false;
				}
			}
			for (int j = 0; j < threads.length; j++) {
				threads[j].start();
			}
		}

	}
}
