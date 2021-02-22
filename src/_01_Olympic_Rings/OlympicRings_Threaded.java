package _01_Olympic_Rings;

import java.awt.Color;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One
	// robot should draw one ring simultaneously with the other 4 robots.

	public static void main(String args[]) {
		Robot robot1 = new Robot(200, 300);
		Robot robot2 = new Robot(350, 450);
		Robot robot3 = new Robot(500, 300);
		Robot robot4 = new Robot(650, 450);
		Robot robot5 = new Robot(800, 300);

		robot1.setSpeed(10);
		robot2.setSpeed(10);
		robot3.setSpeed(10);
		robot4.setSpeed(10);
		robot5.setSpeed(10);
		
		robot1.setPenColor(Color.CYAN);
		robot2.setPenColor(Color.YELLOW);
		robot3.setPenColor(Color.BLACK);
		robot4.setPenColor(Color.GREEN);
		robot5.setPenColor(Color.RED);
		
		robot1.penDown();
		robot2.penDown();
		robot3.penDown();
		robot4.penDown();
		robot5.penDown();

		Thread r1 = new Thread(() -> {
			for(int i = 0; i < 360; i++) {
				robot1.move(2);
				robot1.turn(1);
			}
		});
		Thread r2 = new Thread(() -> {
			for(int i = 0; i < 360; i++) {
				robot2.move(2);
				robot2.turn(1);
			}
		});
		Thread r3 = new Thread(() -> {
			for(int i = 0; i < 360; i++) {
				robot3.move(2);
				robot3.turn(1);
			}
		});
		Thread r4 = new Thread(() -> {
			for(int i = 0; i < 360; i++) {
				robot4.move(2);
				robot4.turn(1);
			}
		});
		Thread r5 = new Thread(() -> {
			for(int i = 0; i < 360; i++) {
				robot5.move(2);
				robot5.turn(1);
			}
		});

		r1.start();
		r2.start();
		r3.start();
		r4.start();
		r5.start();
	}
}
