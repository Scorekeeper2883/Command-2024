// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;

/**
 * StickDrive runs the chassis through
 *  the DriveTrain subsystem (with controller).
 */
public class StickDrive extends Command {
  /**
   * Creates a new StickDrive.
   * @param pSpeed    - See DriveTrain.Drive() pSpeed.
   * @param pRotation - See DriveTrain.Drive() pRotation.
   */
  public StickDrive() {
    addRequirements(Constants.driveTrain);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Constants.driveTrain.Drive(
      RobotContainer.driverController.getRawAxis(Constants.speedInput),
      RobotContainer.driverController.getRawAxis(Constants.rotationInput));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Constants.driveTrain.Drive(0.0, 0.0);
  }
}
