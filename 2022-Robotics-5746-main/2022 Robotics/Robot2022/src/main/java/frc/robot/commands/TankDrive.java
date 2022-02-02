/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class TankDrive extends CommandBase {
  /**
   * Creates a new TankDrive.
   */
  public TankDrive() {
    // Use addRequirements() here to declare subsystem dependencies.
    requires(Robot.driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftStickY = Robot.m_robotContainer.getDriverRawAxis(Constants.LEFT_STICK_Y);
    double rightStickY = Robot.m_robotContainer.getDriverRawAxis(Constants.RIGHT_STICK_Y);

    Robot.driveTrain.setLeftMotors(leftStickY * (0.5)); //0.5 scales the sensitivity of the motors - Change this value to change the sensitivity of the motors - can also multiply it by itself to get exponential scaline
    Robot.driveTrain.setRightMotors(rightStickY * (0.5)); //Can later turn this scale factor into constants so it can be easily changed an accessed

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.driveTrain.setLeftMotors(0); //ensures that if something else were to happen to the drivetrain that the motors would shut off
    Robot.driveTrain.setRightMotors(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
