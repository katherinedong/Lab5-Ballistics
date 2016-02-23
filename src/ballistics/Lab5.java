/*
 * Group: 41
 * Katy Dong      (260610798)
 * Arta Riazrafat (260636821)
 */

package ballistics;

import lejos.hardware.Button;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.motor.EV3LargeRegulatedMotor;

public class Lab5 {

	private static final EV3LargeRegulatedMotor rightMotor = new EV3LargeRegulatedMotor(
			LocalEV3.get().getPort("A"));
	private static final EV3LargeRegulatedMotor leftMotor = new EV3LargeRegulatedMotor(
			LocalEV3.get().getPort("C"));
	private static int throwAccel = 2000000;
	private static int throwSpeed = 20000;
	private static int returnAccel = 400;
	private static int returnSpeed = 100;
	private static int initAngle = -100;

	public static void main(String[] args) {

		while (true) {
			int buttonChoice = Button.waitForAnyPress();
			// When the bottom button is pressed, swing the catapult at max
			// speed and acceleration
			if (buttonChoice == Button.ID_DOWN) {
				// Set acceleration to max acceleration
				rightMotor.setAcceleration(throwAccel);
				leftMotor.setAcceleration(throwAccel);

				// Set speed to max speed
				rightMotor.setSpeed(throwSpeed);
				leftMotor.setSpeed(throwSpeed);

				// Rotate to throw ball
				rightMotor.rotateTo(initAngle, true);
				leftMotor.rotateTo(initAngle, false);

				// Rotate the catapult back to the initial position at a slower
				// speed and acceleration to prepare for the next swing
			} else if (buttonChoice == Button.ID_LEFT) {
				// Set return acceleration
				rightMotor.setAcceleration(returnAccel);
				leftMotor.setAcceleration(returnAccel);

				// Set speed so that it returns to its initial position slowly
				rightMotor.setSpeed(returnSpeed);
				leftMotor.setSpeed(returnSpeed);

				// Go back to initial position
				rightMotor.rotateTo(0, true);
				leftMotor.rotateTo(0, false);

				// Exit the program
			} else if (buttonChoice == Button.ID_UP) {
				System.exit(0);
			}
		}
	}
}