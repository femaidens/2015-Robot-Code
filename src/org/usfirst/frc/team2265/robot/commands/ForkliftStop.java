package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * The ForkliftStop command is to stop the forklift from moving.
 */ 
public class ForkliftStop extends Command {

    public ForkliftStop() {
    	requires(Robot.forklift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.forklift.initializeCounter();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.forklift.stop();
    	Robot.forklift.setForkliftDisplay();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
