// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
	private static final CANSparkMax intakeMotor = new CANSparkMax(Constants.intakeID, MotorType.kBrushless);

	public Intake() {
		intakeMotor.setInverted(false);

		intakeMotor.setIdleMode(IdleMode.kBrake);
	}

	public void In(double pSpeed) {
		intakeMotor.set(pSpeed);
	}
}
