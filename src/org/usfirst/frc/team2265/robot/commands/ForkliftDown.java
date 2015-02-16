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
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.forklift.down();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double pos = Robot.forklift.getEncoderValue();
    	return Robot.forklift.isSwitchSet() || pos == Robot.forklift.getLvl(Robot.forklift.curLvl - 1);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.forklift.stop();
    	Robot.forklift.resetCounter();
    	Robot.forklift.setLvl(Robot.forklift.curLvl - 1);
    	Robot.forklift.setForkliftDisplay(Robot.forklift.curLvl - 1);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}