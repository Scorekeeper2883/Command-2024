// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase {
	private static final CANSparkMax leftArmMotor = new CANSparkMax(Constants.leftArm, MotorType.kBrushless);
	private static final CANSparkMax rightArmMotor = new CANSparkMax(Constants.rightArm, MotorType.kBrushless);
	private static final RelativeEncoder encodeArm = leftArmMotor.getAlternateEncoder(42);
	private static final double armGearRatio = 248 / 1;
	private static final double upperArmBound = 90;
	private static final double lowerArmBound = -10;

	public Arm() {
		leftArmMotor.setInverted(true);
		rightArmMotor.setInverted(false);

		leftArmMotor.setIdleMode(IdleMode.kBrake);
		rightArmMotor.setIdleMode(IdleMode.kBrake);

		encodeArm.setPositionConversionFactor(360 / encodeArm.getCountsPerRevolution() / armGearRatio);
		encodeArm.setPosition(90);	// Make sure the arm starts straight up!
	}

	public void PrimitiveArmPivot(double pSpeed) {
		if (pSpeed > 0 && getAngle() < upperArmBound) {
			leftArmMotor.set(pSpeed);
			rightArmMotor.set(pSpeed);
		} else if (pSpeed < 0 && getAngle() > lowerArmBound) {
			leftArmMotor.set(pSpeed);
			rightArmMotor.set(pSpeed);
		}
	}

	public double getAngle() {
		return encodeArm.getPosition();
	}

	public void setAngle(double pAngle) {
		while (pAngle - getAngle() != 0) {
			PrimitiveArmPivot(Constants.checkSign(pAngle - getAngle()) * 0.45);
		}
	}
}
