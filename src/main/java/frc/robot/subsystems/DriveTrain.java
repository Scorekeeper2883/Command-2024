// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

/**
 * DriveTrain declares and controls all running
 * parts of the chassis.
 */
public class DriveTrain extends SubsystemBase {
  private static final CANSparkMax leftBackMotor    = new CANSparkMax(Constants.leftBack, MotorType.kBrushed);
  private static final CANSparkMax leftFrontMotor   = new CANSparkMax(Constants.leftFront, MotorType.kBrushed);
  private static final CANSparkMax rightBackMotor   = new CANSparkMax(Constants.rightBack, MotorType.kBrushed);
  private static final CANSparkMax rightFrontMotor  = new CANSparkMax(Constants.rightFront, MotorType.kBrushed);

  public DriveTrain() {
    leftBackMotor.setInverted(true);
    leftFrontMotor.setInverted(true);
    rightBackMotor.setInverted(false);
    rightFrontMotor.setInverted(false);

    leftBackMotor.setIdleMode(IdleMode.kBrake);
    leftFrontMotor.setIdleMode(IdleMode.kBrake);
    rightBackMotor.setIdleMode(IdleMode.kBrake);
    rightFrontMotor.setIdleMode(IdleMode.kBrake);

    leftBackMotor.follow(leftFrontMotor);
    rightBackMotor.follow(rightFrontMotor);
  }

  /**
   * Drive method for chassis control.
   * @param pSpeed    - foward/backwards
   * @param pRotation - left/right (steering)
   */
  public void Drive(double pSpeed, double pRotation) {
    leftFrontMotor.set(pSpeed+pRotation);
    rightFrontMotor.set(pSpeed-pRotation);
  }
}
//needed to test commit