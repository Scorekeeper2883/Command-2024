// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;

/**
 * DanceCommand sways the robot left and
 *  right to the rhythm of the music in 
 *  its soul.
 */
public class DanceCommand extends Command {
  /* DanceCommand Variables */
  private static double danceStart;
  private static int cupidReverse = 1;

  public DanceCommand() {
    danceStart = Timer.getFPGATimestamp();
    
    addRequirements(Constants.driveTrain);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if((Timer.getFPGATimestamp()-danceStart)%1.0 == 0) {
        cupidReverse *= -1;
    }
    Constants.driveTrain.Drive(0.0, cupidReverse*0.5); 
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Constants.driveTrain.Drive(0.0, 0.0);
  }
}
