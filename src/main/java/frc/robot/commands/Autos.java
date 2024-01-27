// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.drives.AutoDrive;

/**
 * Autos holds the method
 *  of each Autonomous our
 *  robot uses.
 */
public class Autos {
  public Autos() {
    throw new UnsupportedOperationException("This is a Utility Class!");
  }

  /**
   * Waits for 10 seconds, then drives
   *  fowards for three seconds to cross 
   *  the starting line. (3s Auto)
   */
  public static Command DefaultAuto() {
    return
      new SequentialCommandGroup(
        new WaitCommand(2.0),
        new ParallelRaceGroup(
          new WaitCommand(3.0),
          new AutoDrive(0.25, 0.0)
        )
      );
  }
}
