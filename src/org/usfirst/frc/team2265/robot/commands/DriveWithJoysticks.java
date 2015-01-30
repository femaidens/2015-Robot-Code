package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.Robot;
//import org.usfirst.frc.team2265.robot.subsystems.MecanumDrive;
import edu.wpi.first.wpilibj.command.Command;


/**
 *
 */
public class DriveWithJoysticks extends Command {
	//public MecanumDrive mecanumDrive = new MecanumDrive();
    public DriveWithJoysticks() {
    	requires(Robot.mecanumDrive);
    	//requires(Robot.DriveControl);
    
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.mecanumDrive.drive();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.mecanumDrive.initDefaultCommand();
    	
    }
}
