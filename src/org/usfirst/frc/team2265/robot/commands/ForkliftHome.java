package org.usfirst.frc.team2265.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2265.robot.Robot;

/**
 *
 */
public class ForkliftHome extends Command {

    public ForkliftHome() {
        requires(Robot.forklift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.forklift.down();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.forklift.isSwitchSet();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.forklift.stop();
    	Robot.forklift.resetCounter();
    	Robot.forklift.resetEncoder();
    	Robot.forklift.setLvl(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    	
    }
}