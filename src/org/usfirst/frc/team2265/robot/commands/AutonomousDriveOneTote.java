package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutonomousDriveOneTote extends Command {

    public AutonomousDriveOneTote() {
    	requires(Robot.autoDriver);
      
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.autoDriver.frontLeftEnCount < 60){
    		//unsure if the field-oriented drive method will mean that robot orientation does not matter. 
    		//if the gyro does not compensate for what position the front of the robot is, 
    		//the correct code is commented out. 
    		Robot.autoDriver.driveRight();
    		//Robot.autoDriver.driveForward();
    	}
    	else if (Robot.autoDriver.frontRightEnCount < 90){
    		Robot.autoDriver.driveRight();
    		//Robot.autoDriver.driveForward();
    	}
    	else if (Robot.autoDriver.frontLeftEnCount < 115) {
    		Robot.autoDriver.driveForward();
    		//Robot.autoDriver.driveRight();
    	} else {
    		Robot.mecanumDrive.frontLeft.set(0);
    		Robot.mecanumDrive.frontRight.set(0);
    		Robot.mecanumDrive.rearLeft.set(0);
    		Robot.mecanumDrive.rearRight.set(0);
    	}
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
    }
}
