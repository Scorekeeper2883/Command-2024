// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;

/**
 *  Drive runs the chassis through
 *  the DriveTrain subsystem.
 */
public class Drive extends Command {
  private double speed, rotation;

  /**
   * Creates a new Drive for
   * use of autonomous.
   */
  public Drive(double pSpeed, double pRotation) {
    speed = pSpeed;
    rotation = pRotation;

    addRequirements(Constants.driveTrain);
  }

  /**
   * Creates a new Drive for driving
   * with the stick.
   */
  public Drive(DoubleSupplier pSpeed, DoubleSupplier pRotation) {
    speed = pSpeed.getAsDouble();
    rotation = pRotation.getAsDouble();

    addRequirements(Constants.driveTrain);
  }

  /**
   * Sets the chassis motors' speeds
   * as directed by Drive() found in
   * DriveTrain.java.
   */
  @Override
  public void execute() {
    Constants.driveTrain.Drive(speed, rotation);
  }

  /**
   * Stops the chassis motors' rotation
   * when this command is finished or interrupted.
   */
  @Override
  public void end(boolean interrupted) {
    Constants.driveTrain.Drive(0.0, 0.0);
  }
}
