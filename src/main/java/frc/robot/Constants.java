// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
	/* Subsystem Objects */
	public static Arm arm = new Arm();
	public static DriveTrain driveTrain = new DriveTrain();
	public static Intake intake = new Intake();
	public static Shooter shooter = new Shooter();

	/* Controller and Axis IDs */
	public static final int driverID = 0;
	public static final int operatorID = 1;
	public static final int speedInput = 1;
	public static final int rotationInput = 4;
	public static final int armUp = 2;
	public static final int armDown = 3;

	/* Button IDS */
	public static final int OPShoot = 1;
	public static final int OPFloorIntake = 2;
	public static final int OPSpeaker = 3;
	public static final int OPReverseIntake = 999;

	/* Motor IDs */
	public static final int leftFront = 3;
	public static final int leftBack = 4;
	public static final int rightFront = 1;
	public static final int rightBack = 2;
	public static final int leftArm = 5;
	public static final int rightArm = 6;
	public static final int leftShooter = 7;
	public static final int rightShooter = 8;
	public static final int intakeID = 9;

	public static int checkSign(double num) {
		if (num > 0) {
			return 1;
		} else if (num < 0) {
			return -1;
		} else {
			return 0;
		}
	}
}
