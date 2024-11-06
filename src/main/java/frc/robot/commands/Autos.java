// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

/**
 * Autos contains each Auto the robot uses
 * through the use of seperate methods per Auto.
 */
public class Autos {
  public Autos() {
    throw new UnsupportedOperationException("This is a Utility Class!");
  }

  /**
   * Waits for 2 seconds, then drives
   * fowards for three seconds to cross
   * the starting line. (5s Auto)
   */
  public static Command SimpleAuto() {
    return
      new SequentialCommandGroup(
        new WaitCommand(2.0),
        new Drive(0.35, 0.0).withTimeout(3.0)
      );
  }

  /**
   * Spins right for 3.5 seconds, then
   * spins left for 3.5 seconds afer 
   * waiting 0.1 seconds to allow
   * the robot's motors to stop rotation
   * before changing rotation direction.
   * Does this process twice. (14.3s Auto)
   */
  public static Command ControlledSpin() {
    return
      new SequentialCommandGroup(
        new Drive(0.0, 0.5).withTimeout(3.5),
        new WaitCommand(0.1),
        new Drive(0.0, -0.5).withTimeout(3.5),
        new WaitCommand(0.1),
        new Drive(0.0, 0.5).withTimeout(3.5),
        new WaitCommand(0.1),
        new Drive(0.0, -0.5).withTimeout(3.5)
      );
  }
}
