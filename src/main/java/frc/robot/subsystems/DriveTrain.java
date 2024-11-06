// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

/**
 * DriveTrain declares and controls all running
 * parts of the chassis.
 */
public class DriveTrain extends SubsystemBase {
  private static final Talon leftBackMotor    = new Talon(Constants.leftBack);
  private static final Talon leftFrontMotor   = new Talon(Constants.leftFront);
  private static final Talon rightBackMotor   = new Talon(Constants.rightBack);
  private static final Talon rightFrontMotor  = new Talon(Constants.rightFront);

  public DriveTrain() {
    leftBackMotor.setInverted(true);
    leftFrontMotor.setInverted(true);
    rightBackMotor.setInverted(false);
    rightFrontMotor.setInverted(false);

    leftFrontMotor.addFollower(leftBackMotor);
    rightFrontMotor.addFollower(rightBackMotor);
  }

  /**
   * Drive method for chassis control.
   * @param pSpeed    - foward/backwards
   * @param pRotation - left/right (steering)
   */
  public void DriveControl(double pSpeed, double pRotation) {
    leftFrontMotor.set(pSpeed+pRotation);
    rightFrontMotor.set(pSpeed-pRotation);
  }
}
