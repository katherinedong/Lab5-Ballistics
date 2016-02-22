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
	private static int initAngle = -120;

	public static void main(String[] args) {

		while (true) {
			int buttonChoice = Button.waitForAnyPress();
			if (buttonChoice == Button.ID_DOWN) {
				rightMotor.setAcceleration(throwAccel);
				leftMotor.setAcceleration(throwAccel);

				rightMotor.setSpeed(throwSpeed);
				leftMotor.setSpeed(throwSpeed);

				rightMotor.rotateTo(initAngle, true);
				leftMotor.rotateTo(initAngle, false);
			} else if (buttonChoice == Button.ID_LEFT) {
				rightMotor.setAcceleration(returnAccel);
				leftMotor.setAcceleration(returnAccel);

				rightMotor.setSpeed(returnSpeed);
				leftMotor.setSpeed(returnSpeed);

				rightMotor.rotateTo(0, true);
				leftMotor.rotateTo(0, false);
			} else if (buttonChoice == Button.ID_UP) {
				System.exit(0);
			}
		}
	}
}
