package _02_Advanced_Robot_Race;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	// Re-do the robot race recipe from level 3 module 0.
	// This time, use threads to make all of the robots go at the same time.
	// 1. make a main method
	public static void main(String[] args) {
		int numRobots = 6;

		// 2. create an array of 5 robots.
		Robot[] robotArray = new Robot[numRobots];

		// 3. use a for loop to initialize the robots.
		for (int i = 0; i < numRobots; i++) {
			robotArray[i] = new Robot();
			// 4. make each robot start at the bottom of the screen, side by side, facing up
			robotArray[i].moveTo((i + 1) * (750 / numRobots), 550);
			robotArray[i].setSpeed(10);
			robotArray[i].setAngle(0);
		}
		
		Random rand = new Random();
		int winningRobot = -1;
		//Thread[] robotThreads = new Thread[numRobots];
		List<Thread> robotThreads = Collections.synchronizedList(new ArrayList<Thread>());
		
		for(int i = 0; i < numRobots; i++) {
			int num = i;
			robotThreads.add(new Thread(() -> {
				while(true) {
					robotArray[num].move(rand.nextInt(50));
				}
			}));
		}
		
		for(int i = 0; i < numRobots; i++) {
			robotThreads.get(i).start();
		}
		
		while(winningRobot == -1) {
			for(int i = 0; i < robotArray.length; i++) {
				if(robotArray[i].getY() <= 0) {
					winningRobot = i;
					for(int j = 0; j < numRobots; j++) {
						robotThreads.get(i).interrupt();
					}
					break;
				}
			}
		}

		// 4. declare that robot the winner and throw it a party!

		robotArray[winningRobot].moveTo(450, 300);
		robotArray[winningRobot].turn(1080);

	}
}
