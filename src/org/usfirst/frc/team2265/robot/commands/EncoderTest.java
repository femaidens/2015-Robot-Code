package org.usfirst.frc.team2265.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2265.robot.Robot;

/**
 *
 */
public class EncoderTest extends Command {

    public EncoderTest() {
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
    	Robot.forklift.setEncoderValue();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.forklift.isSwitchSet() || Robot.forklift.clock.hasPeriodPassed(3.0);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.forklift.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.forklift.stop();
    }
}
