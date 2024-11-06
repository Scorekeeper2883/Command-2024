// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;

/**
 *  Drive runs the chassis through
 *  the DriveTrain subsystem.
 */
public class Drive extends Command {
  private double speed, rotation;
  private boolean isStick = false;

  /**
   * Creates a new Drive for
   * use of autonomous.
   */
  public Drive(double pSpeed, double pRotation) {
    speed = pSpeed;
    rotation = pRotation;
    isStick = false;

    addRequirements(Constants.driveTrain);
  }

  /**
   * Creates a new Drive for driving
   * with the stick.
   */
  public Drive() {
    isStick = true;

    addRequirements(Constants.driveTrain);
  }

  /**
   * Sets the chassis motors' speeds
   * as directed by Drive() found in
   * DriveTrain.java.
   */
  @Override
  public void execute() {
    if(isStick) {
      Constants.driveTrain.DriveControl(
        RobotContainer.driverController.getRawAxis(Constants.speedInput),
        RobotContainer.driverController.getRawAxis(Constants.rotationInput));
    } else {
      Constants.driveTrain.DriveControl(speed, rotation);
    }
  }

  /**
   * Stops the chassis motors' rotation
   * when this command is finished or interrupted.
   */
  @Override
  public void end(boolean interrupted) {
    isStick = false;
    Constants.driveTrain.DriveControl(0.0, 0.0);
  }
}
