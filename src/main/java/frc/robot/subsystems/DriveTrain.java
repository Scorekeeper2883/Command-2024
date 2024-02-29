// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

/**
 * DriveTrain declares and controls all running
 * parts of the chassis.
 */
public class DriveTrain extends SubsystemBase {
	/* DriveTrain Variables */
	private static final VictorSPX leftFrontMotor = new VictorSPX(Constants.leftFront);
	private static final VictorSPX leftBackMotor = new VictorSPX(Constants.leftBack);
	private static final VictorSPX rightFrontMotor = new VictorSPX(Constants.rightFront);
	private static final VictorSPX rightBackMotor = new VictorSPX(Constants.rightBack);

	public DriveTrain() {
		/* Motor Invert Settings */
		leftFrontMotor.setInverted(true);
		leftBackMotor.setInverted(true);
		rightFrontMotor.setInverted(false);
		rightBackMotor.setInverted(false);

		/* Motor Neutral Settings */
		leftFrontMotor.setNeutralMode(NeutralMode.Brake);
		leftBackMotor.setNeutralMode(NeutralMode.Brake);
		rightFrontMotor.setNeutralMode(NeutralMode.Brake);
		rightBackMotor.setNeutralMode(NeutralMode.Brake);

		/* Declares Motor's Leader (Who It Follows) */
		leftBackMotor.follow(leftBackMotor);
		rightBackMotor.follow(rightFrontMotor);
	}

	/**
	 * Drive method for chassis control.
	 * 
	 * @param pSpeed    - foward/backwards
	 * @param pRotation - left/right steering
	 */
	public void Drive(double pSpeed, double pRotation) {
		leftFrontMotor.set(VictorSPXControlMode.Velocity, pSpeed);
		rightFrontMotor.set(VictorSPXControlMode.Velocity, pRotation);
	}
}
