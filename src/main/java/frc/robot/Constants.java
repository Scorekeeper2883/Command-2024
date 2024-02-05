// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.subsystems.DriveTrain;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  /* Subsystem Objects */
  public static DriveTrain driveTrain = new DriveTrain();

  /* Driver Preferences */
  public static final boolean isArcade = true; // true for Arcade, false for Tank

  /* Controller and Axis IDs */
  public static final int driverID = 0;
  public static final int speedInput = 1;
  public static final int rotationInput = 4;

  /* Motor IDs */
  public static final int leftFront = 3;
  public static final int leftBack = 4;
  public static final int rightFront = 1;
  public static final int rightBack = 2;
}
