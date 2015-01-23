
package org.usfirst.frc.team2265.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.command.PIDSubsystem;

import org.usfirst.frc.team2265.robot.Robot;

/**
 *
 */
 
public class PIDCommand extends Command {	
	
    public PIDCommand() {		// Set values????
        // commands depends on PID subsystem
        requires(Robot.pid);		
    }

    // Called just before this Command runs the first time
    protected void initialize() {}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	 Robot.pid.enable();		// Starts PID
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;		// This should always be false, PID runs as long as the robot is on
    }

    // Called once after isFinished returns true (which is never)
    // PID is always running, no interrupt needed
    protected void end() {}

    // PID is always running, no interrupt needed
    protected void interrupted() {}
}
