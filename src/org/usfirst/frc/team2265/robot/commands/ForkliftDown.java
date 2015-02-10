package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;


/**
 * The ForkliftDown command is to move the forklift down.
 */
public class ForkliftDown extends Command {

    public ForkliftDown() {
    	requires(Robot.forklift);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.forklift.clock.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.forklift.down();
    	Robot.forklift.setForkliftDisplay();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.forklift.isSwitchSet() || Robot.forklift.clock.hasPeriodPassed(1.0);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.forklift.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}