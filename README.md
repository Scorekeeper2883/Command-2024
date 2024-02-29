# Command 2024
# Basic FRC Code in Java that has a Basic Auto and Drives the Chassis.

\java\frc\robot
  \commands
    \drives\AutoDrive.java
      - File that controls the chassis seperately from StickDrive.java as to prevent any Autos from hijacking the entire chassis.
    \drives\StickDrive.java
      - File that controls the chassis seperately from AutoDrive.java as to maintain default control of the chassis.
    \Autos.java
      - File to house each Autonomous in the form of individual methods.
  \subsystems
    \DriveTrain.java
      - File that houses the chassis subsystem, which defines what is in the chassis and how it works.
  \Constants.java
    - File that houses "global" constants and variables used in other files.
  \Main.java
    - File that starts-up the robot code and should NEVER be messed with unless you guarantee know what you are doing.
  \Robot.java
    - File that directs what the robot does during the different aspects of the FRC Game.
  \RobotContainer.java
    - File that contains the bulk of the robot declarations, including the controller, buttons, and commands.
