package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

/**
 * The BinMode command is to increase the size of the forklift to make it fit around the bin.!!!
 */
public class BinMode extends Command {

    public BinMode() {
    	requires(Robot.manipulator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//if already in the mode does nothings
    	//if off or in opposite mode does command
    	if (Robot.manipulator.get().equals(Value.kForward_val)) { 
    		}
    	else if (Robot.manipulator.get().equals(Value.kReverse_val)) {
    		Robot.manipulator.extend();
    		}
    	else if (Robot.manipulator.get().equals(Value.kOff_val)) {
    		Robot.manipulator.extend();
    		}
    	else{
    		SmartDashboard.putNumber("Pressure", Robot.manipulator.findPressure());
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (Robot.manipulator.get().equals(Value.kForward_val)) { 
    		return false;
    		}
    	else {
    		return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}