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
 *  parts of the chassis.
 */
public class DriveTrain extends SubsystemBase {
  /* DriveTrain Variables */
  private static final CANSparkMax leftFrontMotor   = new CANSparkMax(Constants.leftFront, MotorType.kBrushed);
  private static final CANSparkMax leftBackMotor    = new CANSparkMax(Constants.leftBack, MotorType.kBrushed);
  private static final CANSparkMax rightFrontMotor  = new CANSparkMax(Constants.rightFront, MotorType.kBrushed);
  private static final CANSparkMax rightBackMotor   = new CANSparkMax(Constants.rightBack, MotorType.kBrushed);

  public DriveTrain() {
    /* Motor Invert Settings*/
    leftFrontMotor.setInverted(true);
    leftBackMotor.setInverted(true);
    rightFrontMotor.setInverted(false);
    rightBackMotor.setInverted(false);

    /* Motor Idle Settings */
    leftFrontMotor.setIdleMode(IdleMode.kBrake);
    leftBackMotor.setIdleMode(IdleMode.kBrake);
    rightFrontMotor.setIdleMode(IdleMode.kBrake);
    rightBackMotor.setIdleMode(IdleMode.kBrake);

    /* Declares Motor's Leader (Who It Follows) */
    leftBackMotor.follow(leftFrontMotor);
    rightBackMotor.follow(rightFrontMotor);
  }

  /**
   * Drive method for chassis control.
   * @param pSpeed    - foward/backwards for Arcade, leftside motors for Tank
   * @param pRotation - left/right steering for Arcade, rightside motors for Tank
   */
  public void Drive(double pSpeed, double pRotation) {
    double speedIsSquared = pSpeed > 0 ? pSpeed * pSpeed : pSpeed * pSpeed * -1;
    double rotationIsSquared = pRotation > 0 ? pRotation * pRotation : pRotation * pRotation * -1;

    if(Constants.isArcade) {
      leftFrontMotor.set(speedIsSquared+rotationIsSquared);
      rightFrontMotor.set(speedIsSquared-rotationIsSquared);
    } else {
      leftFrontMotor.set(speedIsSquared);
      rightFrontMotor.set(rotationIsSquared);
    }
  }
}
