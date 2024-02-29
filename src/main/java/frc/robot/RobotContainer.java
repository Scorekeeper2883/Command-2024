// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.Autos;
import frc.robot.commands.PrimitiveArmPivot;
import frc.robot.commands.Shoot;
import frc.robot.commands.takeIn;
import frc.robot.commands.drives.StickDrive;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
	/* RobotContainer Variables */
	private static final XboxController driverController = new XboxController(Constants.driverID);
	private static final XboxController operatorController = new XboxController(Constants.operatorID);
	private static SendableChooser<Command> autonomous = new SendableChooser<>();

	public RobotContainer() {
		configureBindings();

		/* Subsystem Default Command */
		Constants.driveTrain.setDefaultCommand(new StickDrive(() -> MathUtil.applyDeadband(-driverController.getRawAxis(Constants.speedInput), 0.2), () -> MathUtil.applyDeadband(driverController.getRawAxis(Constants.rotationInput), 0.2)));
		Constants.arm.setDefaultCommand(new PrimitiveArmPivot(() -> 0.4 * (MathUtil.applyDeadband(operatorController.getRawAxis(Constants.armUp), 0.2) - MathUtil.applyDeadband(operatorController.getRawAxis(Constants.armDown), 0.2))));

		/* Autonomous Selection */
		autonomous.setDefaultOption("Default Auto", Commands.none());
		autonomous.addOption("Simple Auto", Autos.SimpleAuto());
		SmartDashboard.putData("Autonomous", autonomous);
	}

	/**
	 * Use this method to define your trigger->command mappings. Triggers can be
	 * created via the
	 * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with
	 * an arbitrary
	 * predicate, or via the named factories in {@link
	 * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for
	 * {@link
	 * CommandXboxController
	 * Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
	 * PS4} controllers or
	 * {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
	 * joysticks}.
	 */
	private void configureBindings() {
		final JoystickButton shootHighPow = new JoystickButton(operatorController, Constants.OPShoot);
		final JoystickButton speaker = new JoystickButton(operatorController, Constants.OPSpeaker);
		final JoystickButton floorIntake = new JoystickButton(operatorController, Constants.OPFloorIntake);
		final JoystickButton reverseIntake = new JoystickButton(operatorController, Constants.OPReverseIntake);

		shootHighPow.onTrue(new Shoot(1.0)).onFalse(new Shoot(0));
		speaker.onTrue(new Shoot(1.0, 60)).onFalse(new Shoot(0));
		floorIntake.onTrue(new takeIn(1.0, -10)).onFalse(new takeIn(0));
		reverseIntake.onTrue(new takeIn(-0.8)).onFalse(new takeIn(0));
	}

	/**
	 * Use this to pass the autonomous command to the main {@link Robot} class.
	 *
	 * @return the command to run in autonomous
	 */
	public Command getAutonomousCommand() {
		// An example command will be run in autonomous
		return autonomous.getSelected();
	}
}
