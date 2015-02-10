package org.usfirst.frc.team2265.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2265.robot.Robot;

/**
 *
 */
public class Forklift2 extends Command {

    public Forklift2() {
    	requires(Robot.forklift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Robot.forklift.get() > Robot.forklift.TOTEHEIGHT + Robot.forklift.PLATHEIGHT + 3) {
    		Robot.forklift.down();
    	}
    	else if (Robot.forklift.get() < Robot.forklift.TOTEHEIGHT + Robot.forklift.PLATHEIGHT + 3) {
    		Robot.forklift.up();
    	}
    	else {
    		end();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.forklift.get() == Robot.forklift.TOTEHEIGHT + Robot.forklift.PLATHEIGHT + 3;
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
