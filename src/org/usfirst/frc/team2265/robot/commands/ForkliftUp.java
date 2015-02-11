package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * The ForkliftUp command is to move the forklift up.
 */
public class ForkliftUp extends Command {

    public ForkliftUp() {
        requires(Robot.forklift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.forklift.clock.reset();
    	Robot.forklift.clock.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.forklift.up();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.forklift.isSwitchSet() || Robot.forklift.clock.hasPeriodPassed(1.0);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.forklift.stop();
    	Robot.forklift.setEncoderValue();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}