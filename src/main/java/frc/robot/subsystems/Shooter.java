// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
	private static final CANSparkMax leftShooterMotor = new CANSparkMax(Constants.leftShooter, MotorType.kBrushless);
	private static final CANSparkMax rightShooterMotor = new CANSparkMax(Constants.rightShooter, MotorType.kBrushless);

	public Shooter() {
		leftShooterMotor.setInverted(false);
		rightShooterMotor.setInverted(true);

		leftShooterMotor.setIdleMode(IdleMode.kBrake);
		rightShooterMotor.setIdleMode(IdleMode.kBrake);
	}

	public void Shoot(double pSpeed) {
		if (pSpeed > 0) {
			leftShooterMotor.set(pSpeed);
			rightShooterMotor.set(pSpeed);
		}
	}
}
