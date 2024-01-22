// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

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
   *  the starting line. (13s Auto)
   */
  public static final Command DefaultAuto() {
    return
      new SequentialCommandGroup(
        // new WaitCommand(10.0),
        new ParallelRaceGroup(
          new WaitCommand(3.0),
          new DriveCommand(0.5, 0.0)
        )
      );
  }

  /**
   * Drives along the wall to cross the
   *  starting line. (5s Auto)
   */
  public static final Command WallHuggerAuto() {
    return 
      new SequentialCommandGroup(
        new ParallelRaceGroup(
          new WaitCommand(0.5),
          new DriveCommand(0.0, 0.5)
        ),
        new ParallelRaceGroup(
          new WaitCommand(1.0),
          new DriveCommand(0.5, 0.0)
        ),
        new ParallelRaceGroup(
          new WaitCommand(0.5),
          new DriveCommand(0.0, -0.5)
        ),
        new ParallelRaceGroup(
          new WaitCommand(3.0),
          new DriveCommand(0.5, 0.0)
        )
      );
  }
}
