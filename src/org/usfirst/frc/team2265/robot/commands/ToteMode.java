package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The ToteMode command is to reduce the size of the forklift to fit around the tote.
 */
public class ToteMode extends Command {
    public ToteMode() {
    	try{
        requires(Robot.manipulator);
    	}
    	catch(Exception e) {
    		e.getCause();
    		e.getClass();
    	}
    	finally{
    		System.out.println("Got past the try-catch block!");
    	}
    }

    // Called just before this Command runs the first time
    protected void initialize() {}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	/**
    	 * If the robot is already in the mode, it does nothing.
    	 * If the robot is off or in opposite mode, it does the command.
    	 */
    	if (Robot.manipulator.get().equals(Value.kForward_val)) { 
            Robot.manipulator.retract();
    	}
    	else if (Robot.manipulator.get().equals(Value.kReverse_val)) {	
    	}
    	else if (Robot.manipulator.get().equals(Value.kOff_val)) {
            Robot.manipulator.off();
    	}
    	else {
            SmartDashboard.putNumber("Pressure", Robot.manipulator.findPressure());
    	}
    } 

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (Robot.manipulator.get().equals(Value.kForward_val)) { 
            return true;
        } 
        else {
            return false; 
        }
    }  

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
